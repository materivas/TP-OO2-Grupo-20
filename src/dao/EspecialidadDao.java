package dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Especialidad;
import datos.Empleado;

public class EspecialidadDao {
	private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(Especialidad objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();

        }
        return id;
    }
    
    
    public int agregarEmpleado(Especialidad especialidad, Empleado empleado) throws HibernateException {
        try {
            iniciaOperacion();
            
            // Verificar si ya existe la relación
            boolean existe = session.createQuery(
                "SELECT 1 FROM Especialidad e JOIN e.empleados emp " +
                "WHERE e.idEspecialidad = :idEsp AND emp.idPersona = :idEmp")
                .setParameter("idEsp", especialidad.getIdEspecialidad())
                .setParameter("idEmp", empleado.getIdPersona())
                .uniqueResult() != null;
            
            if (existe) {
                throw new HibernateException(
                    String.format("El empleado (ID: %d) ya está asignado a la especialidad (ID: %d)",
                    empleado.getIdPersona(), especialidad.getIdEspecialidad()));
            }
            
            // Si no existe, agregar la relación
            if (especialidad.getEmpleados() == null) {
                especialidad.setEmpleados(new HashSet<>());
            }
            especialidad.getEmpleados().add(empleado);
            session.update(especialidad);
            tx.commit();
            return 1; // Éxito
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    

    public void actualizar(Especialidad objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void eliminar(Especialidad objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }


	public Especialidad traerEspecialidad(long idEspecialidad) {
        Especialidad objeto = null;
        try {
            iniciaOperacion();
            objeto = session.get(Especialidad.class, idEspecialidad);
        } finally {
            session.close();
        }
        return objeto;
    }

	public Especialidad traerEspecialidadYEmpleados(long idEspecialidad) {
        Especialidad objeto = null;
        try {
            iniciaOperacion();
            String hql="SELECT e FROM Especialidad e INNER JOIN FETCH e.empleados WHERE e.idEspecialidad = :idEspecialidad";
            objeto = (Especialidad) session.createQuery(hql).setParameter("idEspecialidad", idEspecialidad).uniqueResult();
            Hibernate.initialize(objeto.getEmpleados());
        } finally {
            session.close();
        }
        return objeto;
    }
	
	
	public Especialidad traerEspecialidadCompleto(long idEspecialidad) {
	    Especialidad objeto = null;
	    try {
	        iniciaOperacion();
	        String hql = "SELECT DISTINCT e FROM Especialidad e "
	                   + "LEFT JOIN FETCH e.empleados emp "
	                   + "LEFT JOIN FETCH emp.rol "
	                   + "WHERE e.idEspecialidad = :id";
	        objeto = session.createQuery(hql, Especialidad.class)
	                      .setParameter("id", idEspecialidad)
	                      .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return objeto;
	}
	
	public List<Especialidad> traerTodasEspecialidades() {
        List<Especialidad> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Especialidad", Especialidad.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public int eliminarEmpleado(Especialidad especialidad, long idEmpleado) throws HibernateException {
        try {
            iniciaOperacion();
            
            // Recargar la especialidad con empleados
            Especialidad esp = (Especialidad) session.createQuery(
                "SELECT DISTINCT e FROM Especialidad e LEFT JOIN FETCH e.empleados WHERE e.idEspecialidad = :id")
                .setParameter("id", especialidad.getIdEspecialidad())
                .uniqueResult();
            
            // Buscar y eliminar el empleado
            boolean eliminado = esp.getEmpleados().removeIf(e -> e.getIdPersona() == idEmpleado);
            
            if (!eliminado) {
                throw new HibernateException("El empleado no estaba asignado a esta especialidad");
            }
            
            session.update(esp);
            tx.commit();
            return 1;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

}
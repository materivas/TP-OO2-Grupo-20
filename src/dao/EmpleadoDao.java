package dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Especialidad;

public class EmpleadoDao {
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

    public int agregar(Empleado objeto) {
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
    
    public int agregarEspecialidad(Empleado empleado, Especialidad especialidad) throws HibernateException {
        try {
            iniciaOperacion();
            
            // Verificar si ya existe la relación
            boolean existe = session.createQuery(
                "SELECT 1 FROM Empleado e JOIN e.especialidades esp " +
                "WHERE e.idPersona = :idEmp AND esp.idEspecialidad = :idEsp")
                .setParameter("idEmp", empleado.getIdPersona())
                .setParameter("idEsp", especialidad.getIdEspecialidad())
                .uniqueResult() != null;
            
            if (existe) {
                throw new HibernateException(
                    String.format("La especialidad (ID: %d) ya está asignada al empleado (ID: %d)",
                    especialidad.getIdEspecialidad(), empleado.getIdPersona()));
            }
            
            // Si no existe, agregar la relación
            if (empleado.getEspecialidades() == null) {
                empleado.setEspecialidades(new HashSet<>());
            }
            empleado.getEspecialidades().add(especialidad);
            session.update(empleado);
            tx.commit();
            return 1; // Éxito
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    
    public int eliminarEspecialidad(Empleado empleado, Especialidad especialidad) throws HibernateException {
        try {
            iniciaOperacion();
            
            // Cargar el empleado y sus especialidades en la misma sesión
            String hql = "FROM Empleado e LEFT JOIN FETCH e.especialidades WHERE e.idPersona = :idEmp";
            Empleado emp = (Empleado) session.createQuery(hql)
                                          .setParameter("idEmp", empleado.getIdPersona())
                                          .uniqueResult();
            
            if (emp == null) {
                throw new HibernateException("No se encontró el empleado con ID: " + empleado.getIdPersona());
            }
            
            // Cargar la especialidad en la misma sesión
            Especialidad esp = session.get(Especialidad.class, especialidad.getIdEspecialidad());
            if (esp == null) {
                throw new HibernateException("No se encontró la especialidad con ID: " + especialidad.getIdEspecialidad());
            }
            
            // Verificar si existe la relación
            boolean existe = false;
            for (Especialidad e : emp.getEspecialidades()) {
                if (e.getIdEspecialidad() == esp.getIdEspecialidad()) {
                    existe = true;
                    break;
                }
            }
            
            if (!existe) {
                throw new HibernateException(
                    String.format("La especialidad (ID: %d) no está asignada al empleado (ID: %d)",
                    especialidad.getIdEspecialidad(), empleado.getIdPersona()));
            }
            
            // Eliminar la relación
            emp.getEspecialidades().remove(esp);
            session.update(emp);
            tx.commit();
            return 1; // Éxito
            
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    
    

    public void actualizar(Empleado objeto) {
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

    public void eliminar(Empleado objeto) {
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


   
	public Empleado traerEmpleado(long idEmpleado) {
		Empleado objeto = null;
	    try {
	        iniciaOperacion();
	        String hql = "SELECT DISTINCT e FROM Empleado e "
	                   + "LEFT JOIN FETCH e.rol "
	                   + "LEFT JOIN FETCH e.especialidades "
	                   + "WHERE e.idPersona = :id";
	        objeto = session.createQuery(hql, Empleado.class)
	                      .setParameter("id", idEmpleado)
	                      .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return objeto;
    }
	
	/*public Especialidad traerEspecialidadCompleto(long idEspecialidad) {
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
	}*/
	
	public Empleado traerEmpleadoConRol(long idEmpleado) {
	    Empleado objeto = null;
	    try {
	        iniciaOperacion();
	        String hql = "FROM Empleado e LEFT JOIN FETCH e.rol WHERE e.idPersona = :id";
	        objeto = session.createQuery(hql, Empleado.class)
	                      .setParameter("id", idEmpleado)
	                      .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return objeto;
	}


    public Empleado traerEmpleadoCuil(long cuil) {
        Empleado objeto = null;

        try {
            iniciaOperacion();
            objeto = (Empleado) session.createQuery("from Empleado e where e.cuil ="+cuil).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }
    
    public Empleado traerEmpleadoPorDni (int dni) {
    	
    	Empleado objeto = null;

        try {
            iniciaOperacion();
            objeto = (Empleado) session.createQuery("from Empleado e where e.dni ="+dni).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    	
    }

    public List<Empleado> traerEmpleado() throws HibernateException {
    	List<Empleado> lista=null;
        try {
            iniciaOperacion();
            lista = session.createQuery("SELECT DISTINCT e FROM Empleado e " +
            	    "LEFT JOIN FETCH e.rol " +
            	    "LEFT JOIN FETCH e.especialidades " +
            	    "ORDER BY e.apellido ASC, e.nombre ASC"
            	    , Empleado.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public Empleado traerEmpleadoYEspecialidad(long idPersona) {
        Empleado objeto = null;
        try {
            iniciaOperacion();
            String hql = "from Empleado e left join fetch e.especialidades where e.idPersona = :idPersona";
            objeto = session.createQuery(hql, Empleado.class)
                          .setParameter("idPersona", idPersona)
                          .uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }



}
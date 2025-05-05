package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Especialidad;

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
            objeto = (Especialidad) session.get(Especialidad.class, idEspecialidad);
        } finally {
            session.close();
        }
        return objeto;
    }
	  
	public Especialidad traerEspecialidadYClientes(long idEspecialidad) {
        Especialidad objeto = null;
        try {
            iniciaOperacion();
            String hql="SELECT e FROM Especialidad e LEFT JOIN FETCH e.empleados WHERE e.idEspecialidad = :idEspecialidad";
            objeto = (Especialidad) session.createQuery(hql).setParameter("idEspecialidad", idEspecialidad).uniqueResult();
            Hibernate.initialize(objeto.getEmpleados());
        } finally {
            session.close();
        }
        return objeto;
    }
    
}
package dao;

import datos.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
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

    public int agregar(Cliente objeto) {
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
    
    

    public void actualizar(Cliente objeto) {
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

    public void eliminar(Cliente objeto) {
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

    /*public Cliente traerCliente(long idCliente) {
    	Cliente objeto = null;

        try {
            iniciaOperacion();
            objeto = (Cliente) session.createQuery("from Cliente c where c.idPersona ="+idCliente).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }*/
    
    public Cliente traerCliente(long idCliente) {
        Cliente objeto = null;
        try {
            iniciaOperacion();
            String hql = "SELECT DISTINCT c FROM Cliente c "
                       + "LEFT JOIN FETCH c.turnos t "
                       + "LEFT JOIN FETCH t.detalle "
                       + "LEFT JOIN FETCH t.empleado "
                       + "LEFT JOIN FETCH t.servicio "
                       + "WHERE c.idPersona = :id";
            objeto = session.createQuery(hql, Cliente.class)
                          .setParameter("id", idCliente)
                          .uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

	public Cliente traerClientePorDni(int dni) {
		Cliente objeto = null;

        try {
            iniciaOperacion();
            objeto = (Cliente) session.createQuery("from Cliente c where c.dni ="+dni).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
	}
}
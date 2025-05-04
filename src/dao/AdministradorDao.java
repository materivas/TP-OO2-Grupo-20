package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Administrador;

public class AdministradorDao {
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

    public int agregar(Administrador objeto) {
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

    public void actualizar(Administrador objeto) {
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

    public void eliminar(Administrador objeto) {
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

    public Administrador traerAdministrador(String user) {
        Administrador admin = null;
        try {
            iniciaOperacion();
            admin = (Administrador) session.createQuery("from Administrador a where a.user = :user")
                .setParameter("user", user)
                .uniqueResult();
        } finally {
            session.close();
        }
        return admin;
    }
    
    public List<Administrador> traerAdministradores() throws HibernateException {
        List<Administrador> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Administrador a order by a.apellido asc, a.nombre asc", Administrador.class).list();
        } finally {
            session.close();
        }
        return lista;
    }
    
}
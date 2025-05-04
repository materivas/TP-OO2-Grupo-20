package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Rol;

public class RolDao {
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

    public int agregar(Rol objeto) {
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
    
    
    //traerRol por NOMBRE
    public Rol traerRol(String nombreRol) {
        Rol rol = null;
        try {
            iniciaOperacion();
            rol = (Rol) session.createQuery("from Rol r where r.nombreRol = :nombre")
                .setParameter("nombre", nombreRol)
                .uniqueResult();
        } finally {
            session.close();
        }
        return rol;
    }
    
    //traerRol por ID
    public Rol traerRol(int idRol) {
        Rol rol = null;
        try {
            iniciaOperacion();
            rol = session.get(Rol.class, idRol);
        } finally {
            session.close();
        }
        return rol;
    }
    
    public void actualizar(Rol rol) {
        try {
            iniciaOperacion();
            session.update(rol);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
    
    public void eliminar(Rol rol) {
        try {
            iniciaOperacion();
            session.delete(rol);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
    
 
    
    public List<Rol> traerRoles() {
        List<Rol> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Rol r order by r.nombreRol asc", Rol.class).list();
        } finally {
            session.close();
        }
        return lista;
    }


    
}

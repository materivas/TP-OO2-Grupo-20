package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Turno;


public class TurnoDao {
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

	public int agregar(Turno objeto) {
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

	public void actualizar(Turno objeto) {
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

	public void eliminar(Turno objeto) {
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

	public Turno traer(long idTurno) {
	    Turno objeto = null;
	    try {
	        iniciaOperacion();
	        // JOIN FETCH para cargar todas las relaciones necesarias
	        String hql = "SELECT DISTINCT t FROM Turno t "
	                   + "LEFT JOIN FETCH t.detalle "
	                   + "LEFT JOIN FETCH t.cliente "
	                   + "LEFT JOIN FETCH t.empleado e "
	                   + "LEFT JOIN FETCH e.rol " // 
	                   + "LEFT JOIN FETCH t.servicio "
	                   + "WHERE t.idTurno = :id";
	        objeto = session.createQuery(hql, Turno.class)
	                      .setParameter("id", idTurno)
	                      .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return objeto;
	}

	public List<Turno> traer() {
	    List<Turno> lista = null;
	    try {
	        iniciaOperacion();
	        lista = session.createQuery("from Turno", Turno.class).list();
	    } finally {
	        session.close();
	    }
	    return lista;
	}

	public List<Turno> traerPorCliente(long idCliente) {
	    List<Turno> lista = null;
	    try {
	        iniciaOperacion();
	        lista = session.createQuery("from Turno t where t.cliente.id = :idCliente", Turno.class)
	                .setParameter("idCliente", idCliente)
	                .list();
	    } finally {
	        session.close();
	    }
	    return lista;
	}

	public List<Turno> traerPorFecha(LocalDate fecha) {
	    List<Turno> lista = null;
	    try {
	        iniciaOperacion();
	        lista = session.createQuery("from Turno t where t.fechaHora = :fecha", Turno.class)
	                .setParameter("fecha", fecha)
	                .list();
	    } finally {
	        session.close();
	    }
	    return lista;
	}



}


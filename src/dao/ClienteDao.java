package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Servicio;
import datos.Turno;

public class ClienteDao {
	private static Session session;
	private Transaction tx;
	private static ClienteDao instancia = null; 

	protected ClienteDao() {
	}

	public static ClienteDao getInstance() {
		if (instancia == null)
			instancia = new ClienteDao();
		return instancia;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
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
	 	
	 public Cliente traer(int idCliente) {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.createQuery("from Cliente c where c.idCliente=:idCliente")
						.setParameter("idCliente", idCliente).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	 public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente", Cliente.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	 public void actualizarTurno(Turno turno) {
	    try {
	        iniciaOperacion();
	        session.update(turno);
	        tx.commit();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	}

	 public List<Turno> verTurnos(Cliente cliente) {
	    List<Turno> turnos = null;
	    try {
	        iniciaOperacion();
	        String hql = "FROM Turno t WHERE t.cliente = :cliente";
	        turnos = session.createQuery(hql, Turno.class)
	                .setParameter("cliente", cliente)
	                .list();
	    } finally {
	        session.close();
	    }
	    return turnos;
	}

	 public Turno solicitarTurno(Cliente cliente, Servicio servicio, LocalDate fechaDeseada) {
	    Turno nuevoTurno = new Turno();

	    nuevoTurno.setIdCliente(cliente);
	    nuevoTurno.setIdServicio(servicio);
	    nuevoTurno.setFechaHora(fechaDeseada);

	    try {
	        iniciaOperacion();
	        session.save(nuevoTurno);
	        tx.commit();

	        cliente.getTurnos().add(nuevoTurno);
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }

	    return nuevoTurno;
	}

}
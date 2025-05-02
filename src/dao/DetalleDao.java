package dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Detalle;
import datos.Turno;

public class DetalleDao {
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
	
	
	public int agregar(Detalle objeto) {
		int id = 0;
		try {
		iniciaOperacion();
		id = Integer.parseInt(session.save(objeto).toString());
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		} finally {
		session.close();
		}
		return id;
		}
	
	public void actualizar(Detalle objeto) {
		try {
		iniciaOperacion();
		session.update(objeto);
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		} finally {
		session.close();
		}
		}
	
	public void eliminar(Detalle objeto) {
		try {
		iniciaOperacion();
		session.delete(objeto);
		tx.commit();
		} catch (HibernateException he) {
		manejaExcepcion(he);
		} finally {
		session.close();
		}
		}
	
	public Detalle traer(long idTurno) {
		Detalle objeto = null;
		try {
		iniciaOperacion();
		objeto = (Detalle) session.get(Detalle.class, idTurno);
		} finally {
		session.close();
		}
		return objeto;
		}
	
	public List<Detalle> traer() {
		List<Detalle> lista = new ArrayList<Detalle>();
		try {
		iniciaOperacion();
		Query<Detalle> query = session.createQuery("from Detalle d order byd.fecha asc", Detalle.class);
		lista = query.getResultList();
		} finally {
		session.close();
		}
		return lista;
		}


}
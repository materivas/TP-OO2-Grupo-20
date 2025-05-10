package negocio;
import java.util.List;

import dao.ServicioDao;
import datos.Servicio;


public class ServicioABM {

	ServicioDao dao= new ServicioDao();

	public Servicio traer(long idServicio) {
		return dao.traer(idServicio);
	}

	public int agregar(String nombreServicio,String descripcion,int duracion, double precio) {
		Servicio s= new Servicio(nombreServicio,descripcion,duracion,precio);
		return dao.agregar(s);

	}
	
	public int agregar(Servicio s) {
		
		return dao.agregar(s);

	}

	public void modificar(Servicio s) throws Exception {
		
		Servicio existe=dao.traer(s.getIdServicio());
		
		if(existe==null) {
			throw new Exception("EXCEPCION: Se esta intentando modificar un servicio que no existe");
		}
		
		
		dao.actualizar(s);
	}

	public void eliminar(long idServicio) throws Exception {
		Servicio s=dao.traer(idServicio);
		
		if(s==null) {
			throw new Exception("EXCEPCION: Se esta intentando eliminar un servicio que no existe"); }
		dao.eliminar(s);

	}

	public List<Servicio> traer(){
		return dao.traer();
	}

}
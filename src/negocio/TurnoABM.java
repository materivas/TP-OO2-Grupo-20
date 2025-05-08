package negocio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import dao.TurnoDao;
import datos.Cliente;
import datos.Detalle;
import datos.Empleado;
import datos.Servicio;
import datos.Turno;


public class TurnoABM {
	TurnoDao dao = new TurnoDao();

	public int agregar(Date fechaHora, Detalle detalle, Cliente cliente, Empleado empleado,  Servicio servicio) {
		Turno t = new Turno(fechaHora,  detalle,  cliente, empleado, servicio);
		return dao.agregar(t);
	}

	public void modificar(Turno t) {
		dao.actualizar(t);
	}

	public void eliminar(long idTurno) {
		Turno t = dao.traer(idTurno);
		dao.eliminar(t);
	}

	public Turno traer(long idTurno) {
		Turno t = dao.traer(idTurno);
		return t;
	}

	public List<Turno> traer() {
		return dao.traer();
	}

	public List<Turno> traerPorCliente(long idCliente) {
		return dao.traerPorCliente(idCliente);
	}

	public List<Turno> traerPorFecha(LocalDate fecha) {
		return dao.traerPorFecha(fecha);
	}


}

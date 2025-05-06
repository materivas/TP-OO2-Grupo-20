package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Servicio;
import datos.Turno;

public class ClienteABM {
	private ClienteDao dao = ClienteDao.getInstance();

	public int agregar(Cliente cliente) {
		return dao.agregar(cliente);
	}
	
	public void actualizar(Cliente cliente) {
		dao.actualizar(cliente);
	}

	public void eliminar(Cliente cliente) {
		dao.eliminar(cliente);
	}

	public Cliente traer(int idCliente) {
		return dao.traer(idCliente);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public List<Turno> verTurnos(Cliente cliente) {
		return dao.verTurnos(cliente);
	}

	public Turno solicitarTurno(Cliente cliente, Servicio servicio, LocalDate fechaDeseada) {
		return dao.solicitarTurno(cliente, servicio, fechaDeseada);
	}


	public void actualizarTurno(Turno turno) {
		dao.actualizarTurno(turno);
	}
}

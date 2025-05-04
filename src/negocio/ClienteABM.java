package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Servicio;
import datos.Turno;

public class ClienteABM {
	private ClienteDao dao = ClienteDao.getInstance();

	// Alta
	public int agregar(Cliente cliente) {
		return dao.agregar(cliente);
	}

	// Modificación
	public void actualizar(Cliente cliente) {
		dao.actualizar(cliente);
	}

	// Baja
	public void eliminar(Cliente cliente) {
		dao.eliminar(cliente);
	}

	// Traer por ID
	public Cliente traer(int idCliente) {
		return dao.traer(idCliente);
	}

	// Traer todos
	public List<Cliente> traer() {
		return dao.traer();
	}

	// Ver todos los turnos de un cliente
	public List<Turno> verTurnos(Cliente cliente) {
		return dao.verTurnos(cliente);
	}

	// Solicitar un nuevo turno
	public Turno solicitarTurno(Cliente cliente, Servicio servicio, LocalDate fechaDeseada) {
		return dao.solicitarTurno(cliente, servicio, fechaDeseada);
	}

	// Actualizar datos de un turno
	public void actualizarTurno(Turno turno) {
		dao.actualizarTurno(turno);
	}
}

package negocio;

import datos.Cliente;
import dao.ClienteDao;

public class ClienteABM {
	private ClienteDao dao = new ClienteDao();

	 public int agregar(Cliente cliente) {
		 return dao.agregar(cliente);
	 }

	public void modificar(Cliente c) {
		Cliente existente = dao.traerClientePorDni(c.getDni());

		if (existente != null && existente.getIdPersona() != c.getIdPersona()) {
			throw new RuntimeException("Ya existe otro cliente con el DNI: " + c.getDni());
		}

		dao.actualizar(c);
	}

	public void eliminar(int idCliente) {
		Cliente c = dao.traerCliente(idCliente);

		if (c == null) {
			throw new RuntimeException("No existe un cliente con ID: " + idCliente);
		}

		dao.eliminar(c);
	}

	public Cliente traerCliente(int idCliente) {
		Cliente c = dao.traerCliente(idCliente);

		if (c == null) {
			throw new RuntimeException("No existe un cliente con ID: " + idCliente);
		}

		return c;
	}
}

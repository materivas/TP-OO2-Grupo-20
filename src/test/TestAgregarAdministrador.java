package test;

import java.util.List;

import dao.RolDao;
import datos.Administrador;
import datos.Rol;
import negocio.AdministradorABM;

public class TestAgregarAdministrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			AdministradorABM abm = new AdministradorABM();
			RolDao rolDao = new RolDao();

			// Crear y guardar rol "Administrador"
			Rol rolAdmin = new Rol();
			rolAdmin.setNombreRol("Administrador");
			rolDao.agregar(rolAdmin);

			// 1️ Crear administrador
			System.out.println("➡️ Creando administrador...");
			int id = abm.agregar("TestNombre", "TestApellido", 99999999, "test@example.com", "test_user", "pass123", rolAdmin);
			System.out.println("✔️ Administrador creado con ID: " + id);

			// 2️ Modificar administrador
			System.out.println("➡️ Modificando administrador...");
			Administrador admin = abm.traerAdministrador("test_user");
			admin.setNombre("NombreModificado");
			admin.setApellido("ApellidoModificado");
			abm.modificar(admin);
			System.out.println("🛠️ Administrador modificado.");

			// 3️ Traer todos
			System.out.println("🔍 Administradores disponibles en la base:");
			List<Administrador> lista = abm.traerAdministradores();
			for (Administrador a : lista) {
				System.out.println("ID: " + a.getIdPersona() +
						", User: " + a.getUser() +
						", Nombre: " + a.getNombre() + " " + a.getApellido() +
						", Email: " + a.getEmail());
			}

			/*
			// 4️ Eliminar administrador
			System.out.println("❌ Eliminando administrador...");
			abm.eliminar("test_user");
			System.out.println("✔️ Administrador eliminado.");
			 */

			// 5️ Verificar que ya no está
			Administrador eliminado = abm.traerAdministrador("test_user");
			if (eliminado == null) {
				System.out.println("✅ Verificación: administrador eliminado correctamente.");
			} else {
				System.out.println("❌ Error: el administrador sigue existiendo.");
			}

		} catch (Exception e) {
			System.out.println("⚠️ ERROR: " + e.getMessage());
		}
	}




}



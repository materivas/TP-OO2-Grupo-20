package test;

import java.util.List;

import dao.RolDao;
import datos.Rol;

public class TestAgregarRol {

	public static void main(String[] args) {


		try {
			RolDao dao = new RolDao();

			// 1️ Crear rol
			System.out.println("➡️ Creando rol...");
			Rol rol = new Rol();
			rol.setNombreRol("Tester");
			int id = dao.agregar(rol);
			System.out.println("✔️ Rol creado con ID: " + id);

			// 2️ Modificar rol
			System.out.println("➡️ Modificando rol...");
			rol.setNombreRol("Tester Senior");
			dao.actualizar(rol);
			System.out.println("🛠️ Rol modificado.");

			// 3️ Traer todos los roles
			System.out.println("🔍 Lista de roles existentes:");
			List<Rol> lista = dao.traerRoles();
			for (Rol r : lista) {
				System.out.println("ID: " + r.getIdRol() + " - Nombre: " + r.getNombreRol());
			}
			
			/*
			// 4️ Eliminar rol
			System.out.println("❌ Eliminando rol...");
			dao.eliminar(rol);
			System.out.println("✔️ Rol eliminado.");
			*/
			
			// 5️ Verificar eliminación
			Rol eliminado = dao.traerRol(rol.getIdRol());
			if (eliminado == null) {
				System.out.println("✅ Verificación: rol eliminado correctamente.");
			} else {
				System.out.println("❌ Error: el rol sigue existiendo.");
			}

		} catch (Exception e) {
			System.out.println("⚠️ ERROR: " + e.getMessage());
		}
	}

}



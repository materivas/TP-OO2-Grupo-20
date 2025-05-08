package test;

import java.util.List;

import dao.AdministradorDao;
import datos.Administrador;

public class TestTraerAdministradores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AdministradorDao dao = new AdministradorDao();
        List<Administrador> administradores = dao.traerAdministradores();

        System.out.println("Administradores en la base de datos:");
        System.out.println("Cantidad de administradores: " + administradores.size());
        for (Administrador admin : administradores) {
            System.out.println("ID: " + admin.getIdPersona());
            System.out.println("Nombre: " + admin.getNombre());
            System.out.println("Apellido: " + admin.getApellido());
            System.out.println("User: " + admin.getUser());
            System.out.println("Email: " + admin.getEmail());
            System.out.println("Rol: " + (admin.getRol() != null ? admin.getRol().getNombreRol() : "Sin rol"));
            System.out.println("-------------------------------");
        }
	}

}

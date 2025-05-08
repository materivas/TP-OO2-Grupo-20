package test;

import datos.Administrador;
import datos.Rol;
import negocio.EspecialidadABM;

public class TestCrearEspecialidadSoloAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
        try {
            // Simulamos un administrador ya existente
            Rol rolAdmin = new Rol();
            rolAdmin.setNombreRol("Administrador");

            Administrador admin = new Administrador();
            admin.setNombre("Juan");
            admin.setApellido("Lopez");
            admin.setRol(rolAdmin);

            EspecialidadABM abm = new EspecialidadABM();
            abm.crearEspecialidad("Neurología", admin);
            abm.crearEspecialidad("Oncología", admin);

            System.out.println("Especialidades creadas exitosamente.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
		
}



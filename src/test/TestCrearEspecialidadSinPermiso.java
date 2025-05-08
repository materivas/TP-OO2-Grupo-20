package test;

import datos.Administrador;
import datos.Rol;
import negocio.EspecialidadABM;

public class TestCrearEspecialidadSinPermiso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try {
            // Simulamos un usuario que NO es administrador
            Rol rolEmpleado = new Rol();
            rolEmpleado.setNombreRol("Empleado"); 

            Administrador noAdmin = new Administrador(); // sigue siendo de tipo Administrador, pero con rol incorrecto
            noAdmin.setNombre("Pedro");
            noAdmin.setApellido("Ramírez");
            noAdmin.setRol(rolEmpleado);

            EspecialidadABM abm = new EspecialidadABM();
            abm.crearEspecialidad("Pediatría", noAdmin);

            System.out.println("Especialidad creada (esto no debería verse).");

        } catch (Exception e) {
            System.out.println("ACCESO DENEGADO: " + e.getMessage());
        }
    }
		
		


}

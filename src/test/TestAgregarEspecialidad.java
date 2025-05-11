package test;

import java.time.LocalDate;

import datos.Empleado;
import negocio.EmpleadoABM;
import datos.Rol;
import negocio.RolABM;
import datos.Especialidad;
import negocio.EspecialidadABM;

public class TestAgregarEspecialidad {

	public static void main(String[] args) {

		EspecialidadABM especialidadABM = new EspecialidadABM();
		EmpleadoABM empleadoABM = new EmpleadoABM();
		Empleado e1 = new Empleado();
		
		
		System.out.println("----------------- CARGAMOS LAS ESPECIALIDADES ----------------- \n");
		
		try {
			
			especialidadABM.agregar("Cardiología");
			especialidadABM.agregar("Pediatría");
			especialidadABM.agregar("Traumatología");
			especialidadABM.agregar("Dermatología");
			
			System.out.println(especialidadABM.traerEspecialidad(1L));
			System.out.println(especialidadABM.traerEspecialidad(2L));
			System.out.println(especialidadABM.traerEspecialidad(3L));
			System.out.println(especialidadABM.traerEspecialidad(4L));

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("----------------- AGREGAMOS ESPECIALIDADES A LOS EMPLEADOS ---------------- \n");

		
		try {
			
		
			empleadoABM.agregarEspecialidad(1L, especialidadABM.traerEspecialidad(1L) );
			empleadoABM.agregarEspecialidad(1L, especialidadABM.traerEspecialidad(2L) );
			empleadoABM.agregarEspecialidad(2L, especialidadABM.traerEspecialidad(1L) );
			empleadoABM.agregarEspecialidad(3L, especialidadABM.traerEspecialidad(3L) );
			empleadoABM.agregarEspecialidad(4L, especialidadABM.traerEspecialidad(4L) );
			empleadoABM.agregarEspecialidad(5L, especialidadABM.traerEspecialidad(3L) );
			
			System.out.println("Nombre: " + empleadoABM.traerEmpleadoID(1L).getNombre() + "  CUIL: " + empleadoABM.traerEmpleadoID(1L).getCuil());
			System.out.println(empleadoABM.traerEmpleadoID(1L).getEspecialidades());
			
		
		} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		
		
		System.out.println("------------------------------------------------\n");
		System.out.println("-----------------INTENTAMOS ELIMINAR UN EMPLEADO CON ESPECIALIDADES CARGADAS -------------------\n");
		
		try {
			e1 = empleadoABM.traerEmpleadoYEspecialidad(1L);
			System.out.println("Empleado: " +e1.getNombre());
			empleadoABM.eliminarEmpleado(1L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("------------------------------------------------\n");
		System.out.println("-----------------INTENTAMOS ELIMINAR UN EMPLEADO CON ESPECIALIDAD QUE NO EXISTE -------------------\n");
		
		try {
			empleadoABM.eliminarEspecialidad(1L, 8L);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------- INTENTAMOS ELIMINAR UN EMPLEADO QUE NO EXISTE -------------------\n");
		
		try {
			empleadoABM.eliminarEspecialidad(8L, 1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("----------------- INTENTAMOS ELIMINAR LA ESPECIALIDAD CON ID ---> 1 DEL EMPLEADO ID ----> 1 -------------------\n");
		
		try {
			System.out.println("-------- ANTES DE BORRAR ------------\n");
			
			System.out.println("EMPLEADO: " +empleadoABM.traerEmpleadoYEspecialidad(1L).getNombre());
			System.out.println("-----> ESPECIALIDADES: \n" +empleadoABM.traerEmpleadoYEspecialidad(1L).getEspecialidades());
			
			empleadoABM.eliminarEspecialidad(1L, 1L);
			System.out.println("-------- DESPUÉS DE BORRAR ------------\\n");
			System.out.println("EMPLEADO: " +empleadoABM.traerEmpleadoYEspecialidad(1L).getNombre());
			System.out.println("-----> ESPECIALIDADES: " +empleadoABM.traerEmpleadoYEspecialidad(1L).getEspecialidades());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}

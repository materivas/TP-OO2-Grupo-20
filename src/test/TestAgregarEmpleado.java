package test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import org.hibernate.mapping.List;

import datos.Empleado;
import negocio.EmpleadoABM;
import datos.Rol;
import datos.Turno;
import negocio.RolABM;
import negocio.TurnoABM;

public class TestAgregarEmpleado {

	public static void main(String[] args) {
		
		
		System.out.println("------------ PRIMERO AGREGAMOS Y CARGAMOS LOS ROLES --------------- \n");
		
		RolABM rolABM = new RolABM();
		EmpleadoABM empleadoABM = new EmpleadoABM();
		TurnoABM turnoABM = new TurnoABM();
		int ultimoIdRol = rolABM.agregar("Usuario");
		ultimoIdRol = rolABM.agregar("Admin");
		
		
		System.out.println("------------ MOSTRAMOS LOS ROLES POR PANTALLA  --------------- \n");
		
		System.out.println(rolABM.traerRol("Usuario"));
		System.out.println(rolABM.traerRol("Admin"));
		
		
		System.out.println("-------------- CARGAMOS LOS EMPLEADOS  --------------- \n");
		
		try {
			int id1 = empleadoABM.agregar("Carlos", "Gómez", 30123456, "carlos.gomez@empresa.com", 
			    LocalDate.of(1985, 5, 12), true, rolABM.traerRol("Admin"), 20301234569L, true);
			int id2 = empleadoABM.agregar("María", "López", 25456789, "maria.lopez@empresa.com", 
			    LocalDate.of(1990, 7, 23), true, rolABM.traerRol("Usuario"), 27254567892L, true);
			int id3 = empleadoABM.agregar("Juan", "Pérez", 28901234, "juan.perez@empresa.com", 
			    LocalDate.of(1988, 11, 5), false, rolABM.traerRol("Usuario"), 20289012345L, false);
			int id4 = empleadoABM.agregar("Ana", "Rodríguez", 32654321, "ana.rodriguez@empresa.com", 
			    LocalDate.of(1992, 3, 18), true, rolABM.traerRol("Usuario"), 27326543218L, true);
			int id5 = empleadoABM.agregar("Luis", "Martínez", 34567890, "luis.martinez@empresa.com", 
			    LocalDate.of(1995, 9, 30), true, rolABM.traerRol("Admin"), 20345678903L, false);
			int id6 = empleadoABM.agregar("Jaimito", "Fugazi" , 48418666, "jaimitofugazi88@gmail.com"
					, LocalDate.of(1999, 8, 14) , true,  rolABM.traerRol("Admin"), 23484186669L, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------\n");
		System.out.println("-------------- MOSTRAMOS LOS EMPLEADOS POR PANTALLA  --------------- \n");

		
		try {
			
		System.out.println(empleadoABM.traerEmpleadoCuil(20301234569L));
		System.out.println(empleadoABM.traerEmpleadoCuil(27254567892L));
		System.out.println(empleadoABM.traerEmpleadoCuil(20289012345L));
		System.out.println(empleadoABM.traerEmpleadoCuil(27326543218L));
		System.out.println(empleadoABM.traerEmpleadoCuil(20345678903L));
		System.out.println(empleadoABM.traerEmpleadoCuil(23484186669L));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------\n");
		System.out.println("--------- ELIMINAMOS UN EMPLEADO QUE NO EXISTE: ID ----> 33-------------\n");
		
		try {
			empleadoABM.eliminarEmpleado(33);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*System.out.println("-----------------------------------------------\n");
		System.out.println("--------- ELIMINAMOS AL EMPLEADO CON: ID ----> 6 -------------\n");
		System.out.println("--------- MOSTRAMOS LA LISTA NUEVAMENTE -------------\n");
		
		try {
			empleadoABM.eliminarEmpleado(6);
			List<Empleado> empleados = empleadoABM.traerEmpleado();
			System.out.println("LISTA: " +empleados);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		System.out.println("-----------------------------------------------\n");
		System.out.println("--------- MODIFICAMOS EL MAIL DEL EMPLEADO: ID ----> 2 -------------\n");
		System.out.println("--------- MOSTRAMOS LA LISTA NUEVAMENTE -------------\n");
		
		
		try {
			
			empleadoABM.modificar(empleadoABM.traerEmpleadoID(2));
			List<Empleado> empleados = empleadoABM.traerEmpleado();
			System.out.println("LISTA: " +empleados);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	/*	// Ejemplo 1: Modificar solo nombre y apellido
		Empleado cambios1 = new Empleado();
		cambios1.setNombre("NuevoNombre");
		cambios1.setApellido("NuevoApellido");
		Rol rol = rolABM.traerRol("Usuario");
		cambios1.setRol(rol);
		try {
			empleadoABM.modificar(empleadoABM.traerEmpleadoID(1L).getIdPersona(), cambios1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Ejemplo 2: Modificar solo email
		Empleado cambios2 = new Empleado();
		cambios2.setEmail("nuevo@email.com");
		empleadoABM.modificar(idEmpleado, cambios2);

		// Ejemplo 3: Modificar varios campos
		Empleado cambios3 = new Empleado();
		cambios3.setNombre("OtroNombre");
		cambios3.setEmail("otro@email.com");
		cambios3.setEstaDisponible(false);
		empleadoABM.modificar(idEmpleado, cambios3);
		
		
		*/
		
		System.out.println("--------- MODIFICAMOS EL NOMBRE DEL EMPLEADO ID ----> 1 -------------\n");

		
		try {
			Empleado empleado = empleadoABM.traerEmpleadoID(1L);
			Rol rol = rolABM.traerRol("Usuario");
			empleado.setNombre("DURAZNITO");
			empleado.setRol(rol);
			empleadoABM.modificar(empleado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("--------- TRAEMOS UNA LISTA DE EMPLEADOS -------------\n");

		
		List<Empleado> empleados = empleadoABM.traerEmpleado();
		System.out.println("LISTA: " +empleados);
		
		
		System.out.println("--------- AVISO: DEBEN HABER TURNOS CARGADOS EN LA BASE DE DATOS-------------\n");
		System.out.println("--------- TRAEMOS UNA LISTA DE TURNOS DE X EMPLEADO POR FECHA -------------\n");

		
		
		 try {
				Empleado empleado = empleadoABM.traerEmpleadoID(2L);
				System.out.println("Empleado:" +empleado.getNombre());
				System.out.println("Turnos:" +empleado.getTurnos());
				Turno turno = turnoABM.traer(2L);
				LocalDate localDate = LocalDate.of(2025, 5, 8); // 8 de mayo de 2025
				Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				
				System.out.println("Buscamos un turno por fecha: ");
				System.out.println(empleado.obtenerTurnosPorFecha(date));
				
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		

	}

}

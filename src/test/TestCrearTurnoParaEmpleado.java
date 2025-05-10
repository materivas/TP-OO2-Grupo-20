package test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.time.ZoneId;


import org.junit.Test;

import datos.*;
import negocio.*;

public class TestCrearTurnoParaEmpleado {

	public static void main(String[] args) {
		
		 TurnoABM turnoABM = new TurnoABM();
		    ClienteABM clienteABM = new ClienteABM();
		    EmpleadoABM empleadoABM = new EmpleadoABM();
		    RolABM rolABM = new RolABM();
		    ServicioABM servicioABM = new ServicioABM();
		    DetalleABM detalleABM = new DetalleABM();
		    Empleado empleado = new Empleado();
		
		
		    try {
	            // === CLIENTES ===
		    	
		    	System.out.println("-->>>>>>>>>>>>>>>1. CARGAMOS LOS CLIENTES<<<<<<<<<<<<<<<<<<-- ");
		    	
	            Cliente nuevoCliente1 = new Cliente("Valeria", "Gómez", 42789123, "valeria.gomez@mail.com",
	                    LocalDate.of(1988, 11, 15), true, true);
	            clienteABM.agregar(nuevoCliente1);

	            Cliente nuevoCliente2 = new Cliente("Martín", "Castro", 42123456, "martin.castro@mail.com",
	                    LocalDate.of(1990, 6, 10), true, true);
	            clienteABM.agregar(nuevoCliente2);

	            Cliente nuevoCliente3 = new Cliente("Lucía", "Méndez", 43215678, "lucia.mendez@mail.com",
	                    LocalDate.of(1995, 8, 25), true, true);
	            clienteABM.agregar(nuevoCliente3);

	            Cliente nuevoCliente4 = new Cliente("Joaquín", "Peralta", 41234567, "joaquin.peralta@mail.com",
	                    LocalDate.of(1985, 12, 3), true, true);
	            clienteABM.agregar(nuevoCliente4);

	            Cliente nuevoCliente5 = new Cliente("Soledad", "Ramírez", 43567891, "soledad.ramirez@mail.com",
	                    LocalDate.of(1992, 3, 18), true, true);
	            clienteABM.agregar(nuevoCliente5);

	            Cliente nuevoCliente6 = new Cliente("Gabriel", "Fernández", 44098765, "gabriel.fernandez@mail.com",
	                    LocalDate.of(1983, 7, 29), true, true);
	            clienteABM.agregar(nuevoCliente6);

	            // === SERVICIOS ===
	            

		    	System.out.println("-->>>>>>>>>>>>>>>2. CARGAMOS LOS SERVICIOS <<<<<<<<<<<<<<<<<<-- ");
	            
	            Servicio nuevoServicio1 = new Servicio("Consulta Nutricional", "Evaluación nutricional completa", 45, 2000.0);
	            servicioABM.agregar(nuevoServicio1);

	            Servicio nuevoServicio2 = new Servicio("Consulta Clínica", "Chequeo general de salud", 30, 1800.0);
	            servicioABM.agregar(nuevoServicio2);

	            Servicio nuevoServicio3 = new Servicio("Odontología", "Limpieza dental y revisión", 40, 2500.0);
	            servicioABM.agregar(nuevoServicio3);

	            Servicio nuevoServicio4 = new Servicio("Pediatría", "Control infantil completo", 35, 2200.0);
	            servicioABM.agregar(nuevoServicio4);

	            Servicio nuevoServicio5 = new Servicio("Cardiología", "Evaluación cardiológica completa", 60, 3000.0);
	            servicioABM.agregar(nuevoServicio5);

	            Servicio nuevoServicio6 = new Servicio("Traumatología", "Evaluación de lesiones musculares", 50, 2800.0);
	            servicioABM.agregar(nuevoServicio6);

	            // === TURNOS ===
	            

		    	System.out.println("-->>>>>>>>>>>>>>>3. CARGAMOS LOS TURNOS SIN DETALLE<<<<<<<<<<<<<<<<<<-- ");
	            

		    	Date fechaHora1 = Date.from(LocalDateTime.of(2025, 5, 8, 10, 15, 30).atZone(ZoneId.systemDefault()).toInstant());
		    	Turno nuevoTurno1 = new Turno();
		    	nuevoTurno1.setFechaHora(fechaHora1);
		    	nuevoTurno1.setCliente(nuevoCliente1);
		    	nuevoTurno1.setEmpleado(empleadoABM.traerEmpleadoID(2L));
		    	nuevoTurno1.setServicio(nuevoServicio1);
		    	int idTurno1 = turnoABM.agregar(nuevoTurno1);

		    	Date fechaHora2 = Date.from(LocalDateTime.of(2025, 5, 8, 12, 45, 10).atZone(ZoneId.systemDefault()).toInstant());
		    	Turno nuevoTurno2 = new Turno();
		    	nuevoTurno2.setFechaHora(fechaHora2);
		    	nuevoTurno2.setCliente(nuevoCliente2);
		    	nuevoTurno2.setEmpleado(empleadoABM.traerEmpleadoID(2L));
		    	nuevoTurno2.setServicio(nuevoServicio2);
		    	int idTurno2 = turnoABM.agregar(nuevoTurno2);

		    	Date fechaHora3 = Date.from(LocalDateTime.of(2025, 5, 8, 15, 5, 5).atZone(ZoneId.systemDefault()).toInstant());
		    	Turno nuevoTurno3 = new Turno();
		    	nuevoTurno3.setFechaHora(fechaHora3);
		    	nuevoTurno3.setCliente(nuevoCliente3);
		    	nuevoTurno3.setEmpleado(empleadoABM.traerEmpleadoID(4L));
		    	nuevoTurno3.setServicio(nuevoServicio3);
		    	int idTurno3 = turnoABM.agregar(nuevoTurno3);

		    	Date fechaHora4 = Date.from(LocalDateTime.of(2025, 5, 9, 9, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
		    	Turno nuevoTurno4 = new Turno();
		    	nuevoTurno4.setFechaHora(fechaHora4);
		    	nuevoTurno4.setCliente(nuevoCliente4);
		    	nuevoTurno4.setEmpleado(empleadoABM.traerEmpleadoID(2L));
		    	nuevoTurno4.setServicio(nuevoServicio4);
		    	int idTurno4 = turnoABM.agregar(nuevoTurno4);

		    	Date fechaHora5 = Date.from(LocalDateTime.of(2025, 5, 9, 11, 30, 45).atZone(ZoneId.systemDefault()).toInstant());
		    	Turno nuevoTurno5 = new Turno();
		    	nuevoTurno5.setFechaHora(fechaHora5);
		    	nuevoTurno5.setCliente(nuevoCliente5);
		    	nuevoTurno5.setEmpleado(empleadoABM.traerEmpleadoID(3L));
		    	nuevoTurno5.setServicio(nuevoServicio5);
		    	int idTurno5 = turnoABM.agregar(nuevoTurno5);

		    	Date fechaHora6 = Date.from(LocalDateTime.of(2025, 5, 9, 14, 20, 20).atZone(ZoneId.systemDefault()).toInstant());
		    	Turno nuevoTurno6 = new Turno();
		    	nuevoTurno6.setFechaHora(fechaHora6);
		    	nuevoTurno6.setCliente(nuevoCliente6);
		    	nuevoTurno6.setEmpleado(empleadoABM.traerEmpleadoID(4L));
		    	nuevoTurno6.setServicio(nuevoServicio6);
		    	int idTurno6 = turnoABM.agregar(nuevoTurno6);


	            // === DETALLES ===
	            
		    	System.out.println("-->>>>>>>>>>>>>>>4. CARGAMOS LOS DETALLES<<<<<<<<<<<<<<<<<<-- ");

	            Detalle nuevoDetalle1 = new Detalle(true, LocalDate.of(2025, 5, 8), "Consulta inicial con nutricionista");
	            nuevoDetalle1.setTurno(nuevoTurno1);
	            detalleABM.agregar(nuevoDetalle1);
	            nuevoTurno1.setDetalle(nuevoDetalle1);
	            turnoABM.modificar(nuevoTurno1);

	            Detalle nuevoDetalle2 = new Detalle(true, LocalDate.of(2025, 5, 9), "Control clínico preventivo");
	            nuevoDetalle2.setTurno(nuevoTurno2);
	            detalleABM.agregar(nuevoDetalle2);
	            nuevoTurno2.setDetalle(nuevoDetalle2);
	            turnoABM.modificar(nuevoTurno2);

	            Detalle nuevoDetalle3 = new Detalle(true, LocalDate.of(2025, 5, 10), "Revisión dental semestral");
	            nuevoDetalle3.setTurno(nuevoTurno3);
	            detalleABM.agregar(nuevoDetalle3);
	            nuevoTurno3.setDetalle(nuevoDetalle3);
	            turnoABM.modificar(nuevoTurno3);

	            Detalle nuevoDetalle4 = new Detalle(true, LocalDate.of(2025, 5, 11), "Chequeo de rutina pediátrico");
	            nuevoDetalle4.setTurno(nuevoTurno4);
	            detalleABM.agregar(nuevoDetalle4);
	            nuevoTurno4.setDetalle(nuevoDetalle4);
	            turnoABM.modificar(nuevoTurno4);

	            Detalle nuevoDetalle5 = new Detalle(true, LocalDate.of(2025, 5, 12), "Estudio completo del corazón");
	            nuevoDetalle5.setTurno(nuevoTurno5);
	            detalleABM.agregar(nuevoDetalle5);
	            nuevoTurno5.setDetalle(nuevoDetalle5);
	            turnoABM.modificar(nuevoTurno5);

	            Detalle nuevoDetalle6 = new Detalle(true, LocalDate.of(2025, 5, 13), "Diagnóstico de molestia lumbar");
	            nuevoDetalle6.setTurno(nuevoTurno6);
	            detalleABM.agregar(nuevoDetalle6);
	            nuevoTurno6.setDetalle(nuevoDetalle6);
	            turnoABM.modificar(nuevoTurno6);
	            
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		    
		    
		 // Verificación
            System.out.println("Carga de 6 clientes, servicios, turnos y detalles realizada con éxito.");
            System.out.println("TURNO ID: ----> " +turnoABM.traer(1L).toString());
            
           
	        
	        
	    }

}

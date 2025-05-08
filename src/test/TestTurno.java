package test;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import org.junit.Test;

import datos.*;
import negocio.*;

public class TestTurno {
	@Test
	public void testAgregarTurno() {
	    TurnoABM turnoABM = new TurnoABM();
	    ClienteABM clienteABM = new ClienteABM();
	    EmpleadoABM empleadoABM = new EmpleadoABM();
	    RolABM rolABM = new RolABM();
	    ServicioABM servicioABM = new ServicioABM();
	    DetalleABM detalleABM = new DetalleABM();
	    
	    // 1. Crear 
	    Cliente cliente = new Cliente("Sebastian", "Rivas", 40824137, "sebas@mail.com", LocalDate.of(1977, 5, 20), true, true);
	    cliente.setTurnos(new HashSet<>());
	    clienteABM.agregar(cliente); // Hibernate asigna automáticamente el ID
	    
	    
	    // 2. Crear detalle
	    Detalle detalle = new Detalle(true, LocalDate.now(), "Primera visita");
	    detalleABM.agregar(detalle);
	    
	    // 3. Crear empleado con rol
	    Rol rol = new Rol("Cardiologo");
	    rolABM.agregar(rol); // persistir antes de usar
 
	    Empleado empleado = new Empleado(rol, 20330112257L, true);
	    empleado.setNombre("Lucía");
	    empleado.setApellido("Martínez");
	    empleado.setDni(35444555);
	    empleado.setEmail("lucia@mail.com");
	    empleado.setFechaDeNacimiento(LocalDate.of(1995, 3, 12));
	    empleadoABM.agregar(empleado);  

	    
	    // 4. Crear servicio
	    Servicio servicio = new Servicio("Cardiograma", "Analisis del corazon", 30, 1500.0);
	    servicioABM.agregar(servicio);
	    
	    // 5. Crear fechaHora del turno
	    Date fechaHora = new Date(); // ahora mismo

	    // 6. Agregar turno
	    int idTurno = turnoABM.agregar(fechaHora, detalle, cliente, empleado, servicio);

	    // 7. Verificar que se agregó correctamente
	    Turno turnoGuardado = turnoABM.traer(idTurno);
	    System.out.println("Turno creado: " + turnoGuardado);
	}
}




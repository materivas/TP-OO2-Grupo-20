package test;

import java.time.LocalDate;
import java.util.Date;
import datos.*;
import negocio.*;

public class TestTurno {
	
	public static void main(String[] args) {
	    TurnoABM turnoABM = new TurnoABM();
	    ClienteABM clienteABM = new ClienteABM();
	    EmpleadoABM empleadoABM = new EmpleadoABM();
	    RolABM rolABM = new RolABM();
	    ServicioABM servicioABM = new ServicioABM();
	    DetalleABM detalleABM = new DetalleABM();
	    Empleado empleado = new Empleado();
	  
	    System.out.println("------------ PRIMERO AGREGAMOS Y CARGAMOS LOS ROLES --------------- \n");
		
		empleadoABM = new EmpleadoABM();
		turnoABM = new TurnoABM();
		int ultimoIdRol = rolABM.agregar("Usuario");
		ultimoIdRol = rolABM.agregar("Admin");
		
		
		System.out.println("------------ MOSTRAMOS LOS ROLES POR PANTALLA  --------------- \n");
		
		System.out.println(rolABM.traerRol("Usuario"));
		System.out.println(rolABM.traerRol("Admin"));
	    
	    
	    // 1. Crear cliente
	    Cliente cliente = new Cliente("Sebastian", "Rivas", 40824137, "sebas@mail.com", 
	        LocalDate.of(1977, 5, 20), true, true);
	    clienteABM.agregar(cliente);
	    
	    // 2. Crear empleado con rol
	   Rol rol = rolABM.traerRol("Usuario");
	   // rolABM.agregar(rol);
	    
	    
	    
	    empleado = new Empleado("Lucía", "Martinez", 35444555, "lucia@gmail.com",LocalDate.of(1995, 3, 12), true, rol, 20330112257L, true);
	    empleadoABM.agregarEmpleado(empleado);  

	    // 3. Crear servicio
	    Servicio servicio = new Servicio("Cardiograma", "Analisis del corazon", 30, 1500.0);
	    servicioABM.agregar(servicio);
	    
	    // 4. Crear fechaHora del turno
	    Date fechaHora = new Date();
	    
	    // Primero se crea el Turno (sin detalle)
	    try {
	    Turno turno = new Turno();
	    turno.setFechaHora(fechaHora);
	    turno.setCliente(cliente);
	    turno.setEmpleado(empleadoABM.traerEmpleadoID(2L));
	    turno.setServicio(servicio);
	    long idTurno = turnoABM.agregar(turno);
	    

	    // Luego crea el Detalle asociado al Turno
	    Detalle detalle = new Detalle(true, LocalDate.now(), "Primera visita");
	    detalle.setTurno(turno); // Esto es CRUCIAL
	    detalleABM.agregar(detalle);

	    // Finalmente actualiza el Turno con el Detalle
	    turno.setDetalle(detalle);
	    turnoABM.modificar(turno);
	    
	    
	    // Verificar
	    Turno turnoGuardado = turnoABM.traer(1);
	    System.out.println("Turno creado: " + turnoGuardado);
	    }
	    catch (Exception e) {
	    	
	    	e.printStackTrace();
	    } 
	    
	    
	    
	}
}




package test;

import java.time.LocalDate;

import dao.AdministradorDao;
import dao.RolDao;
import datos.Administrador;
import datos.Rol;

public class TestCrearAdministradores {

	public static void main(String[] args) {
		
		  //PRIMERO SE TIENE QUE GENERAR UN ROL PARA QUE GENERE UN idRol que se asocie con el administrador
		
        AdministradorDao dao = new AdministradorDao();
        RolDao rolDao = new RolDao(); 
      
        // Crear y guardar Rol
        Rol rolAdmin = new Rol();
        rolAdmin.setNombreRol("Administrador");
        rolDao.agregar(rolAdmin); 
      
        
        // Crear administradores
        Administrador admin1 = new Administrador();
        admin1.setUser("admin1");
        admin1.setPassword("1234");
        admin1.setRol(rolAdmin);
        
     // Datos heredados de Persona
        admin1.setNombre("Carlos");
        admin1.setApellido("Pérez");
        admin1.setDni(12345678);
        admin1.setEmail("carlos.perez@example.com");
        admin1.setFechaDeNacimiento(LocalDate.of(1990, 5, 20));
        admin1.setObraSocial(false);
        
        
        
        Administrador admin2 = new Administrador();
        admin2.setUser("admin2");
        admin2.setPassword("abcd");
        admin2.setRol(rolAdmin);
        
        admin2.setNombre("Ana");
        admin2.setApellido("García");
        admin2.setDni(87654321);
        admin2.setEmail("ana.garcia@example.com");
        admin2.setFechaDeNacimiento(LocalDate.of(1985, 8, 15));
        admin2.setObraSocial(true);
        
        // Guardar administradores
        dao.agregar(admin1);
        dao.agregar(admin2);
        

	}

}

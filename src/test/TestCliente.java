package test;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import datos.Turno;
import negocio.ClienteABM;

public class TestCliente {
    public static void main(String[] args) {
        ClienteABM clienteABM = new ClienteABM();
        Turno turno = new Turno();
        
        turno.setFechaHora(new Date());
        Set<Turno> turnos = new HashSet<>();
        turnos.add(turno);
        
        try {
            // 1. Crear cliente nuevo
            System.out.println(">>> Creando cliente...");
            Cliente c = new Cliente("Mateo", "Rivas", 45824137, "mateo@mail.com",LocalDate.of(2004, 5, 30), true, true); // estado = true
            int idCliente = clienteABM.agregar(c);
            System.out.println("Cliente creado con ID: " + idCliente);

            // 2. Traer cliente y mostrar
            System.out.println(">>> Trayendo cliente...");
            Cliente cliente = clienteABM.traerCliente(idCliente);
            System.out.println("Cliente traído: " + cliente);

            // 3. Modificar estado
            System.out.println(">>> Modificando estado...");
            cliente.setEstado(false);
            clienteABM.modificar(cliente);

            Cliente clienteModificado = clienteABM.traerCliente(idCliente);
            System.out.println("Cliente modificado, estado: " + clienteModificado.isEstado());
/*
            // 4. Probar agregar cliente duplicado por DNI
            System.out.println(">>> Intentando agregar cliente con DNI duplicado...");
            Cliente duplicado = new Cliente("Mateo", "Rivas", 45824137, "otro@mail.com", LocalDate.of(2004, 5, 30), true, true,turnos);
            try {
                clienteABM.agregar(duplicado);
            } catch (RuntimeException e) {
                System.out.println("Excepción esperada: " + e.getMessage());
            }

            // 5. Eliminar cliente
            System.out.println(">>> Eliminando cliente...");
            clienteABM.eliminar(idCliente);
            System.out.println("Cliente eliminado.");

            // 6. Intentar traer cliente eliminado
            System.out.println(">>> Intentando traer cliente eliminado...");
            try {
                clienteABM.traerCliente(idCliente);
            } catch (RuntimeException e) {
                System.out.println("Excepción esperada al traer cliente eliminado: " + e.getMessage());
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

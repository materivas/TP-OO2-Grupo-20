package negocio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import dao.TurnoDao;
import datos.*;

public class TurnoABM {
    TurnoDao dao = new TurnoDao();

    public int agregar(Date fechaHora, Detalle detalle, Cliente cliente, Empleado empleado, Servicio servicio) {
        if (fechaHora == null || detalle == null || cliente == null || empleado == null || servicio == null) {
            throw new RuntimeException("Todos los datos del turno deben estar completos.");
        }

        Turno t = new Turno(fechaHora, detalle, cliente, empleado, servicio);
        return dao.agregar(t);
    }

    public int agregar(Turno turno) {
        if (turno == null) {
            throw new RuntimeException("El turno no puede ser null.");
        }
        return dao.agregar(turno);
    }

    public void modificar(Turno t) {
        if (t == null || dao.traer(t.getIdTurno()) == null) {
            throw new RuntimeException("No se puede modificar un turno inexistente.");
        }
        dao.actualizar(t);
    }

    public void eliminar(long idTurno) {
        Turno t = dao.traer(idTurno);
        if (t == null) {
            throw new RuntimeException("El turno con ID " + idTurno + " no existe.");
        }
        dao.eliminar(t);
    }

    public Turno traer(long idTurno) {
        Turno t = dao.traer(idTurno);
        if (t == null) {
            throw new RuntimeException("El turno con ID " + idTurno + " no fue encontrado.");
        }
        return t;
    }

    public List<Turno> traer() {
        List<Turno> lista = dao.traer();
        if (lista == null || lista.isEmpty()) {
            throw new RuntimeException("No hay turnos cargados.");
        }
        return lista;
    }

    public List<Turno> traerPorCliente(long idCliente) {
        List<Turno> turnos = dao.traerPorCliente(idCliente);
        if (turnos == null || turnos.isEmpty()) {
            throw new RuntimeException("El cliente con ID " + idCliente + " no tiene turnos.");
        }
        return turnos;
    }

    public List<Turno> traerPorFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new RuntimeException("La fecha no puede ser null.");
        }

        List<Turno> turnos = dao.traerPorFecha(fecha);
        if (turnos == null || turnos.isEmpty()) {
            throw new RuntimeException("No se encontraron turnos para la fecha: " + fecha);
        }
        return turnos;
    }
}

package datos;

import java.time.LocalDate;

public class Turno {
	private long idTurno;
	private LocalDate fechaHora;
	private Detalle idDetalle;
	private Cliente idCliente;
	private Empleado idEmpleado;
	private Servicio idServicio;
	
	public Turno() {}
	
	public Turno(LocalDate fechaHora, Detalle idDetalle, Cliente idCliente, Empleado idEmpleado, Servicio idServicio) {
		super();
		this.fechaHora = fechaHora;
		this.idDetalle = idDetalle;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.idServicio = idServicio;
	}

	public long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDate getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Detalle getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Detalle idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Empleado getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Empleado idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Servicio getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Servicio idServicio) {
		this.idServicio = idServicio;
	}
	
	
}

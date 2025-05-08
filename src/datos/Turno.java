package datos;

import java.util.Date;

public class Turno {
	private long idTurno;
	private Date fechaHora;
	private Detalle detalle;
	private Cliente cliente;
	private Empleado empleado;
	private Servicio servicio;

	public Turno() {}

	public Turno(Date fechaHora, Detalle detalle, Cliente cliente, Empleado empleado,
			Servicio servicio) {
		super();
		this.fechaHora = fechaHora;
		this.detalle = detalle;
		this.cliente = cliente;
		this.empleado = empleado;
		this.servicio = servicio;
	}

	public long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaDeseada) {
		this.fechaHora = fechaDeseada;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fechaHora=" + fechaHora + ", detalle=" + detalle + ", cliente="
				+ cliente + ", empleado=" + empleado + ", servicio=" + servicio + "]";
	}
	
}

package datos;
import java.time.LocalDate;


public class Detalle {
	 private Long idTurno;
	private boolean estadoTurno;
	private LocalDate fecha;
	private String descripcion;
	private Turno turno;
	
//Constructor
	
	public Detalle(Long idTurno, boolean estadoTurno, LocalDate fecha, String descripcion, Turno turno) {
		super();
		this.idTurno = idTurno;
		this.estadoTurno = estadoTurno;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.turno = turno;
	}
	
	public Detalle() {
		super();
	}



//Getters y Setters
	public Long getIdTurno() {
		return idTurno;
	}


	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}


	public boolean isEstadoTurno() {
		return estadoTurno;
	}


	public void setEstadoTurno(boolean estadoTurno) {
		this.estadoTurno = estadoTurno;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}



	
	//ToString
	@Override
	public String toString() {
		return "Detalle [idTurno=" + idTurno + ", estadoTurno=" + estadoTurno + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", turno=" + turno + "]";
	}
	

	
}



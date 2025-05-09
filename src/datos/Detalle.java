package datos;
import java.time.LocalDate;
import java.util.Objects;


public class Detalle {
	private long idDetalle;
	private boolean estadoTurno;
	private LocalDate fecha;
	private String descripcion;
	private Turno turno;

//Constructor

	public Detalle () {
		
		
	}
	public Detalle(boolean estadoTurno,LocalDate fecha, String descripcion){
		super();
		this.estadoTurno=estadoTurno;
		this.fecha=fecha;
		this.descripcion=descripcion;
		}
//Getters y Setters

	public long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(long idDetalle) {
		this.idDetalle = idDetalle;
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
		return "Detalle [estadoTurno=" + estadoTurno + ", fecha=" + fecha + ", descripcion=" + descripcion + "]\n";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Detalle other = (Detalle) obj;
	    return idDetalle == other.idDetalle && 
	           Objects.equals(estadoTurno, other.estadoTurno) &&
	           Objects.equals(fecha, other.fecha) &&
	           Objects.equals(descripcion, other.descripcion);
	}

	@Override
	public int hashCode() {
	    // Evitar la inclusión de la referencia a 'Turno' para evitar recursión
	    return Objects.hash(idDetalle, estadoTurno, fecha, descripcion);
	}
	
	



}



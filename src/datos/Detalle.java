package datos;
import java.time.LocalDate;
import java.util.Objects;


public class Detalle {
	private boolean estadoTurno;
	private LocalDate fecha;
	private String descripcion;
	
//Constructor
	
	public Detalle(boolean estadoTurno,LocalDate fecha, String descripcion){
		super();
		this.estadoTurno=estadoTurno;
		this.fecha=fecha;
		this.descripcion=descripcion;
		}
//Getters y Setters

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

//Equals
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detalle other = (Detalle) obj;
		return Objects.equals(descripcion, other.descripcion) && estadoTurno == other.estadoTurno
				&& Objects.equals(fecha, other.fecha);
	}


	//ToString
	
	@Override
	public String toString() {
		return "Detalle [estadoTurno=" + estadoTurno + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}
	
	
}



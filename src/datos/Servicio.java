package datos;

import java.util.Objects;

public class Servicio {
	private long idServicio;
	private String nombreServicio;
	private String descripcion;
	private int duracion;
	private double precio;
	
	//Constructor
	
	public Servicio(String nombreServicio, String descripcion, int duracion, double precio) {
		super();
		this.nombreServicio=nombreServicio;
		this.descripcion=descripcion;
		this.duracion=duracion;
		this.precio=precio;
	}

	//Getters y Setters
	
	public long getIdServicio() {
		return idServicio;
	}

	protected void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	//Equals

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(descripcion, other.descripcion) && duracion == other.duracion
				&& idServicio == other.idServicio && Objects.equals(nombreServicio, other.nombreServicio)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

//ToString
	
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", descripcion="
				+ descripcion + ", duracion=" + duracion + ", precio=" + precio + "]";
	}
	
	//Metodos
	
	
	
	
	
	
	

}

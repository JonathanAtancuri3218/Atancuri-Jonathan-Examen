package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comida
 *
 */
@Entity
public class Comida implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private double precio_unitario;
	@ManyToOne
	@JoinColumn
    private Pedido numeroP;

	
	
	public Comida() {
		
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPrecio_unitario() {
		return precio_unitario;
	}



	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}



	public Pedido getNumeroP() {
		return numeroP;
	}



	public void setNumeroP(Pedido numeroP) {
		this.numeroP = numeroP;
	}



	@Override
	public String toString() {
		return "Comida [codigo=" + codigo + ", nombre=" + nombre + ", precio_unitario=" + precio_unitario + ", numeroP="
				+ numeroP + "]";
	}






	
   
	
   
}

package pe.gob.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Delitos")
public class Delitos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDelitos;
	
	@NotBlank(message = "No permite en blancos")
	@Column(name = "nombreDelitos", length = 60, nullable = false)
	private String nombreDelitos;
	
	@NotBlank(message = "No permite en blancos")
	@Column(name = "descripcion", length = 70, nullable = false)
	private String descripcion;

	public Delitos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delitos(int idDelitos,
			String nomDelitos,
			String descripcion) {
		super();
		this.idDelitos = idDelitos;
		this.nombreDelitos = nomDelitos;
		this.descripcion = descripcion;
	}

	public int getIdDelitos() {
		return idDelitos;
	}

	public void setIdDelitos(int idDelitos) {
		this.idDelitos = idDelitos;
	}

	public String getNomDelitos() {
		return nombreDelitos;
	}

	public void setNomDelitos(String nomDelitos) {
		this.nombreDelitos = nomDelitos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

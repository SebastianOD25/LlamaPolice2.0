package pe.gob.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Delitos")
public class Delitos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDelitos;
	
	@NotBlank(message = "No permite en blancos")
	@NotEmpty(message = "No permiten vacios")
	@Column(name = "nombreDelitos", length = 60, nullable = false)
	private String nomDelitos;
	
	@NotBlank(message = "No permite en blancos")
	@NotEmpty(message = "No permiten vacios")
	@Column(name = "descripcion", length = 70, nullable = false)
	private String descripcion;

	public Delitos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delitos(int idDelitos,
			@NotBlank(message = "No permite en blancos") @NotEmpty(message = "No permiten vacios") String nomDelitos,
			@NotBlank(message = "No permite en blancos") @NotEmpty(message = "No permiten vacios") String descripcion) {
		super();
		this.idDelitos = idDelitos;
		this.nomDelitos = nomDelitos;
		this.descripcion = descripcion;
	}

	public int getIdDelitos() {
		return idDelitos;
	}

	public void setIdDelitos(int idDelitos) {
		this.idDelitos = idDelitos;
	}

	public String getNomDelitos() {
		return nomDelitos;
	}

	public void setNomDelitos(String nomDelitos) {
		this.nomDelitos = nomDelitos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

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
@Table(name = "Comisaria")
public class Comisaria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComisaria;
	
	@NotBlank(message = "No permite en blancos")
	@Column(name = "nombreComisaria", length = 60, nullable = false)
	private String nombreComisaria;
	
	@NotBlank(message = "No permite en blancos")
	@NotEmpty(message = "No permiten vacios")
	@Column(name = "numPolicias", length = 2, nullable = false)
	private int numPolicias;
	
	@NotBlank(message = "No permite en blancos")
	@Column(name = "direccionComisaria", length = 70, nullable = false)
	private String direccion;

	public Comisaria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comisaria(int idComisaria,
			String nomComisaria,
			int numPolicias,
			String direccion) {
		super();
		this.idComisaria = idComisaria;
		this.nombreComisaria = nomComisaria;
		this.numPolicias = numPolicias;
		this.direccion = direccion;
	}

	public int getIdComisaria() {
		return idComisaria;
	}

	public void setIdComisaria(int idComisaria) {
		this.idComisaria = idComisaria;
	}

	public String getNomComisaria() {
		return nombreComisaria;
	}

	public void setNomComisaria(String nombreComisaria) {
		this.nombreComisaria = nombreComisaria;
	}

	public int getNumPolicias() {
		return numPolicias;
	}

	public void setNumPolicias(int numPolicias) {
		this.numPolicias = numPolicias;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}

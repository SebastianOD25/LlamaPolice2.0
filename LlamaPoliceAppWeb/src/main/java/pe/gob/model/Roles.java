package pe.gob.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	
	@Column(name = "nombreRol", nullable = false, length = 15, unique= true)
	private String nombreRol;
	
	private String authority;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int idRol, String nombreRol, String authority) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.authority = authority;
	}

	public int getId() {
		return idRol;
	}

	public void setId(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}

package pe.gob.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Reporte")
public class Reporte implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReporte;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="Descripcion", nullable=false, length=30)
	private String Descripcion;
	
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable = false)	
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name="idDenuncias", nullable = false)	
	private Denuncias denuncia;

	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reporte(int idReporte, @NotBlank(message = "No puede estar en blanco") String descripcion, Usuarios usuario,
			Denuncias denuncia) {
		super();
		this.idReporte = idReporte;
		Descripcion = descripcion;
		this.usuario = usuario;
		this.denuncia = denuncia;
	}

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Denuncias getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(Denuncias denuncia) {
		this.denuncia = denuncia;
	}
	
}

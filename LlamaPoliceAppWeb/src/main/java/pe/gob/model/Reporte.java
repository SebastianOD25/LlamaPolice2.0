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
@Table(name="Reporte")
public class Reporte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReporte;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descripcion", length=80, nullable=false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="idDenuncias", nullable = false)	
	private Denuncias denuncias;
	
	@ManyToOne
	@JoinColumn(name="idPolicia", nullable = false)	
	private Policia policia;

	
	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reporte(int idReporte, 
			String descripcion,
			Denuncias denuncias,
			Policia policia) {
		super();
		this.idReporte = idReporte;
		this.descripcion = descripcion;
		this.denuncias = denuncias;
		this.policia = policia;
	}

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Denuncias getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(Denuncias denuncias) {
		this.denuncias = denuncias;
	}

	public Policia getPolicia() {
		return policia;
	}

	public void setPolicia(Policia policia) {
		this.policia = policia;
	}

	
}
package pe.gob.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Fiscal")
public class Fiscal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFiscal;
	
	@Column(name="telefono", nullable=false, length=6)
	private int telefono;
	
	@Column(name="numFiscal", nullable=false, length=8)
	private int numFiscal;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="nombreFiscal", nullable=false, length=30)
	private String nombreFiscal;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	

	public Fiscal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fiscal(int idFiscal, 
			int telefono, 
			int numFiscal,
			String nombreFiscal,
			Date fechaNacimiento) {
		super();
		this.idFiscal = idFiscal;
		this.telefono = telefono;
		this.numFiscal = numFiscal;
		this.nombreFiscal = nombreFiscal;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(int idFiscal) {
		this.idFiscal = idFiscal;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNumFiscal() {
		return numFiscal;
	}

	public void setNumFiscal(int numFiscal) {
		this.numFiscal = numFiscal;
	}

	public String getNombreFiscal() {
		return nombreFiscal;
	}

	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
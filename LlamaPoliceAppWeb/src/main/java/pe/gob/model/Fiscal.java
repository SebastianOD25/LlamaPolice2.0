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
@Table(name = "Fiscal")
public class Fiscal implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFiscal;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="codFiscal", nullable=false, length=30)
	private int codFiscal;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="nombreFiscal", nullable=false, length=30)
	private String nombreFiscal;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="numTelef", nullable=false, length=30)
	private int numTelef;
	
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

	public Fiscal(int idFiscal, @NotBlank(message = "No puede estar en blanco") int codFiscal,
			@NotBlank(message = "No puede estar en blanco") String nombreFiscal,
			@NotBlank(message = "No puede estar en blanco") int numTelef,
			@NotNull @Past(message = "No puedes seleccionar un dia que NO Existe") Date fechaNacimiento) {
		super();
		this.idFiscal = idFiscal;
		this.codFiscal = codFiscal;
		this.nombreFiscal = nombreFiscal;
		this.numTelef = numTelef;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(int idFiscal) {
		this.idFiscal = idFiscal;
	}

	public int getCodFiscal() {
		return codFiscal;
	}

	public void setCodFiscal(int codFiscal) {
		this.codFiscal = codFiscal;
	}

	public String getNombreFiscal() {
		return nombreFiscal;
	}

	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}

	public int getNumTelef() {
		return numTelef;
	}

	public void setNumTelef(int numTelef) {
		this.numTelef = numTelef;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}

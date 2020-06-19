package pe.gob.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Policia")
public class Policia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPolicia;
	
	@Size(min = 6 ,max = 6)
	@Column(name="placa", nullable=false, length=6)
	private int placa;
	
	@Size(min = 8 ,max = 8)
	@Column(name="dniPolicia", nullable=false, length=8)
	private int dni;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="RangoPolicia", nullable=false, length=15)
	private String rango;
	
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="nombrePolicia", nullable=false, length=30)
	private String nombrePolicia;
	
	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNacimiento")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="idComisaria", nullable = false)	
	private Comisaria comisaria;

	public Policia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policia(int idPolicia, int placa, int dni, String rango,
			String nombrePolicia,
			Date fechaNacimiento,
			Comisaria comisaria) {
		super();
		this.idPolicia = idPolicia;
		this.placa = placa;
		this.dni = dni;
		this.rango = rango;
		this.nombrePolicia = nombrePolicia;
		this.fechaNacimiento = fechaNacimiento;
		this.comisaria = comisaria;
	}

	public int getIdPolicia() {
		return idPolicia;
	}

	public void setIdPolicia(int idPolicia) {
		this.idPolicia = idPolicia;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getNombrePolicia() {
		return nombrePolicia;
	}

	public void setNombrePolicia(String nombrePolicia) {
		this.nombrePolicia = nombrePolicia;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Comisaria getComisaria() {
		return comisaria;
	}

	public void setComisaria(Comisaria comisaria) {
		this.comisaria = comisaria;
	}
	
}

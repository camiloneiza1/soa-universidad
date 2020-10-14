package co.edu.ucentral.common.intentoEvaluacion.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.ucentral.common.estudiante.model.Estudiante;

@Entity
@Table(name = "evaluaciones_intentos")
public class EvaluacionIntento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private float calificacion;
	private int puntos;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="estudiante_id")
	private Estudiante estudiante;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="evaluacion_intento_id")
	private List<RespuestaPregunta> rPreguntas;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@PrePersist
	private void prePersist() {
		this.createAt = new Date();
	}
	
	public EvaluacionIntento() {
		this.rPreguntas= new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public float getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	

	public List<RespuestaPregunta> getrPreguntas() {
		return rPreguntas;
	}


	public void setrPreguntas(List<RespuestaPregunta> rPreguntas) {
		this.rPreguntas = rPreguntas;
	}

	public void addrPregunta(RespuestaPregunta rPreguntas) {
		this.rPreguntas.add(rPreguntas);
	}
	
	public void removerPregunta(RespuestaPregunta rPreguntas) {
		this.rPreguntas.remove(rPreguntas);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

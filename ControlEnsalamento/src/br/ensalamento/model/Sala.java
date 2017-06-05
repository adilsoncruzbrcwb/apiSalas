package br.ensalamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SALA")
public class Sala implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 5878830439335072748L;

	private int 		idSala;
	private int 		capacidade;
	private TipoDeSala tipoSala;


	/* Métodos de acesso */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column (name = "IDSALA")
	public int getIdSala() {return idSala;}
	public void setIdSala(int idSala) {	this.idSala = idSala;}

	@Column (name = "CAPACIDADE")
	public int getCapacidade() {return capacidade;}
	public void setCapacidade(int capacidade) {	this.capacidade = capacidade;}

	@ManyToOne()
	@JoinColumn(name = "TIPO_SALA")
	public TipoDeSala getTipoSala() {
		return tipoSala;
	}
	public void setTipoSala(TipoDeSala tipoSala) {
		this.tipoSala = tipoSala;
	}

	/* Métodos da classe Object */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + idSala;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (capacidade != other.capacidade)
			return false;
		if (idSala != other.idSala)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException { return super.clone(); }
}

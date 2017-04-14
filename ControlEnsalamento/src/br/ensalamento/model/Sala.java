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

	/* Métodos de acesso */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column (name = "IDSALA")
	private int idSala;
	public int getIdSala() {return idSala;}
	public void setIdSala(int idSala) {	this.idSala = idSala;}

	@Column (name = "CAPACIDADE")
	private int capacidade;
	public int getCapacidade() {return capacidade;}
	public void setCapacidade(int capacidade) {	this.capacidade = capacidade;}
	
	@ManyToOne()
	@JoinColumn(name = "SALA_ENSALAMENTO") // Nome da chave estrangeira na tabela
	private Ensalamento ensalamento;
	public Ensalamento getEnsalamento() {return ensalamento;}
	public void setEnsalamento(Ensalamento ensalamento) {this.ensalamento = ensalamento;}
	
	/* Métodos da classe Object */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + ((ensalamento == null) ? 0 : ensalamento.hashCode());
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
		if (ensalamento == null) {
			if (other.ensalamento != null)
				return false;
		} else if (!ensalamento.equals(other.ensalamento))
			return false;
		if (idSala != other.idSala)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException { return super.clone(); }
}

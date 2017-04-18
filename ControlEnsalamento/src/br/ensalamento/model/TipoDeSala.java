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
@Table(name = "TB_TIPOSALA")
public class TipoDeSala implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 5878830439335072748L;
	

	private int idTipoSala;
	private String nomeTipo;
	private Sala mSala;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "IDTIPOSALA")
	public int getIdTipoSala() { return idTipoSala; }
	public void setIdTipoSala(int idTipoSala) { this.idTipoSala = idTipoSala; }
	
	@Column(name = "NOMETIPO")
	public String getNomeTipo() { return nomeTipo; }
	public void setNomeTipo(String nomeTipo) { this.nomeTipo = nomeTipo; }
	
	@ManyToOne()
	@JoinColumn(name = "tipo_sala") // Nome da chave estrangeira na tabela
	public Sala getmSala() { return mSala; }
	public void setmSala(Sala mSala) { this.mSala = mSala; }

	/* Métodos da classe Object */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoSala;
		result = prime * result + ((mSala == null) ? 0 : mSala.hashCode());
		result = prime * result + ((nomeTipo == null) ? 0 : nomeTipo.hashCode());
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
		TipoDeSala other = (TipoDeSala) obj;
		if (idTipoSala != other.idTipoSala)
			return false;
		if (mSala == null) {
			if (other.mSala != null)
				return false;
		} else if (!mSala.equals(other.mSala))
			return false;
		if (nomeTipo == null) {
			if (other.nomeTipo != null)
				return false;
		} else if (!nomeTipo.equals(other.nomeTipo))
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException { return super.clone(); }

}
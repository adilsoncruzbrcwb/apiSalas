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
@Table(name = "TB_PROFESSOR")
public class Professor implements Serializable, Cloneable {
	/* Atributos est�ticos */
	private static final long serialVersionUID = 2179092916642396463L;

	/* Atributos normais */
	private int matricula;
	private String nomeProfessor;
	private String status;
	private Ensalamento ensalamento;

	/* M�todos de Acesso */
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "MATRICULA")
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int pMatricula) {
		matricula = pMatricula;
	}



	@Column (name = "NomeProfessor")
	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	@Column (name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne()
	@JoinColumn(name = "PROFESSOR_ENSALAMENTO") // Nome da chave estrangeira na tabela
	public Ensalamento getEnsalamento() {
		return ensalamento;
	}

	public void setEnsalamento(Ensalamento ensalamento) {
		this.ensalamento = ensalamento;
	}

	

	// M�todos da classe Object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ensalamento == null) ? 0 : ensalamento.hashCode());
		result = prime * result + matricula;
		result = prime * result + ((nomeProfessor == null) ? 0 : nomeProfessor.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Professor other = (Professor) obj;
		if (ensalamento == null) {
			if (other.ensalamento != null)
				return false;
		} else if (!ensalamento.equals(other.ensalamento))
			return false;
		if (matricula != other.matricula)
			return false;
		if (nomeProfessor == null) {
			if (other.nomeProfessor != null)
				return false;
		} else if (!nomeProfessor.equals(other.nomeProfessor))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

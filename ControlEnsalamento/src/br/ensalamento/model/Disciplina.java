package br.ensalamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "TB_DISCIPLINA")
public class Disciplina implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 5699351420962097011L;

	/* Atributos normais */
	private int idDisciplina;
	private String descricaoDisciplinas;



	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	@Column (name = "IDDISCIPLINA")
	public int getIdDisciplina() { return idDisciplina;}
	public void setIdDisciplina(int idDisciplina) {	this.idDisciplina = idDisciplina;}

	@Column (name = "DescricaoDisciplina")
	public String getDescricaoDisciplinas() {return descricaoDisciplinas;}
	public void setDescricaoDisciplinas(String descricaoDisciplinas) { this.descricaoDisciplinas = descricaoDisciplinas;}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoDisciplinas == null) ? 0 : descricaoDisciplinas.hashCode());
		result = prime * result + idDisciplina;
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
		Disciplina other = (Disciplina) obj;
		if (descricaoDisciplinas == null) {
			if (other.descricaoDisciplinas != null)
				return false;
		} else if (!descricaoDisciplinas.equals(other.descricaoDisciplinas))
			return false;
		if (idDisciplina != other.idDisciplina)
			return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {return super.clone();}
}

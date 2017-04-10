package br.ensalamento.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 3162938596466740097L;

	/* Atributos normais */
	private int idCurso;
	private String nomeCurso;
	private Turma mTurma;

	public Curso() {
		super();
	}

	public Curso(int pIdCurso, String pTurma) {
		super();
		setIdCurso(pIdCurso);
		setNomeCurso(pTurma);
	}

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "IDCURSO")
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int pIdCurso) {
		idCurso = pIdCurso;
	}

	@Column(name = "NOMECURSO")
	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String pNomeCurso) {
		nomeCurso = pNomeCurso;
	}

	@ManyToOne()
	@JoinColumn(name = "CURSO_TURMA") // Nome da chave estrangeira na tabela
	public Turma getmTurma() {
		return mTurma;
	}

	public void setmTurma(Turma mTurma) {
		this.mTurma = mTurma;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCurso;
		result = prime * result + ((mTurma == null) ? 0 : mTurma.hashCode());
		result = prime * result + ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (idCurso != other.idCurso)
			return false;
		if (mTurma == null) {
			if (other.mTurma != null)
				return false;
		} else if (!mTurma.equals(other.mTurma))
			return false;
		if (nomeCurso == null) {
			if (other.nomeCurso != null)
				return false;
		} else if (!nomeCurso.equals(other.nomeCurso))
			return false;
		return true;
	}

	// public int compateTo(Curso pObj){
	// return getIdCurso().compareTo(pObj.getIdCurso());
	// }
	public static class NomeComparador implements Comparator<Curso> {
		@Override
		public int compare(Curso pObj1, Curso pObj2) {
			return pObj1.getNomeCurso().compareTo(pObj2.getNomeCurso());
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

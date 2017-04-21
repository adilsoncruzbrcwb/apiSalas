
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
@Table(name = "TB_TURMA")
public class Turma implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 3162938596466740097L;

	private String idTurma;
	private int quantidadeAlunos;
	private Ensalamento ensalamento;
	
	/* Métodos de acesso */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTURMA")
	public String getIdTurma() { return idTurma; }
	public void setIdTurma(String idTurma) { this.idTurma = idTurma; }

	@Column(name = "QUANTIDADEALUNOS")
	public int getQuantidadeAlunos() { return quantidadeAlunos; }
	public void setQuantidadeAlunos(int quantidadeAlunos) { this.quantidadeAlunos = quantidadeAlunos; }
	
	@ManyToOne()
	@JoinColumn(name = "TURMA_ENSALAMENTO") // Nome da chave estrangeira na tabela
	public Ensalamento getEnsalamento() { return ensalamento; }
	public void setEnsalamento(Ensalamento ensalamento) { this.ensalamento = ensalamento; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
		result = prime * result + quantidadeAlunos;
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
		Turma other = (Turma) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Turma [");
		builder.append(idTurma);
		builder.append(", ");
		builder.append(quantidadeAlunos);
		builder.append(", ");
		builder.append("]");
		return builder.toString();
	}

}


package br.ensalamento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.ensalamento.enums.Turno;

@Entity
@Table(name = "ENSALAMENTO")
public class Ensalamento extends Usuario implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 2179092916642396463L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "IDENSALAMENTO")
	private int idEnsalamento;

	@Column(name = "TURNO")
	private Turno turno;

	@Column(name = "DATAINICIO")
	private Date datainicio;

	@Column(name = "DATAFIM")
	private Date dataFim;

	@Column(name = "DIADASEMANA")
	private String diaDaSemana;

	@Column(name = "DISPONIBILIDADE")
	private String disponibilidade;

	public int getIdEnsalamento() {
		return idEnsalamento;
	}

	public void setIdEnsalamento(int idEnsalamento) {
		this.idEnsalamento = idEnsalamento;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((datainicio == null) ? 0 : datainicio.hashCode());
		result = prime * result + ((diaDaSemana == null) ? 0 : diaDaSemana.hashCode());
		result = prime * result + ((disponibilidade == null) ? 0 : disponibilidade.hashCode());
		result = prime * result + idEnsalamento;
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ensalamento other = (Ensalamento) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (datainicio == null) {
			if (other.datainicio != null)
				return false;
		} else if (!datainicio.equals(other.datainicio))
			return false;
		if (diaDaSemana == null) {
			if (other.diaDaSemana != null)
				return false;
		} else if (!diaDaSemana.equals(other.diaDaSemana))
			return false;
		if (disponibilidade == null) {
			if (other.disponibilidade != null)
				return false;
		} else if (!disponibilidade.equals(other.disponibilidade))
			return false;
		if (idEnsalamento != other.idEnsalamento)
			return false;
		if (turno != other.turno)
			return false;
		return true;
	}
}

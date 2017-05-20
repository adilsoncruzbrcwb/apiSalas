
package br.ensalamento.model;

import java.io.Serializable;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.ensalamento.enums.Turno;

@Table
@Entity(name = "Ensalamento")
public class Ensalamento implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 2179092916642396463L;

	private int 	idEnsalamento;
	private Date 	datainicio;
	private Date 	dataFim;
	private String 	diaDaSemana;
	private Boolean disponibilidade;
	private Turno 	turno;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDENSALAMENTO")
	public int getIdEnsalamento() { return idEnsalamento; }
	public void setIdEnsalamento(int idEnsalamento) { this.idEnsalamento = idEnsalamento; }
	
	@Column(name = "TURNO")
	public Turno getTurno() { return turno; }
	public void setTurno(Turno turno) { this.turno = turno; }
	
	@Column(name = "DATAINICIO")
	public Date getDatainicio() { return datainicio; }
	public void setDatainicio(Date datainicio) { this.datainicio = datainicio; }
	
	@Column(name = "DATAFIM")
	public Date getDataFim() { return dataFim; }
	public void setDataFim(Date dataFim) { this.dataFim = dataFim; }
	
	@Column(name = "DIADASEMANA")
	public String getDiaDaSemana() { return diaDaSemana; }
	public void setDiaDaSemana(String diaDaSemana) { this.diaDaSemana = diaDaSemana; }
	
	@Column(name = "DISPONIBILIDADE")
	public Boolean getDisponibilidade() { return disponibilidade; }
	public void setDisponibilidade(Boolean disponibilidade) { this.disponibilidade = disponibilidade; }

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

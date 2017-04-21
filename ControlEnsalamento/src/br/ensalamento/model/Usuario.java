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
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable, Cloneable {
	/* Atributos estáticos */
	private static final long serialVersionUID = 2179092916642396463L;
	
	private int matricula;
 	private Ensalamento ensalamento;	
	private String nomeCompleto;
	private String tipoUsuario;
	private String email;
	private String senha;
	private Sala sala;
	private Turma turma;
	
	/* Métodos de Acesso */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATRICULA")
	public int getMatricula() {return matricula;}
	public void setMatricula(int pMatricula) {matricula = pMatricula;}

	@Column (name = "STATUS")
	private Boolean status;
	public Boolean getStatus() {return status;}
	public void setStatus(Boolean status) {this.status = status;}

	@ManyToOne
	@JoinColumn(name = "USUARIO_ENSALAMENTO") // Nome da chave estrangeira na tabela
	public Ensalamento getEnsalamento() {return ensalamento;}
	public void setEnsalamento(Ensalamento ensalamento) {this.ensalamento = ensalamento;}

	@Column (name = "NomeCompleto")
	public String getNomeCompleto() {return nomeCompleto;}
	public void setNomeCompleto(String nomeCompleto) {this.nomeCompleto = nomeCompleto;}
	
	@Column (name = "TipoUsuario")
	public String getTipoUsuario() {return tipoUsuario;}
	public void setTipoUsuario(String tipoUsuario) {this.tipoUsuario = tipoUsuario;}
	
	@Column (name = "Email")
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	@Column (name = "Senha")
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	
	@ManyToOne()
	@JoinColumn(name = "USUARIO_SALA") // Nome da chave estrangeira na tabela
	public Sala getSala() {return sala;}
	public void setSala(Sala sala) {this.sala = sala;}
	
	@ManyToOne()
	@JoinColumn(name = "USUARIO_TURMA") // Nome da chave estrangeira na tabela
	public Turma getTurma() {return turma;}
	public void setTurma(Turma turma) {this.turma = turma;}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ensalamento == null) ? 0 : ensalamento.hashCode());
		result = prime * result + matricula;
		result = prime * result + ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ensalamento == null) {
			if (other.ensalamento != null)
				return false;
		} else if (!ensalamento.equals(other.ensalamento))
			return false;
		if (matricula != other.matricula)
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoUsuario == null) {
			if (other.tipoUsuario != null)
				return false;
		} else if (!tipoUsuario.equals(other.tipoUsuario))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {return super.clone();}


}

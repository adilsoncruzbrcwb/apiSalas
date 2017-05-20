package br.ensalamento.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.ensalamento.model.Ensalamento;

@XmlRootElement(name = "EnsalamentosDTO")
public class EnsalamentosDTO extends AbstractDTO<Ensalamento> {
	
	/* Construtores da classe */
	public EnsalamentosDTO() { super(); }

	public EnsalamentosDTO(boolean pOk, String pMensagem) { super(pOk, pMensagem); }

	public EnsalamentosDTO(boolean pOk, String pMensagem, Ensalamento pAluno) { super(pOk, pMensagem, pAluno); }

	public EnsalamentosDTO(boolean pOk, String pMensagem, List<Ensalamento> pLista) { super(pOk, pMensagem, pLista); }

	/* Metodos de acesso */
	public Ensalamento getAluno() { return getObjeto(); }

	public void setAluno(Ensalamento pAluno) { setObjeto(pAluno); }
}

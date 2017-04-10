package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.Disciplina;

public class DisciplinaDTO extends AbstractDTO<Disciplina> {
	/* Construtores da classe */
	public DisciplinaDTO(boolean pOk, String pMensagem) {
		super(pOk, pMensagem);
	}

	public DisciplinaDTO(boolean pOk, String pMensagem, Disciplina pDisciplina) {
		super(pOk, pMensagem, pDisciplina);
	}

	public DisciplinaDTO(boolean pOk, String pMensagem, List<Disciplina> pLista) {
		super(pOk, pMensagem, pLista);
	}

	/* Métodos de acesso */
	public Disciplina getDisciplina() {
		return getObjeto();
	}

	public void setDisciplina(Disciplina pDisciplina) {
		setObjeto(pDisciplina);
	}
}

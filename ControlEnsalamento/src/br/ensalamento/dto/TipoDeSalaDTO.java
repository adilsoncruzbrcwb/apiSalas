package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.TipoDeSala;

public class TipoDeSalaDTO extends AbstractDTO<TipoDeSala> {
	public TipoDeSalaDTO(boolean pOk, String pMensagem) {
		super(pOk, pMensagem);
	}

	public TipoDeSalaDTO(boolean pOk, String pMensagem, TipoDeSala pDisciplina) {
		super(pOk, pMensagem, pDisciplina);
	}

	public TipoDeSalaDTO(boolean pOk, String pMensagem, List<TipoDeSala> pLista) {
		super(pOk, pMensagem, pLista);
	}

	public TipoDeSala getTipoDeSala() {
		return getObjeto();
	}

	public void setTipoDeSala(TipoDeSala pTipoDeSala) {
		setObjeto(pTipoDeSala);
	}

}

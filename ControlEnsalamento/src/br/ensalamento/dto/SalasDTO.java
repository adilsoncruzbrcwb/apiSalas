package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.Sala;

public class SalasDTO extends AbstractDTO<Sala> {
	/* Construtores da classe */
	public SalasDTO(boolean pOk, String pMensagem) { super(pOk, pMensagem); }

	public SalasDTO(boolean pOk, String pMensagem, Sala pSalas) { super(pOk, pMensagem, pSalas); }

	public SalasDTO(boolean pOk, String pMensagem, List<Sala> pLista) { super(pOk, pMensagem, pLista); }

	/* Metodos de acesso */
	public Sala getSalas() { return getObjeto(); }

	public void setSalas(Sala pSalas) { setObjeto(pSalas); }

}

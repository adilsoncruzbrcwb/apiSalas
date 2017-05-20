package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.Curso;

public class CursoDTO extends AbstractDTO<Curso> {
	
	/* Construtores da classe */
	public CursoDTO(boolean pOk, String pMensagem) { super(pOk, pMensagem); }

	public CursoDTO(boolean pOk, String pMensagem, Curso pCurso) { super(pOk, pMensagem, pCurso); }

	public CursoDTO(boolean pOk, String pMensagem, List<Curso> pLista) { super(pOk, pMensagem, pLista); }

	/* Metodos de acesso */
	public Curso getCurso() { return getObjeto(); }

	public void setCurso(Curso pCurso) { setObjeto(pCurso);}

}

package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.TipoDeSalaDAO;
import br.ensalamento.dto.TipoDeSalaDTO;
import br.ensalamento.model.TipoDeSala;

public class TipoDeSalaController {
//	Cadastrar
	public static TipoDeSalaDTO cadastrar(TipoDeSala pTipoDeSala) {
		if (pTipoDeSala == null)
			return new TipoDeSalaDTO(false, "Nula");

		TipoDeSalaDAO tDao = DaoFactory.geTipoDeSalaDAO();
		TipoDeSala tSala = tDao.create(pTipoDeSala);

		if (tSala == null)
			return new TipoDeSalaDTO(false, "problema gravacao", tSala);
		return new TipoDeSalaDTO(true, "Cadastrado", tSala);
	}
//	Recuperar
	public static TipoDeSalaDTO recuperar(int pCodigo) {
		TipoDeSalaDAO tDao = DaoFactory.geTipoDeSalaDAO();
		TipoDeSala tCurso = tDao.recovery(pCodigo);

		if (tCurso == null)
			return new TipoDeSalaDTO(false, "Não Existe");

		return new TipoDeSalaDTO(true, "Sucesso", tCurso);
	}
//	Atualizar
	public static TipoDeSalaDTO atualizar (TipoDeSala pSala){
		if (pSala == null)
			return new TipoDeSalaDTO(false, "Nula");
		
		TipoDeSalaDAO tDao = DaoFactory.geTipoDeSalaDAO();
		TipoDeSala tCurso = tDao.update(pSala);
		
		if (tCurso == null)
			return new TipoDeSalaDTO(false, "não existe");
		return new TipoDeSalaDTO(true, "Atualizado", tCurso);
	}
//	Deletar
	public static TipoDeSalaDTO remover (int pCodigo){
		TipoDeSalaDAO tDao = DaoFactory.geTipoDeSalaDAO();
		if (!tDao.delete(pCodigo))
			return new TipoDeSalaDTO(false, "não existe");
		return new TipoDeSalaDTO(true, "removido");
		
	}
// Pesquisar
	public static TipoDeSalaDTO pesquisar(){
		TipoDeSalaDAO tDao = DaoFactory.geTipoDeSalaDAO();
		List<TipoDeSala> tLista = tDao.search();
		
		if (tLista.isEmpty())
			return new TipoDeSalaDTO(false, "Vazia");
		
		return new TipoDeSalaDTO(true, "Recuperado",tLista);
		
	}
	
// Pesquisar por Nome
	public static TipoDeSalaDTO searchByTipoDeSala(int pCodigo) {
		
		if (pCodigo == 0)
			return pesquisar();

		TipoDeSalaDAO tDao = DaoFactory.geTipoDeSalaDAO();
		List<TipoDeSala> tLista = tDao.searchByTipo(pCodigo);

		if (tLista.isEmpty())
			return new TipoDeSalaDTO(false, "Nenhum nome '" + pCodigo + "'");

		return new TipoDeSalaDTO(true, "Lista recuperada", tLista);
	}
}

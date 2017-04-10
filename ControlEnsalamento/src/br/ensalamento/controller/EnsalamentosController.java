package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.EnsalmentosDAO;
import br.ensalamento.dto.EnsalamentosDTO;
import br.ensalamento.model.Ensalamento;

public class EnsalamentosController {
	public static EnsalamentosDTO cadastrar(Ensalamento pEnsalamento) {

		if (pEnsalamento == null)
			return new EnsalamentosDTO(false, "Tentativa Nula");
		EnsalmentosDAO tDao = DaoFactory.getEnsalamentoDAO();
		Ensalamento tEnsalamento = tDao.create(pEnsalamento);

		if (tEnsalamento == null)
			return new EnsalamentosDTO(false, "Problema gravação");
		return new EnsalamentosDTO(true, "Gravado", tEnsalamento);

	}

	public static EnsalamentosDTO recuperar(int pCodigo) {
		EnsalmentosDAO tDao = DaoFactory.getEnsalamentoDAO();
		Ensalamento tEnsalamento = tDao.recovery(pCodigo);

		if (tEnsalamento == null)
			return new EnsalamentosDTO(false, "Não existe");
		return new EnsalamentosDTO(true, "Lida", tEnsalamento);

	}

	public static EnsalamentosDTO atualizar(Ensalamento pEnsalamento) {
		if (pEnsalamento == null)
			return new EnsalamentosDTO(false, "ensalamento nulo");

		EnsalmentosDAO tDao = DaoFactory.getEnsalamentoDAO();
		Ensalamento tEnsalamento = tDao.update(pEnsalamento);

		if (tEnsalamento == null)
			return new EnsalamentosDTO(false, "não existe");
		return new EnsalamentosDTO(true, "atualizado", tEnsalamento);

	}

	public static EnsalamentosDTO remover(int pCodigo) {
		EnsalmentosDAO tDao = DaoFactory.getEnsalamentoDAO();
		if (!tDao.delete(pCodigo))
			return new EnsalamentosDTO(false, "sem cadastro");
		return new EnsalamentosDTO(true, "Sucesse");

	}

	public static EnsalamentosDTO pesquisar() {
		EnsalmentosDAO tDao = DaoFactory.getEnsalamentoDAO();
		List<Ensalamento> tLista = tDao.search();
		
		if (tLista.isEmpty())
			return new EnsalamentosDTO(false, "vazia");
		return new EnsalamentosDTO(true, "recuperado", tLista);
	}

	public static EnsalamentosDTO pesquisarPorSemana(String pDiaDaSemana) {
		if (pDiaDaSemana == null)
			return pesquisar();
		EnsalmentosDAO tDao = DaoFactory.getEnsalamentoDAO();
		List<Ensalamento> tLista = tDao.searchByNome(pDiaDaSemana);
		
		if (tLista.isEmpty())
			return new EnsalamentosDTO(false, "nenhum '" + pDiaDaSemana + "'" );
		return new EnsalamentosDTO(true, "recuperado",tLista);
	}

}

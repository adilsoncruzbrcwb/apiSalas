/*
 * ProfessorController.java
 *
 * Classe que implementa os servi�os de manuten��o de professors
 *
 * � 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Hist�rico
 * 14/07/2016 � Vers�o 1.0 - Jos� Augusto � Cria��o do arquivo
 *
 */
package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.ProfessorDAO;
import br.ensalamento.dto.ProfessorDTO;
import br.ensalamento.model.Professor;

public class ProfessorController {
	// M�todo para criar um professor
	public static ProfessorDTO cadastrar(Professor pProfessor) {
		if (pProfessor == null)
			return new ProfessorDTO(false, "Tentativa de inserir um professor nulo");

		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		Professor tProfessor = tDao.create(pProfessor);

		if (tProfessor == null)
			return new ProfessorDTO(false, "Problemas na grava��o do professor");

		return new ProfessorDTO(true, "Professor gravado com sucesso", tProfessor);
	}

	// M�todo para recuperar um professor
	public static ProfessorDTO recuperar(int pMatricula) {
		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		Professor tProfessor = tDao.recovery(pMatricula);

		if (tProfessor == null)
			return new ProfessorDTO(false, "Professor n�o existe no cadastro");

		return new ProfessorDTO(true, "Professor lido com sucesso", tProfessor);
	}

	// M�todo para atualizar um professor
	public static ProfessorDTO atualizar(Professor pProfessor) {
		if (pProfessor == null)
			return new ProfessorDTO(false, "Tentativa de atualizar um professor nulo");

		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		Professor tProfessor = tDao.update(pProfessor);

		if (tProfessor == null)
			return new ProfessorDTO(false, "Professor n�o existe no cadastro");

		return new ProfessorDTO(true, "Professor regravado com sucesso", tProfessor);
	}

	// M�todo para deletar um professor
	public static ProfessorDTO remover(int pMatricula) {
		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		if (!tDao.delete(pMatricula))
			return new ProfessorDTO(false, "Professor n�o existe no cadastro");

		return new ProfessorDTO(true, "Professor removido com sucesso");
	}

	// M�todo para pesquisar todos os professors
	public static ProfessorDTO pesquisar() {
		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		List<Professor> tLista = tDao.search();

		if (tLista.isEmpty())
			return new ProfessorDTO(false, "Lista de professors vazia");

		return new ProfessorDTO(true, "Lista de professors recuperada", tLista);
	}

	// M�todo para pesquisar por nome todos os professors
	public static ProfessorDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();

		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		List<Professor> tLista = tDao.searchByNome(pNome);

		if (tLista.isEmpty())
			return new ProfessorDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		return new ProfessorDTO(true, "Lista de professors recuperada", tLista);
	}
}

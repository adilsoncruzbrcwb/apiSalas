/*
 * ProfessorController.java
 *
 * Classe que implementa os serviços de manutenção de professors
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
 *
 */
package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.ProfessorDAO;
import br.ensalamento.dto.ProfessorDTO;
import br.ensalamento.model.Professor;

public class ProfessorController {
	// Método para criar um professor
	public static ProfessorDTO cadastrar(Professor pProfessor) {
		if (pProfessor == null)
			return new ProfessorDTO(false, "Tentativa de inserir um professor nulo");

		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		Professor tProfessor = tDao.create(pProfessor);

		if (tProfessor == null)
			return new ProfessorDTO(false, "Problemas na gravação do professor");

		return new ProfessorDTO(true, "Professor gravado com sucesso", tProfessor);
	}

	// Método para recuperar um professor
	public static ProfessorDTO recuperar(int pMatricula) {
		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		Professor tProfessor = tDao.recovery(pMatricula);

		if (tProfessor == null)
			return new ProfessorDTO(false, "Professor não existe no cadastro");

		return new ProfessorDTO(true, "Professor lido com sucesso", tProfessor);
	}

	// Método para atualizar um professor
	public static ProfessorDTO atualizar(Professor pProfessor) {
		if (pProfessor == null)
			return new ProfessorDTO(false, "Tentativa de atualizar um professor nulo");

		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		Professor tProfessor = tDao.update(pProfessor);

		if (tProfessor == null)
			return new ProfessorDTO(false, "Professor não existe no cadastro");

		return new ProfessorDTO(true, "Professor regravado com sucesso", tProfessor);
	}

	// Método para deletar um professor
	public static ProfessorDTO remover(int pMatricula) {
		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		if (!tDao.delete(pMatricula))
			return new ProfessorDTO(false, "Professor não existe no cadastro");

		return new ProfessorDTO(true, "Professor removido com sucesso");
	}

	// Método para pesquisar todos os professors
	public static ProfessorDTO pesquisar() {
		ProfessorDAO tDao = DaoFactory.getProfessorDAO();
		List<Professor> tLista = tDao.search();

		if (tLista.isEmpty())
			return new ProfessorDTO(false, "Lista de professors vazia");

		return new ProfessorDTO(true, "Lista de professors recuperada", tLista);
	}

	// Método para pesquisar por nome todos os professors
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

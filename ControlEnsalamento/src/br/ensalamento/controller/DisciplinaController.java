package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.DisciplinaDAO;
import br.ensalamento.dto.DisciplinaDTO;
import br.ensalamento.model.Disciplina;

public class DisciplinaController {
	// Método para criar uma disciplina
	public static DisciplinaDTO cadastrar(Disciplina pDisciplina) {
		if (pDisciplina == null)
			return new DisciplinaDTO(false, "Tentativa de inserir uma disciplina nula");

		// Chamando a camada de persistência
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		Disciplina tDisciplina = tDao.create(pDisciplina);

		// Verificando se houve erro de criação
		if (tDisciplina == null)
			return new DisciplinaDTO(false, "Problemas na gravação da disciplina");

		// Retornando o indicativo de sucesso com o objeto criado
		return new DisciplinaDTO(true, "Disciplina gravada com sucesso", tDisciplina);
	}

	// Método para recuperar uma disciplina
	public static DisciplinaDTO recuperar(int pCodigo) {
		// Lendo o objeto
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		Disciplina tDisciplina = tDao.recovery(pCodigo);

		// Verificando se houve erro de recuperação
		if (tDisciplina == null)
			return new DisciplinaDTO(false, "Disciplina não existe no cadastro");

		// Retornando o indicativo de sucesso com o objeto recuperado
		return new DisciplinaDTO(true, "Disciplina lida com sucesso", tDisciplina);
	}

	// Método para atualizar uma disciplina
	public static DisciplinaDTO atualizar(Disciplina pDisciplina) {
		if (pDisciplina == null)
			return new DisciplinaDTO(false, "Tentativa de atualizar uma disciplina nula");

		// Chamando a camada de persistência
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		Disciplina tDisciplina = tDao.update(pDisciplina);

		// Verificando se houve erro de atualização
		if (tDisciplina == null)
			return new DisciplinaDTO(false, "Disciplina não existe no cadastro");

		// Retornando o indicativo de sucesso com o objeto atualizado
		return new DisciplinaDTO(true, "Disciplina regravada com sucesso", tDisciplina);
	}

	// Método para deletar uma disciplina
	public static DisciplinaDTO remover(int pCodigo) {
		// Verificando se houve erro de remoção
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		if (!tDao.delete(pCodigo))
			return new DisciplinaDTO(false, "Disciplina não existe no cadastro");

		// Retornando o indicativo de sucesso com o objeto removido
		return new DisciplinaDTO(true, "Disciplina removida com sucesso");
	}

	// Método para pesquisar todas as disciplinas
	public static DisciplinaDTO pesquisar() {
		
		
		
		
		
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		List<Disciplina> tLista = tDao.search();
		if (tLista.isEmpty())
			return new DisciplinaDTO(false, "Lista de disciplinas vazia");

		return new DisciplinaDTO(true, "Lista de disciplinas recuperada", tLista);
	}

	// Método para pesquisar por nome todas as disciplinas
	public static DisciplinaDTO pesquisarPorNome(String pNome) {
		// Caso o nome de pesquisa seja nulo, retorna a lista geral
		if (pNome == null)
			return pesquisar();

		// Obtendo a lista de disciplinas
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		List<Disciplina> tLista = tDao.searchByNome(pNome);

		// Verificando se a lista está vazia
		if (tLista.isEmpty())
			return new DisciplinaDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		// Retornando a lista obtida
		return new DisciplinaDTO(true, "Lista de disciplinas recuperada", tLista);
	}
}

package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.DisciplinaDAO;
import br.ensalamento.dto.DisciplinaDTO;
import br.ensalamento.model.Disciplina;

public class DisciplinaController {

	public static DisciplinaDTO cadastrar(Disciplina pDisciplina) {
		if (pDisciplina == null)
			return new DisciplinaDTO(false, "Tentativa de inserir uma disciplina nula");

		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		Disciplina tDisciplina = tDao.create(pDisciplina);

		if (tDisciplina == null)
			return new DisciplinaDTO(false, "Problemas na gravação da disciplina");

		return new DisciplinaDTO(true, "Disciplina gravada com sucesso", tDisciplina);
	}

	public static DisciplinaDTO recuperar(int pCodigo) {
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		Disciplina tDisciplina = tDao.recovery(pCodigo);

		if (tDisciplina == null)
			return new DisciplinaDTO(false, "Disciplina não existe no cadastro");

		return new DisciplinaDTO(true, "Disciplina lida com sucesso", tDisciplina);
	}

	public static DisciplinaDTO atualizar(Disciplina pDisciplina) {
		if (pDisciplina == null)
			return new DisciplinaDTO(false, "Tentativa de atualizar uma disciplina nula");

		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		Disciplina tDisciplina = tDao.update(pDisciplina);

		if (tDisciplina == null)
			return new DisciplinaDTO(false, "Disciplina não existe no cadastro");

		return new DisciplinaDTO(true, "Disciplina regravada com sucesso", tDisciplina);
	}

	public static DisciplinaDTO remover(int pCodigo) {
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		if (!tDao.delete(pCodigo))
			return new DisciplinaDTO(false, "Disciplina não existe no cadastro");

		return new DisciplinaDTO(true, "Disciplina removida com sucesso");
	}

	public static DisciplinaDTO pesquisar() {
		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		List<Disciplina> tLista = tDao.search();
		if (tLista.isEmpty())
			return new DisciplinaDTO(false, "Lista de disciplinas vazia");

		return new DisciplinaDTO(true, "Lista de disciplinas recuperada", tLista);
	}

	public static DisciplinaDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();

		DisciplinaDAO tDao = DaoFactory.getDisciplinaDAO();
		List<Disciplina> tLista = tDao.searchByNome(pNome);

		if (tLista.isEmpty())
			return new DisciplinaDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		return new DisciplinaDTO(true, "Lista de disciplinas recuperada", tLista);
	}
}

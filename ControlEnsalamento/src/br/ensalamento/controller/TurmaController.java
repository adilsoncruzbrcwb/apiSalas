package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.TurmaDAO;
import br.ensalamento.dto.TurmaDTO;
import br.ensalamento.model.Turma;

public class TurmaController {
	public static TurmaDTO cadastrar(Turma pTurma) {
		if (pTurma == null)
			return new TurmaDTO(false, "nula");

		TurmaDAO tDao = DaoFactory.geTurmaDAO();
		Turma tTurma = tDao.create(pTurma);

		if (tTurma == null)
			return new TurmaDTO(false, "Problema");
		return new TurmaDTO(true, "Sucesso", tTurma);
	}

	public static TurmaDTO recuperar(int pCodigo) {
		TurmaDAO tDao = DaoFactory.geTurmaDAO();
		Turma tTurma = tDao.recovery(pCodigo);

		if (tTurma == null)
			return new TurmaDTO(false, "não existe");
		return new TurmaDTO(true, "Sucesso", tTurma);
	}

	public static TurmaDTO atualizar(Turma pTurma) {
		if (pTurma == null)
			return new TurmaDTO(false, "Problema");

		TurmaDAO tDao = DaoFactory.geTurmaDAO();
		Turma tTurma = tDao.update(pTurma);

		if (tTurma == null)
			return new TurmaDTO(false, "Não Existe");
		return new TurmaDTO(true, "Sucesso", tTurma);
	}
	
	public static TurmaDTO remover (int pCodigo){
		TurmaDAO tDao = DaoFactory.geTurmaDAO();
		if (!tDao.delete(pCodigo))
			return new TurmaDTO(false, "não existe");
		return new TurmaDTO(true, "Sucesso");
	}
	
	public static TurmaDTO pesquisar (){
		TurmaDAO tDao = DaoFactory.geTurmaDAO();
		List<Turma> tLista = tDao.search();
		if(tLista.isEmpty())
			return new TurmaDTO(false, "Vazia");
		return new TurmaDTO(true, "recuperada", tLista);
	}
	
	public static TurmaDTO searchByProfessor (int pMatriculaProfessor){
		if (pMatriculaProfessor == 0)
			return pesquisar();
		
		TurmaDAO tDao = DaoFactory.geTurmaDAO();
		List<Turma> tLista = tDao.searchByProfessor(pMatriculaProfessor);
		
		if (tLista.isEmpty())
			return new TurmaDTO(false, "não encontrado '" + pMatriculaProfessor +"'");
		return new TurmaDTO(true, "recuperada", tLista);
	}
	
	
}

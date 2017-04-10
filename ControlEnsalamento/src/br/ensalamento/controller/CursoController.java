package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.CursoDao;
import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dto.CursoDTO;
import br.ensalamento.model.Curso;

public class CursoController {
//	Cadastrar
	public static CursoDTO cadastrar(Curso pCurso) {
		if (pCurso == null)
			return new CursoDTO(false, "Nula");

		CursoDao tDao = DaoFactory.getCursoDao();
		Curso tCurso = tDao.create(pCurso);

		if (tCurso == null)
			return new CursoDTO(false, "problema gravacao", tCurso);
		return new CursoDTO(true, "Cadastrado", tCurso);
	}
//	Recuperar
	public static CursoDTO recuperar(int pCodigo) {
		CursoDao tDao = DaoFactory.getCursoDao();
		Curso tCurso = tDao.recovery(pCodigo);

		if (tCurso == null)
			return new CursoDTO(false, "Não Existe");

		return new CursoDTO(true, "Sucesso", tCurso);
	}
//	Atualizar
	public static CursoDTO atualizar (Curso pCurso){
		if (pCurso == null)
			return new CursoDTO(false, "Nula");
		
		CursoDao tDao = DaoFactory.getCursoDao();
		Curso tCurso = tDao.update(pCurso);
		
		if (tCurso == null)
			return new CursoDTO(false, "não existe");
		return new CursoDTO(true, "Atualizado", tCurso);
	}
//	Deletar
	public static CursoDTO remover (int pCodigo){
		CursoDao tDao = DaoFactory.getCursoDao();
		if (!tDao.delete(pCodigo))
			return new CursoDTO(false, "não existe");
		return new CursoDTO(true, "removido");
		
	}
// Pesquisar
	public static CursoDTO pesquisar(){
		CursoDao tDao = DaoFactory.getCursoDao();
		List<Curso> tLista = tDao.search();
		
		if (tLista.isEmpty())
			return new CursoDTO(false, "Vazia");
		
		return new CursoDTO(true, "Recuperado",tLista);
		
	}
	
// Pesquisar por Nome
	public static CursoDTO searchByDisciplina(String pCodigoCurso) {

		if (pCodigoCurso == null)
			return pesquisar();

		CursoDao tDao = DaoFactory.getCursoDao();
		List<Curso> tLista = tDao.searchByDisciplina(pCodigoCurso);

		if (tLista.isEmpty())
			return new CursoDTO(false, "Nenhum nome '" + pCodigoCurso + "'");

		return new CursoDTO(true, "Lista de disciplinas recuperada", tLista);
	}
	
}

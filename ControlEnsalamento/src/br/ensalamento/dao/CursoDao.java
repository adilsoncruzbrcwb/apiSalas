package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Curso;

public interface CursoDao {

	Curso create (Curso pCurso);
	
	Curso recovery (int pCodigo);
	
	Curso update (Curso pCurso);
	
	boolean delete (int pCodigo);
	
	List<Curso> search ();
	
	List<Curso> searchByDisciplina(String pCodigoCurso);
	
}

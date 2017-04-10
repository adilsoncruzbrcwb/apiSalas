package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Professor;

public interface ProfessorDAO {

	// M�todo para criar um professor na base de dados (INSERT)
	Professor create(Professor pProfessor);

	// M�todo para recuperar um professor da base de dados (SELECT)
	Professor recovery(int pMatricula);

	// M�todo para atualizar um professor na base de dados (UPDATE)
	Professor update(Professor pProfessor);

	// M�todo para deletar um professor na base de dados (DELETE)
	boolean delete(int pMatricula);

	// M�todo para pesquisar todos os professores da base de dados
	List<Professor> search();

	// M�todo para pesquisar por nome todos os professores da base de dados
	List<Professor> searchByNome(String pNome);

}

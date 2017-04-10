package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Professor;

public interface ProfessorDAO {

	// Método para criar um professor na base de dados (INSERT)
	Professor create(Professor pProfessor);

	// Método para recuperar um professor da base de dados (SELECT)
	Professor recovery(int pMatricula);

	// Método para atualizar um professor na base de dados (UPDATE)
	Professor update(Professor pProfessor);

	// Método para deletar um professor na base de dados (DELETE)
	boolean delete(int pMatricula);

	// Método para pesquisar todos os professores da base de dados
	List<Professor> search();

	// Método para pesquisar por nome todos os professores da base de dados
	List<Professor> searchByNome(String pNome);

}

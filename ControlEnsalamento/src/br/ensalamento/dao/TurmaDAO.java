package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Turma;

public interface TurmaDAO
{

    // Método para criar uma turma na base de dados (INSERT)
    Turma create(Turma pTurma);

    // Método para recuperar uma turma da base de dados (SELECT)
    Turma recovery(int pCodigo);

    // Método para atualizar uma turma na base de dados (UPDATE)
    Turma update(Turma pTurma);

    // Método para deletar uma turma na base de dados (DELETE)
    boolean delete(int pCodigo);

    // Método para pesquisar todos as turmas da base de dados
    List<Turma> search();

    // Método para pesquisar por nome todos as turmas da base de dados
    List<Turma> searchByProfessor(int pMatriculaProfessor);

}

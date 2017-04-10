package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Turma;

public interface TurmaDAO
{

    // M�todo para criar uma turma na base de dados (INSERT)
    Turma create(Turma pTurma);

    // M�todo para recuperar uma turma da base de dados (SELECT)
    Turma recovery(int pCodigo);

    // M�todo para atualizar uma turma na base de dados (UPDATE)
    Turma update(Turma pTurma);

    // M�todo para deletar uma turma na base de dados (DELETE)
    boolean delete(int pCodigo);

    // M�todo para pesquisar todos as turmas da base de dados
    List<Turma> search();

    // M�todo para pesquisar por nome todos as turmas da base de dados
    List<Turma> searchByProfessor(int pMatriculaProfessor);

}

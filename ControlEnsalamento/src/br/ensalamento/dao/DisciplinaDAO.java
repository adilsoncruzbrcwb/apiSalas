package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Disciplina;

public interface DisciplinaDAO
{

    // Método para criar um disciplina na base de dados (INSERT)
    Disciplina create(Disciplina pDisciplina);

    // Método para recuperar um disciplina da base de dados (SELECT)
    Disciplina recovery(int pCodigo);

    // Método para atualizar um disciplina na base de dados (UPDATE)
    Disciplina update(Disciplina pDisciplina);

    // Método para deletar um disciplina na base de dados (DELETE)
    boolean delete(int pCodigo);

    // Método para pesquisar todos os disciplinas da base de dados
    List<Disciplina> search();

    // Método para pesquisar por nome todos os disciplinas da base de dados
    List<Disciplina> searchByNome(String pNome);

}

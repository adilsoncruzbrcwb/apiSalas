package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Disciplina;

public interface DisciplinaDAO
{

    // M�todo para criar um disciplina na base de dados (INSERT)
    Disciplina create(Disciplina pDisciplina);

    // M�todo para recuperar um disciplina da base de dados (SELECT)
    Disciplina recovery(int pCodigo);

    // M�todo para atualizar um disciplina na base de dados (UPDATE)
    Disciplina update(Disciplina pDisciplina);

    // M�todo para deletar um disciplina na base de dados (DELETE)
    boolean delete(int pCodigo);

    // M�todo para pesquisar todos os disciplinas da base de dados
    List<Disciplina> search();

    // M�todo para pesquisar por nome todos os disciplinas da base de dados
    List<Disciplina> searchByNome(String pNome);

}

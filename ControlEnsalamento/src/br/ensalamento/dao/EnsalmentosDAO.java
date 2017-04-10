package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Ensalamento;

public interface EnsalmentosDAO
{

    // Método para criar um SalasDAO na base de dados (INSERT)
    Ensalamento create(Ensalamento pEnsalamento);

    // Método para recuperar um SalasDAO da base de dados (SELECT)
    Ensalamento recovery(int pCodigo);

    // Método para atualizar um SalasDAO na base de dados (UPDATE)
    Ensalamento update(Ensalamento pEnsalamento);

    // Método para deletar um SalasDAO na base de dados (DELETE)
    boolean delete(int pCodigo);

    // Método para pesquisar todos os SalasDAO da base de dados
    List<Ensalamento> search();

    // Método para pesquisar por nome todos os SalasDAO da base de dados
    List<Ensalamento> searchByNome(String pDiaDaSemana);

}

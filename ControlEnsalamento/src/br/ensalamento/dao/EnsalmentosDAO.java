package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Ensalamento;

public interface EnsalmentosDAO
{

    // M�todo para criar um SalasDAO na base de dados (INSERT)
    Ensalamento create(Ensalamento pEnsalamento);

    // M�todo para recuperar um SalasDAO da base de dados (SELECT)
    Ensalamento recovery(int pCodigo);

    // M�todo para atualizar um SalasDAO na base de dados (UPDATE)
    Ensalamento update(Ensalamento pEnsalamento);

    // M�todo para deletar um SalasDAO na base de dados (DELETE)
    boolean delete(int pCodigo);

    // M�todo para pesquisar todos os SalasDAO da base de dados
    List<Ensalamento> search();

    // M�todo para pesquisar por nome todos os SalasDAO da base de dados
    List<Ensalamento> searchByNome(String pDiaDaSemana);

}

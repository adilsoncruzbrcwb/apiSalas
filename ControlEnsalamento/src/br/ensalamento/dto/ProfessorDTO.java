/*
 * ProfessorDTO.java
 *
 * Classe que representa o retorno do servi�o de manuten��o de cidades.
 *
 * � 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Hist�rico
 * 14/07/2016 � Vers�o 1.0 - Jos� Augusto � Cria��o do arquivo
 *
 */
package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.Professor;

public class ProfessorDTO extends AbstractDTO<Professor>
{
    /* Construtores da classe */
    public ProfessorDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProfessorDTO(boolean pOk, String pMensagem, Professor pProfessor)
    {
        super(pOk, pMensagem, pProfessor);
    }

    public ProfessorDTO(boolean pOk, String pMensagem, List<Professor> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* M�todos de acesso */
    public Professor getProfessor()
    {
        return getObjeto();
    }

    public void setProfessor(Professor pProfessor)
    {
        setObjeto(pProfessor);
    }
}

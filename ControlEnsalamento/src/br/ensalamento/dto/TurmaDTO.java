package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.Turma;

public class TurmaDTO extends AbstractDTO<Turma>
{
    public TurmaDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public TurmaDTO(boolean pOk, String pMensagem, Turma pTurma)
    {
        super(pOk, pMensagem, pTurma);
    }

    public TurmaDTO(boolean pOk, String pMensagem, List<Turma> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    public Turma getTurma()
    {
        return getObjeto();
    }

    public void setTurma(Turma pTurma)
    {
        setObjeto(pTurma);
    }
}

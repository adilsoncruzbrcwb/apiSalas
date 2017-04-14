/*
 * UsuarioDTO.java
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

import br.ensalamento.model.Usuario;

public class UsuarioDTO extends AbstractDTO<Usuario>
{
    /* Construtores da classe */
    public UsuarioDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public UsuarioDTO(boolean pOk, String pMensagem, Usuario pUsuario)
    {
        super(pOk, pMensagem, pUsuario);
    }

    public UsuarioDTO(boolean pOk, String pMensagem, List<Usuario> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* M�todos de acesso */
    public Usuario getUsuario()
    {
        return getObjeto();
    }

    public void setUsuario(Usuario pUsuario)
    {
        setObjeto(pUsuario);
    }
}

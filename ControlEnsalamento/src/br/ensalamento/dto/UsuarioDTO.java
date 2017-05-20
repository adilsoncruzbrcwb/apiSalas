package br.ensalamento.dto;

import java.util.List;

import br.ensalamento.model.Usuario;

public class UsuarioDTO extends AbstractDTO<Usuario>
{
    /* Construtores da classe */
    public UsuarioDTO(boolean pOk, String pMensagem) { super(pOk, pMensagem); }

    public UsuarioDTO(boolean pOk, String pMensagem, Usuario pUsuario) { super(pOk, pMensagem, pUsuario); }

    public UsuarioDTO(boolean pOk, String pMensagem, List<Usuario> pLista) { super(pOk, pMensagem, pLista); }

	/* Metodos de acesso */
    public Usuario getUsuario() { return getObjeto(); }

    public void setUsuario(Usuario pUsuario) { setObjeto(pUsuario); }
}

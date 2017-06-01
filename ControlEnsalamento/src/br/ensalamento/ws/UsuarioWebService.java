package br.ensalamento.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ensalamento.controller.UsuarioController;
import br.ensalamento.dto.UsuarioDTO;
import br.ensalamento.model.Usuario;

@Path ("/Usuario")
public class UsuarioWebService {

	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO cadastrar(Usuario pUsuario) {
		return UsuarioController.cadastrar(pUsuario);
	}

	@GET
	@Path("/Recuperar/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO recuperar(@PathParam("idUsuario") int pIdUsuario) {
		return UsuarioController.recuperar(pIdUsuario);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO atualizar(Usuario pAluno) {
		return UsuarioController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO remover(@PathParam("idUsuario") int pUsuario) {
		return UsuarioController.remover(pUsuario);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO pesquisar() {
		return UsuarioController.pesquisar();
	}
	
	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO pesquisarPorNome(@PathParam("nome") String pNome) {
		return UsuarioController.pesquisarPorNome(pNome);
	}
	
	@GET
	@Path("/PesquisarPorIdFace/{idface}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO pesquisarPorFace(@PathParam("idface") String idface) {
		return UsuarioController.pesquisarPorFace(idface);
	}
	
	@GET
	@Path("/PesquisarPorEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO pesquisarPorEmail(@PathParam("email") String pEmail) {
		return UsuarioController.pesquisarPorEmail(pEmail);
	}
}

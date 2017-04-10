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

import br.ensalamento.controller.ProfessorController;
import br.ensalamento.dto.ProfessorDTO;
import br.ensalamento.model.Professor;

public class ProfessorWebService {

	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProfessorDTO cadastrar(Professor pProfessor) {
		return ProfessorController.cadastrar(pProfessor);
	}

	@GET
	@Path("/Recuperar/{idProfessor}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfessorDTO recuperar(@PathParam("idProfessor") int pIdProfessor) {
		return ProfessorController.recuperar(pIdProfessor);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProfessorDTO atualizar(Professor pAluno) {
		return ProfessorController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{idProfessor}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfessorDTO remover(@PathParam("idProfessor") int pProfessor) {
		return ProfessorController.remover(pProfessor);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfessorDTO pesquisar() {
		return ProfessorController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfessorDTO pesquisarPorNome(@PathParam("nome") String pNome) {
		return ProfessorController.pesquisarPorNome(pNome);
	}
}

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

import br.ensalamento.controller.DisciplinaController;
import br.ensalamento.dto.DisciplinaDTO;
import br.ensalamento.model.Disciplina;

@Path("/Disciplina")
public class DisciplinaWebService {
	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DisciplinaDTO cadastrar(Disciplina pDisciplina) {
		return DisciplinaController.cadastrar(pDisciplina);
	}

	@GET
	@Path("/Recuperar/{idDisciplina}")
	@Produces(MediaType.APPLICATION_JSON)
	public DisciplinaDTO recuperar(@PathParam("idDisciplina") int pIdDisciplina) {
		return DisciplinaController.recuperar(pIdDisciplina);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DisciplinaDTO atualizar(Disciplina pAluno) {
		return DisciplinaController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{idDisciplina}")
	@Produces(MediaType.APPLICATION_JSON)
	public DisciplinaDTO remover(@PathParam("idDisciplina") int pDisciplina) {
		return DisciplinaController.remover(pDisciplina);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public DisciplinaDTO pesquisar() {
		return DisciplinaController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public DisciplinaDTO pesquisarPorNome(@PathParam("nome") String pNome) {
		return DisciplinaController.pesquisarPorNome(pNome);
	}
}

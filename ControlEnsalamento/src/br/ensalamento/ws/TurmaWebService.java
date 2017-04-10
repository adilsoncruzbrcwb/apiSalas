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

import br.ensalamento.controller.TurmaController;
import br.ensalamento.dto.TurmaDTO;
import br.ensalamento.model.Turma;
@Path("/Turma")
public class TurmaWebService {
	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TurmaDTO cadastrar(Turma pTurma) {
		return TurmaController.cadastrar(pTurma);
	}

	@GET
	@Path("/Recuperar/{idTurma}")
	@Produces(MediaType.APPLICATION_JSON)
	public TurmaDTO recuperar(@PathParam("idTurma") int pIdTurma) {
		return TurmaController.recuperar(pIdTurma);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TurmaDTO atualizar(Turma pAluno) {
		return TurmaController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{idTurma}")
	@Produces(MediaType.APPLICATION_JSON)
	public TurmaDTO remover(@PathParam("idTurma") int pTurma) {
		return TurmaController.remover(pTurma);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public TurmaDTO pesquisar() {
		return TurmaController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public TurmaDTO pesquisarPorNome(@PathParam("nome") int pMatriculaProfessor) {
		return TurmaController.searchByProfessor(pMatriculaProfessor);
	}
}

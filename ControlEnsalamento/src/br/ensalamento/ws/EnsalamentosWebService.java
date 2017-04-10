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

import br.ensalamento.controller.EnsalamentosController;
import br.ensalamento.dto.EnsalamentosDTO;
import br.ensalamento.model.Ensalamento;

@Path("/Ensalamento")
public class EnsalamentosWebService {
	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EnsalamentosDTO cadastrar(Ensalamento pAluno) {
		return EnsalamentosController.cadastrar(pAluno);
	}

	@GET
	@Path("/Recuperar/{matricula}")
	@Produces(MediaType.APPLICATION_JSON)
	public EnsalamentosDTO recuperar(@PathParam("matricula") int pMatricula) {
		return EnsalamentosController.recuperar(pMatricula);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EnsalamentosDTO atualizar(Ensalamento pAluno) {
		return EnsalamentosController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{matricula}")
	@Produces(MediaType.APPLICATION_JSON)
	public EnsalamentosDTO remover(@PathParam("matricula") int pMatricula) {
		return EnsalamentosController.remover(pMatricula);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public EnsalamentosDTO pesquisar() {
		return EnsalamentosController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public EnsalamentosDTO pesquisarPorNome(@PathParam("nome") String pDiaDaSemana) {
		return EnsalamentosController.pesquisarPorSemana(pDiaDaSemana);
	}
}

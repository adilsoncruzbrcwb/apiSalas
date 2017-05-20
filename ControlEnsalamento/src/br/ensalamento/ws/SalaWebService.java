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

import br.ensalamento.controller.SalasController;
import br.ensalamento.dto.SalasDTO;
import br.ensalamento.model.Sala;

@Path ("/Sala")
public class SalaWebService {

	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SalasDTO cadastrar(Sala pSalas) { return SalasController.cadastrar(pSalas); }

	@GET
	@Path("/Recuperar/{idSalas}")
	@Produces(MediaType.APPLICATION_JSON)
	public SalasDTO recuperar(@PathParam("idSalas") int pIdSalas) { return SalasController.recuperar(pIdSalas); }

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SalasDTO atualizar(Sala pAluno) { return SalasController.atualizar(pAluno); }

	@DELETE
	@Path("/Remover/{idSalas}")
	@Produces(MediaType.APPLICATION_JSON)
	public SalasDTO remover(@PathParam("idSalas") int pSalas) { return SalasController.remover(pSalas); }

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public SalasDTO pesquisar() { return SalasController.pesquisar(); }

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public SalasDTO pesquisarPorNome(@PathParam("nome") int pCodigoSala) { return SalasController.searchBySalas(pCodigoSala); }
}

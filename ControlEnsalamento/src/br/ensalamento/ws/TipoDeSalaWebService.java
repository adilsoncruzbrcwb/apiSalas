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

import br.ensalamento.controller.TipoDeSalaController;
import br.ensalamento.dto.TipoDeSalaDTO;
import br.ensalamento.model.TipoDeSala;

@Path ("/TipoSala")
public class TipoDeSalaWebService {

	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDeSalaDTO cadastrar(TipoDeSala pTipoDeSala) { return TipoDeSalaController.cadastrar(pTipoDeSala); }

	@GET
	@Path("/Recuperar/{idTipoDeSala}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDeSalaDTO recuperar(@PathParam("idTipoDeSala") int pIdTipoDeSala) { return TipoDeSalaController.recuperar(pIdTipoDeSala); }

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDeSalaDTO atualizar(TipoDeSala pAluno) { return TipoDeSalaController.atualizar(pAluno); }

	@DELETE
	@Path("/Remover/{idTipoDeSala}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDeSalaDTO remover(@PathParam("idTipoDeSala") int pTipoDeSala) { return TipoDeSalaController.remover(pTipoDeSala); }

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDeSalaDTO pesquisar() { return TipoDeSalaController.pesquisar(); }

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDeSalaDTO pesquisarPorNome(@PathParam("nome") int pCodigo) { return TipoDeSalaController.searchByTipoDeSala(pCodigo); }
}

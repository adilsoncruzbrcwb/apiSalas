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

import br.ensalamento.controller.CursoController;
import br.ensalamento.dto.CursoDTO;
import br.ensalamento.model.Curso;

@Path ("/Curso")
public class CursoWebService {
	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CursoDTO cadastrar(Curso pCurso) { return CursoController.cadastrar(pCurso);	}

	@GET
	@Path("/Recuperar/{idCurso}")
	@Produces(MediaType.APPLICATION_JSON)
	public CursoDTO recuperar(@PathParam("idCurso") int pIdCurso) {
		return CursoController.recuperar(pIdCurso);
	}

	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CursoDTO atualizar(Curso pAluno) {
		return CursoController.atualizar(pAluno);
	}

	@DELETE
	@Path("/Remover/{idCurso}")
	@Produces(MediaType.APPLICATION_JSON)
	public CursoDTO remover(@PathParam("idCurso") int pCurso) {
		return CursoController.remover(pCurso);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public CursoDTO pesquisar() {
		return CursoController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public CursoDTO pesquisarPorNome(@PathParam("nome") String pCodigoCurso) {
		return CursoController.searchByDisciplina(pCodigoCurso);
	}

}

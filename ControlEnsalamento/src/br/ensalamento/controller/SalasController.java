package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.SalasDAO;
import br.ensalamento.dto.SalasDTO;
import br.ensalamento.model.Sala;

public class SalasController {

	public static SalasDTO cadastrar(Sala pSalas) {
		if (pSalas == null)
			return new SalasDTO(false, "Nula");

		SalasDAO tDao = DaoFactory.getSalaDAO();
		Sala tSala = tDao.create(pSalas);

		if (tSala == null)
			return new SalasDTO(false, "problema gravacao", tSala);
		return new SalasDTO(true, "Cadastrado", tSala);
	}

	public static SalasDTO recuperar(int pCodigo) {
		SalasDAO tDao = DaoFactory.getSalaDAO();
		Sala tCurso = tDao.recovery(pCodigo);

		if (tCurso == null)
			return new SalasDTO(false, "Não Existe");

		return new SalasDTO(true, "Sucesso", tCurso);
	}
	public static SalasDTO atualizar (Sala pSala){
		if (pSala == null)
			return new SalasDTO(false, "Nula");
		
		SalasDAO tDao = DaoFactory.getSalaDAO();
		Sala tCurso = tDao.update(pSala);
		
		if (tCurso == null)
			return new SalasDTO(false, "não existe");
		return new SalasDTO(true, "Atualizado", tCurso);
	}
	public static SalasDTO remover (int pCodigo){
		SalasDAO tDao = DaoFactory.getSalaDAO();
		if (!tDao.delete(pCodigo))
			return new SalasDTO(false, "não existe");
		return new SalasDTO(true, "removido");
		
	}
	public static SalasDTO pesquisar(){
		SalasDAO tDao = DaoFactory.getSalaDAO();
		List<Sala> tLista = tDao.search();
		
		if (tLista.isEmpty())
			return new SalasDTO(false, "Vazia");
		
		return new SalasDTO(true, "Recuperado",tLista);
		
	}
	
	public static SalasDTO searchBySalas(int pCodigoSala) {
		if (pCodigoSala == 0)
			return pesquisar();

		SalasDAO tDao = DaoFactory.getSalaDAO();
		List<Sala> tLista = tDao.searchBySalas(pCodigoSala);

		if (tLista.isEmpty())
			return new SalasDTO(false, "Nenhum nome '" + pCodigoSala + "'");

		return new SalasDTO(true, "Lista recuperada", tLista);
	}

}

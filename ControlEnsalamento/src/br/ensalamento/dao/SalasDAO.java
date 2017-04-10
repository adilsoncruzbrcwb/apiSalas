package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Sala;

public interface SalasDAO {
	
	Sala create (Sala pSalas);
	
	Sala recovery (int pCodigo);
	
	Sala update (Sala pSalas);
	
	boolean delete (int pCodigo);
	
	List<Sala> search ();
	
	List<Sala> searchBySalas (int pCodigoSala);
	

}

package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.TipoDeSala;

public interface TipoDeSalaDAO {
	
	TipoDeSala create (TipoDeSala pTipo);
	
	TipoDeSala recovery (int pCodigo);
	
	TipoDeSala update (TipoDeSala pTipo);
	
	boolean delete (int pCodigo);
	
	List<TipoDeSala> search();
	
	List<TipoDeSala> searchByTipo (int pCodigo);
	

}

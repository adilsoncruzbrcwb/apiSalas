package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Usuario;

public interface UsuarioDAO {

	// M�todo para criar um Usuario na base de dados (INSERT)
	Usuario create(Usuario pUsuario);

	// M�todo para recuperar um Usuario da base de dados (SELECT)
	Usuario recovery(int pMatricula);

	// M�todo para atualizar um Usuario na base de dados (UPDATE)
	Usuario update(Usuario pUsuario);

	// M�todo para deletar um Usuario na base de dados (DELETE)
	boolean delete(int pMatricula);

	// M�todo para pesquisar todos os Usuarioes da base de dados
	List<Usuario> search();

	// M�todo para pesquisar por nome todos os Usuarioes da base de dados
	List<Usuario> searchByNome(String pNome);

}

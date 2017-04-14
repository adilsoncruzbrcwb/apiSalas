package br.ensalamento.dao;

import java.util.List;

import br.ensalamento.model.Usuario;

public interface UsuarioDAO {

	// Método para criar um Usuario na base de dados (INSERT)
	Usuario create(Usuario pUsuario);

	// Método para recuperar um Usuario da base de dados (SELECT)
	Usuario recovery(int pMatricula);

	// Método para atualizar um Usuario na base de dados (UPDATE)
	Usuario update(Usuario pUsuario);

	// Método para deletar um Usuario na base de dados (DELETE)
	boolean delete(int pMatricula);

	// Método para pesquisar todos os Usuarioes da base de dados
	List<Usuario> search();

	// Método para pesquisar por nome todos os Usuarioes da base de dados
	List<Usuario> searchByNome(String pNome);

}

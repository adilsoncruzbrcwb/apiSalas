/*
 * UsuarioController.java
 *
 * Classe que implementa os serviços de manutenção de Usuarios
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
 *
 */
package br.ensalamento.controller;

import java.util.List;

import br.ensalamento.dao.DaoFactory;
import br.ensalamento.dao.UsuarioDAO;
import br.ensalamento.dto.UsuarioDTO;
import br.ensalamento.model.Usuario;

public class UsuarioController {
	public static UsuarioDTO cadastrar(Usuario pUsuario) {
		if (pUsuario == null)
			return new UsuarioDTO(false, "Tentativa de inserir um Usuario nulo");

		UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
		Usuario tUsuario = tDao.create(pUsuario);

		if (tUsuario == null)
			return new UsuarioDTO(false, "Problemas na gravação do Usuario");

		return new UsuarioDTO(true, "Usuario gravado com sucesso", tUsuario);
	}

	public static UsuarioDTO recuperar(int pMatricula) {
		UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
		Usuario tUsuario = tDao.recovery(pMatricula);

		if (tUsuario == null)
			return new UsuarioDTO(false, "Usuario não existe no cadastro");

		return new UsuarioDTO(true, "Usuario lido com sucesso", tUsuario);
	}

	public static UsuarioDTO atualizar(Usuario pUsuario) {
		if (pUsuario == null)
			return new UsuarioDTO(false, "Tentativa de atualizar um Usuario nulo");

		UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
		Usuario tUsuario = tDao.update(pUsuario);

		if (tUsuario == null)
			return new UsuarioDTO(false, "Usuario não existe no cadastro");

		return new UsuarioDTO(true, "Usuario regravado com sucesso", tUsuario);
	}

	public static UsuarioDTO remover(int pMatricula) {
		UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
		if (!tDao.delete(pMatricula))
			return new UsuarioDTO(false, "Usuario não existe no cadastro");

		return new UsuarioDTO(true, "Usuario removido com sucesso");
	}

	public static UsuarioDTO pesquisar() {
		UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
		List<Usuario> tLista = tDao.search();

		if (tLista.isEmpty())
			return new UsuarioDTO(false, "Lista de Usuarios vazia");

		return new UsuarioDTO(true, "Lista de Usuarios recuperada", tLista);
	}

	public static UsuarioDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();

		UsuarioDAO tDao = DaoFactory.getUsuarioDAO();
		List<Usuario> tLista = tDao.searchByNome(pNome);

		if (tLista.isEmpty())
			return new UsuarioDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		return new UsuarioDTO(true, "Lista de Usuarios recuperada", tLista);
	}
}

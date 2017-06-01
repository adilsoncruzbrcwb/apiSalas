package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.UsuarioDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Usuario;
import br.ensalamento.util.ExceptionUtil;

public class UsuarioHibernateDAO implements UsuarioDAO {

	@Override
	public Usuario create(Usuario pUsuario) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pUsuario);
			tSessao.flush();

			return pUsuario;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Usuario");
		}
		return null;
	}

	@Override
	public Usuario recovery(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Usuario tUsuario = (Usuario) tSessao.get(Usuario.class, pMatricula);

			return tUsuario;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Usuario");
		}
		return null;
	}

	@Override
	public Usuario update(Usuario pUsuario) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pUsuario);
			tSessao.flush();

			return pUsuario;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
		}
		return null;
	}

	@Override
	public boolean delete(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(Usuario.class, pMatricula));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> search() {
		List<Usuario> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("FROM usuario");

			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome + "%";

		List<Usuario> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Usuario.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> searchByFace(String idFacebook) {
		String tNomePesquisa = "%" + idFacebook + "%";

		List<Usuario> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Usuario.class)
					.add(Restrictions.like("idFacebook", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
		}
		return tLista;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> searchByEmail(String Email) {
		String tNomePesquisa = "%" + Email + "%";

		List<Usuario> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Usuario.class)
					.add(Restrictions.like("Email", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
		}
		return tLista;
	}
}

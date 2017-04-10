package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.TipoDeSalaDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.TipoDeSala;
import br.ensalamento.util.ExceptionUtil;

public class TipoDeSalaHibernateDAO implements TipoDeSalaDAO {

	@Override
	public TipoDeSala create(TipoDeSala pTipo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pTipo);
			tSessao.flush();

			return pTipo;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Curso");
		}

		return null;
	}

	@Override
	public TipoDeSala recovery(int pCodigo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			TipoDeSala tTipoSala = (TipoDeSala) tSessao.get(TipoDeSala.class, pCodigo);

			return tTipoSala;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação  do Tipo de Sala");
		}
		return null;
	}

	@Override
	public TipoDeSala update(TipoDeSala pTipo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pTipo);
			tSessao.flush();

			return pTipo;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Tipo de Sala");
		}
		return null;
	}

	@Override
	public boolean delete(int pCodigo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(TipoDeSala.class, pCodigo));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar  Tipo de Sala");
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDeSala> search() {
		List<TipoDeSala> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("FROM TB_TIPOSALA");

			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da  Tipo de Sala");
		}
		return tLista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDeSala> searchByTipo(int pCodigo) {
		String tNomePesquisa = "%" + pCodigo + "%";

		List<TipoDeSala> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(TipoDeSala.class)
					.add(Restrictions.like("Tipo", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista  Tipo de Sala");
		}

		return tLista;
	}

}

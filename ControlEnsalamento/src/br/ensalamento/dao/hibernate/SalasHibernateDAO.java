package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.SalasDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Sala;
import br.ensalamento.util.ExceptionUtil;

public class SalasHibernateDAO implements SalasDAO {

	@Override
	public Sala create(Sala pSalas) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pSalas);
			tSessao.flush();

			return pSalas;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Curso");
		}

		return null;
	}

	@Override
	public Sala recovery(int pCodigo) {
		{
			try {
				SessionFactory tFactory = HibernateUtil.getSessionFactory();
				Session tSessao = tFactory.getCurrentSession();

				Sala tSalas = (Sala) tSessao.get(Sala.class, pCodigo);

				return tSalas;
			} catch (HibernateException tExcept) {
				ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação Sala");
			}
			return null;
		}
	}

	@Override
	public Sala update(Sala pSalas) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pSalas);
			tSessao.flush();

			return pSalas;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização Sala");
		}
		return null;
	}

	@Override
	public boolean delete(int pCodigo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(Sala.class, pCodigo));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar Sala");
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sala> search() {
		List<Sala> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("FROM TB_SALAS");

			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de salas");
		}
		return tLista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sala> searchBySalas(int pCodigoSala) {
		String tNomePesquisa = "%" + pCodigoSala + "%";

		List<Sala> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Sala.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de disciplinas");
		}
		return tLista;
	}

}

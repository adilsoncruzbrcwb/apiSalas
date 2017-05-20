package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.EnsalmentosDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Ensalamento;
import br.ensalamento.util.ExceptionUtil;

public class EnsalamentosHibernateDAO implements EnsalmentosDAO {

	@Override
	public Ensalamento create(Ensalamento pAluno) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pAluno);
			tSessao.flush();

			return pAluno;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do aluno");
		}

		return null;
	}


	@Override
	public Ensalamento recovery(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Ensalamento tAluno = (Ensalamento) tSessao.get(Ensalamento.class, pMatricula);

			return tAluno;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do aluno");
		}
		return null;
	}



	@Override
	public Ensalamento update(Ensalamento pAluno) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pAluno);
			tSessao.flush();

			return pAluno;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do aluno");
		}
		return null;
	}


	@Override
	public boolean delete(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(Ensalamento.class, pMatricula));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do aluno");
		}

		return false;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Ensalamento> search() {
		List<Ensalamento> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("FROM ALUNO");
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de alunos");
		}
		return tLista;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ensalamento> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome + "%";

		List<Ensalamento> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Ensalamento.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de alunos");
		}
		return tLista;
	}

}

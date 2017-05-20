package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.DisciplinaDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Disciplina;
import br.ensalamento.util.ExceptionUtil;

public class DisciplinaHibernateDAO implements DisciplinaDAO {
	@Override
	public Disciplina create(Disciplina pDisciplina) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pDisciplina);
			tSessao.flush();

			return pDisciplina;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do aluno");
		}
		return null;
	}

	@Override
	public Disciplina recovery(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Disciplina tDisciplina = (Disciplina) tSessao.get(Disciplina.class, pMatricula);

			return tDisciplina;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do aluno");
		}
		return null;
	}

	@Override
	public Disciplina update(Disciplina pDisciplina) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pDisciplina);
			tSessao.flush();

			return pDisciplina;
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

			tSessao.delete(tSessao.get(Disciplina.class, pMatricula));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do aluno");
		}

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Disciplina> search() {
		List<Disciplina> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("from Disciplina");

			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de alunos");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Disciplina> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome + "%";

		List<Disciplina> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Disciplina.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de alunos");
		}
		return tLista;
	}
}
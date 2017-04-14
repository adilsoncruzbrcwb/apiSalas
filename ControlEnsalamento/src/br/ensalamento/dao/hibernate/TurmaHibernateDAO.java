package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.TurmaDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Turma;
import br.ensalamento.util.ExceptionUtil;

public class TurmaHibernateDAO implements TurmaDAO {

	@Override
	public Turma create(Turma pTurma) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pTurma);
			tSessao.flush();

			return pTurma;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação TURMA");
		}

		return null;
	}


	@Override
	public Turma recovery(int pCodigo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Turma tTurma = (Turma) tSessao.get(Turma.class, pCodigo);

			return tTurma;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação TURMA");
		}
		return null;
	}

	@Override
	public Turma update(Turma pTurma) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pTurma);
			tSessao.flush();

			return pTurma;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização TURMA");
		}
		return null;
	}

	@Override
	public boolean delete(int pCodigo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(Turma.class, pCodigo));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar TURMA");
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> search() {
		List<Turma> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("FROM TB_TURMA");

			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista Turma");
		}
		return tLista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> searchByProfessor(int pMatriculaProfessor) {
		{
	        String tNomePesquisa = "%" + pMatriculaProfessor + "%";

	        List<Turma> tLista = new ArrayList<>();

	        try
	        {
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            Criteria tCriterio = tSessao.createCriteria(Turma.class)
	                                          .add(Restrictions.like("Usuario", tNomePesquisa).ignoreCase());

	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de professors");
	        }

	        return tLista;
	    }
	}
}

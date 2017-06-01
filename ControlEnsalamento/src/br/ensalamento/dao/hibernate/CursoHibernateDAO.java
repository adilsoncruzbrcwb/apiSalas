package br.ensalamento.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.dao.CursoDao;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Curso;
import br.ensalamento.util.ExceptionUtil;

public class CursoHibernateDAO implements CursoDao {

	@Override
	public Curso create(Curso pCurso) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pCurso);
			tSessao.flush();

			return pCurso;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Curso");
		}

		return null;
	}

	@Override
	public Curso recovery(int pCodigo) {
			try {
				SessionFactory tFactory = HibernateUtil.getSessionFactory();
				Session tSessao = tFactory.getCurrentSession();

				Curso tCurso = (Curso) tSessao.get(Curso.class, pCodigo);

				return tCurso;
			} catch (HibernateException tExcept) {
				ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação no curso");
			}
			return null;
		}


	@Override
	public Curso update(Curso pCurso) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pCurso);
			tSessao.flush();

			return pCurso;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Curso");
		}
		return null;
	}

	@Override
	public boolean delete(int pCodigo) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(Curso.class, pCodigo));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de deletar curso");
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> search() {
		List<Curso> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query tQuery = tSessao.createQuery("from curso");

			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de curso");
		}
		return tLista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> searchByDisciplina(String pCodigoCurso) {
		String tNomePesquisa = "%" + pCodigoCurso + "%";

		List<Curso> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Curso.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de disciplinas");
		}

		return tLista;
	}


}

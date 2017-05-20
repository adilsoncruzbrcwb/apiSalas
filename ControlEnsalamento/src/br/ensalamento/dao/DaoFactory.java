package br.ensalamento.dao;

import br.ensalamento.dao.hibernate.CursoHibernateDAO;
import br.ensalamento.dao.hibernate.DisciplinaHibernateDAO;
import br.ensalamento.dao.hibernate.EnsalamentosHibernateDAO;
import br.ensalamento.dao.hibernate.UsuarioHibernateDAO;
import br.ensalamento.dao.hibernate.SalasHibernateDAO;
import br.ensalamento.dao.hibernate.TipoDeSalaHibernateDAO;
import br.ensalamento.dao.hibernate.TurmaHibernateDAO;

public class DaoFactory {
	public static EnsalmentosDAO getEnsalamentoDAO() { return new EnsalamentosHibernateDAO(); }

	public static DisciplinaDAO getDisciplinaDAO() { return new DisciplinaHibernateDAO(); }

	public static UsuarioDAO getUsuarioDAO() { return new UsuarioHibernateDAO(); }

	public static CursoDao getCursoDao() { return new CursoHibernateDAO(); }

	public static SalasDAO getSalaDAO() { return new SalasHibernateDAO(); }

	public static TipoDeSalaDAO geTipoDeSalaDAO() { return new TipoDeSalaHibernateDAO(); }

	public static TurmaDAO geTurmaDAO() { return new TurmaHibernateDAO(); }

}

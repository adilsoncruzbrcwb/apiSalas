/*
 * EnsalmentosDAO.java
 *
 * Classe que implementa a manuten��o e recupera��o dos alunos no banco de dados via JDBC
 *
 * � 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Hist�rico
 * 14/07/2016 � Vers�o 1.0 - Jos� Augusto � Cria��o do arquivo
 *
 */
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
	// M�todo para criar um aluno na base de dados (INSERT)
	/*
	 * (non-Javadoc)
	 *
	 * @see br.ensalamento.dao.jdbc.AlunoDAO#create(br.ensalamento.model.
	 * Ensalamento)
	 */
	@Override
	public Ensalamento create(Ensalamento pAluno) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// salvando o objeto via hibernate
			tSessao.save(pAluno);
			tSessao.flush();

			// retornando o objeto atualizado
			return pAluno;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do aluno");
		}

		return null;
	}

	// M�todo para recuperar um aluno da base de dados (SELECT)
	/*
	 * (non-Javadoc)
	 *
	 * @see br.ensalamento.dao.jdbc.AlunoDAO#recovery(int)
	 */
	@Override
	public Ensalamento recovery(int pMatricula) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
			Ensalamento tAluno = (Ensalamento) tSessao.get(Ensalamento.class, pMatricula);

			// Retornando o objeto lido
			return tAluno;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do aluno");
		}
		return null;
	}

	// M�todo para atualizar um aluno na base de dados (UPDATE)
	/*
	 * (non-Javadoc)
	 *
	 * @see br.ensalamento.dao.jdbc.AlunoDAO#update(br.ensalamento.model.
	 * Ensalamento)
	 */
	@Override
	public Ensalamento update(Ensalamento pAluno) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Ataulizando o objeto via hibernate
			tSessao.merge(pAluno);
			tSessao.flush();

			// Retornando o objeto atualizado
			return pAluno;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do aluno");
		}
		return null;
	}

	// M�todo para deletar um aluno na base de dados (DELETE)
	/*
	 * (non-Javadoc)
	 *
	 * @see br.ensalamento.dao.jdbc.AlunoDAO#delete(int)
	 */
	@Override
	public boolean delete(int pMatricula) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			tSessao.delete(tSessao.get(Ensalamento.class, pMatricula));
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do aluno");
		}

		return false;
	}

	// M�todo para pesquisar todos os alunos da base de dados
	/*
	 * (non-Javadoc)
	 *
	 * @see br.ensalamento.dao.jdbc.AlunoDAO#search()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Ensalamento> search() {
		// Criando a tLista de alunos vazia
		List<Ensalamento> tLista = new ArrayList<>();

		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o objeto para pesquisa
			Query tQuery = tSessao.createQuery("FROM ALUNO");

			// Recuperando a lista via hibernate
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de alunos");
		}

		// Retornando a lista de alunos
		return tLista;
	}

	// M�todo para pesquisar por nome todos os alunos da base de dados
	/*
	 * (non-Javadoc)
	 *
	 * @see br.ensalamento.dao.jdbc.AlunoDAO#searchByNome(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Ensalamento> searchByNome(String pNome) {
		// Acertando o crit�rio de pesquisa
		String tNomePesquisa = "%" + pNome + "%";

		// Criando a tLista de alunos vazia
		List<Ensalamento> tLista = new ArrayList<>();

		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o crit�rio para pesquisa
			Criteria tCriterio = tSessao.createCriteria(Ensalamento.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			// Recuperando a lista via hibernate
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de alunos");
		}

		// Retornando a lista de alunos
		return tLista;
	}

}

/*
 * ProfessorDAO.java
 *
 * Classe que implementa a manuten��o e recupera��o dos professors no banco de dados via JDBC
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

import br.ensalamento.dao.ProfessorDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Professor;
import br.ensalamento.util.ExceptionUtil;

public class ProfessorHibernateDAO implements ProfessorDAO
{
    // M�todo para criar um professor na base de dados (INSERT)
    /*
     * (non-Javadoc)
     *
     * @see
     * br.ensalamento.dao.jdbc.ProfessorDAO#create(br.ensalamento.model.Professor)
     */
    @Override
    public Professor create(Professor pProfessor)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pProfessor);
            tSessao.flush();

            // retornando o objeto atualizado
            return pProfessor;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do professor");
        }

        return null;
    }

    // M�todo para recuperar um professor da base de dados (SELECT)
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.ProfessorDAO#recovery(int)
     */
    @Override
    public Professor recovery(int pMatricula)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Professor tProfessor = (Professor) tSessao.get(Professor.class, pMatricula);

            // Retornando o objeto lido
            return tProfessor;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do professor");
        }
        return null;
    }

    // M�todo para atualizar um professor na base de dados (UPDATE)
    /*
     * (non-Javadoc)
     *
     * @see
     * br.ensalamento.dao.jdbc.ProfessorDAO#update(br.ensalamento.model.Professor)
     */
    @Override
    public Professor update(Professor pProfessor)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pProfessor);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pProfessor;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do professor");
        }
        return null;
    }

    // M�todo para deletar um professor na base de dados (DELETE)
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.ProfessorDAO#delete(int)
     */
    @Override
    public boolean delete(int pMatricula)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Removendo o objeto via hibernate
            tSessao.delete(tSessao.get(Professor.class, pMatricula));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do professor");
        }

        return false;
    }

    // M�todo para pesquisar todos os professors da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.ProfessorDAO#search()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Professor> search()
    {
        // Criando a tLista de professors vazia
        List<Professor> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM PROFESSOR");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de professors");
        }

        // Retornando a lista de professors
        return tLista;
    }

    // M�todo para pesquisar por nome todos os professors da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.ProfessorDAO#searchByNome(java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Professor> searchByNome(String pNome)
    {
        // Acertando o crit�rio de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de professors vazia
        List<Professor> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Professor.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de professors");
        }

        // Retornando a lista de professors
        return tLista;
    }

}

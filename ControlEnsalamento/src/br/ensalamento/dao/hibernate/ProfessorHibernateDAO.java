/*
 * ProfessorDAO.java
 *
 * Classe que implementa a manutenção e recuperação dos professors no banco de dados via JDBC
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
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
    // Método para criar um professor na base de dados (INSERT)
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
            // Obtendo a sessão hibernate
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do professor");
        }

        return null;
    }

    // Método para recuperar um professor da base de dados (SELECT)
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
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Professor tProfessor = (Professor) tSessao.get(Professor.class, pMatricula);

            // Retornando o objeto lido
            return tProfessor;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do professor");
        }
        return null;
    }

    // Método para atualizar um professor na base de dados (UPDATE)
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
            // Obtendo a sessão hibernate
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do professor");
        }
        return null;
    }

    // Método para deletar um professor na base de dados (DELETE)
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
            // Obtendo a sessão hibernate
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do professor");
        }

        return false;
    }

    // Método para pesquisar todos os professors da base de dados
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
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM PROFESSOR");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de professors");
        }

        // Retornando a lista de professors
        return tLista;
    }

    // Método para pesquisar por nome todos os professors da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.ProfessorDAO#searchByNome(java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Professor> searchByNome(String pNome)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de professors vazia
        List<Professor> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Professor.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de professors");
        }

        // Retornando a lista de professors
        return tLista;
    }

}

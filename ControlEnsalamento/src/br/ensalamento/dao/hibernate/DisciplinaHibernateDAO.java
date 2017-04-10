package br.ensalamento.dao.hibernate;
/*
 * DisciplinaDAO.java
 *
 * Classe que implementa a manuten��o e recupera��o dos alunos no banco de dados via JDBC
 *
 * � 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Hist�rico
 * 14/07/2016 � Vers�o 1.0 - Jos� Augusto � Cria��o do arquivo
 *
 */

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

public class DisciplinaHibernateDAO implements DisciplinaDAO
{
    @Override
    public Disciplina create(Disciplina pDisciplina)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pDisciplina);
            tSessao.flush();

            // retornando o objeto atualizado
            return pDisciplina;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do aluno");
        }

        return null;
    }

    // M�todo para recuperar um aluno da base de dados (SELECT)
    /*
     * (non-Javadoc)
     *
     * @see br.edu.opet.dao.jdbc.DisciplinaDAO#recovery(int)
     */
    @Override
    public Disciplina recovery(int pMatricula)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Disciplina tDisciplina = (Disciplina) tSessao.get(Disciplina.class, pMatricula);

            // Retornando o objeto lido
            return tDisciplina;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do aluno");
        }
        return null;
    }

    // M�todo para atualizar um aluno na base de dados (UPDATE)
    /*
     * (non-Javadoc)
     *
     * @see
     * br.edu.opet.dao.jdbc.DisciplinaDAO#update(br.edu.opet.model.Disciplina)
     */
    @Override
    public Disciplina update(Disciplina pDisciplina)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pDisciplina);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pDisciplina;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do aluno");
        }
        return null;
    }

    // M�todo para deletar um aluno na base de dados (DELETE)
    /*
     * (non-Javadoc)
     *
     * @see br.edu.opet.dao.jdbc.DisciplinaDAO#delete(int)
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
            tSessao.delete(tSessao.get(Disciplina.class, pMatricula));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do aluno");
        }

        return false;
    }

    // M�todo para pesquisar todos os alunos da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.edu.opet.dao.jdbc.DisciplinaDAO#search()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Disciplina> search()
    {
        // Criando a tLista de alunos vazia
        List<Disciplina> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("from Disciplina");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de alunos");
        }

        // Retornando a lista de alunos
        return tLista;
    }

    // M�todo para pesquisar por nome todos os alunos da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.edu.opet.dao.jdbc.DisciplinaDAO#searchByNome(java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Disciplina> searchByNome(String pNome)
    {
        // Acertando o crit�rio de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de alunos vazia
        List<Disciplina> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Disciplina.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de alunos");
        }

        // Retornando a lista de alunos
        return tLista;
    }
}
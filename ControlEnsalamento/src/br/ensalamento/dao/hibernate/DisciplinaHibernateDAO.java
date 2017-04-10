package br.ensalamento.dao.hibernate;
/*
 * DisciplinaDAO.java
 *
 * Classe que implementa a manutenção e recuperação dos alunos no banco de dados via JDBC
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
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
            // Obtendo a sessão hibernate
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do aluno");
        }

        return null;
    }

    // Método para recuperar um aluno da base de dados (SELECT)
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
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Disciplina tDisciplina = (Disciplina) tSessao.get(Disciplina.class, pMatricula);

            // Retornando o objeto lido
            return tDisciplina;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do aluno");
        }
        return null;
    }

    // Método para atualizar um aluno na base de dados (UPDATE)
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
            // Obtendo a sessão hibernate
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do aluno");
        }
        return null;
    }

    // Método para deletar um aluno na base de dados (DELETE)
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
            // Obtendo a sessão hibernate
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
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do aluno");
        }

        return false;
    }

    // Método para pesquisar todos os alunos da base de dados
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
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("from Disciplina");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de alunos");
        }

        // Retornando a lista de alunos
        return tLista;
    }

    // Método para pesquisar por nome todos os alunos da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.edu.opet.dao.jdbc.DisciplinaDAO#searchByNome(java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Disciplina> searchByNome(String pNome)
    {
        // Acertando o critério de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de alunos vazia
        List<Disciplina> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o critério para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Disciplina.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de alunos");
        }

        // Retornando a lista de alunos
        return tLista;
    }
}
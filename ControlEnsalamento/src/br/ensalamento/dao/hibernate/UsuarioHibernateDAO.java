/*
 * UsuarioDAO.java
 *
 * Classe que implementa a manuten��o e recupera��o dos Usuarios no banco de dados via JDBC
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

import br.ensalamento.dao.UsuarioDAO;
import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Usuario;
import br.ensalamento.util.ExceptionUtil;

public class UsuarioHibernateDAO implements UsuarioDAO
{
    // M�todo para criar um Usuario na base de dados (INSERT)
    /*
     * (non-Javadoc)
     *
     * @see
     * br.ensalamento.dao.jdbc.UsuarioDAO#create(br.ensalamento.model.Usuario)
     */
    @Override
    public Usuario create(Usuario pUsuario)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pUsuario);
            tSessao.flush();

            // retornando o objeto atualizado
            return pUsuario;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do Usuario");
        }

        return null;
    }

    // M�todo para recuperar um Usuario da base de dados (SELECT)
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.UsuarioDAO#recovery(int)
     */
    @Override
    public Usuario recovery(int pMatricula)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Usuario tUsuario = (Usuario) tSessao.get(Usuario.class, pMatricula);

            // Retornando o objeto lido
            return tUsuario;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do Usuario");
        }
        return null;
    }

    // M�todo para atualizar um Usuario na base de dados (UPDATE)
    /*
     * (non-Javadoc)
     *
     * @see
     * br.ensalamento.dao.jdbc.UsuarioDAO#update(br.ensalamento.model.Usuario)
     */
    @Override
    public Usuario update(Usuario pUsuario)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pUsuario);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pUsuario;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Usuario");
        }
        return null;
    }

    // M�todo para deletar um Usuario na base de dados (DELETE)
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.UsuarioDAO#delete(int)
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
            tSessao.delete(tSessao.get(Usuario.class, pMatricula));
            tSessao.flush();

            // Retornando indicativo de sucesso
            return true;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Usuario");
        }

        return false;
    }

    // M�todo para pesquisar todos os Usuarios da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.UsuarioDAO#search()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> search()
    {
        // Criando a tLista de Usuarios vazia
        List<Usuario> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM Usuario");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Usuarios");
        }

        // Retornando a lista de Usuarios
        return tLista;
    }

    // M�todo para pesquisar por nome todos os Usuarios da base de dados
    /*
     * (non-Javadoc)
     *
     * @see br.ensalamento.dao.jdbc.UsuarioDAO#searchByNome(java.lang.String)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> searchByNome(String pNome)
    {
        // Acertando o crit�rio de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Usuarios vazia
        List<Usuario> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Usuario.class)
                                          .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Usuarios");
        }

        // Retornando a lista de Usuarios
        return tLista;
    }

}

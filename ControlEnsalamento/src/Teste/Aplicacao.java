package Teste;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.ensalamento.hibernate.HibernateUtil;
import br.ensalamento.model.Curso;
import br.ensalamento.model.Ensalamento;
import br.ensalamento.model.Usuario;

public class Aplicacao
{

    public static void main(String[] args)
    {
        
    //	Ensalamento tEnsalamento = new Ensalamento();
    //	tEnsalamento.setCurso(curso);
    //	tEnsalamento.setDataFim(dataFim);
    	
    	
    	
    	Curso cCurso = new Curso();
    	
    	
    	
   /* 	Usuario tUsuario = new Usuario();
    //    tUsuario.setEnsalamento(ensalamento);
        tUsuario.setNomeCompleto("Felisberta Frundelfo");
        tUsuario.setTipoUsuario("Aluno");
        tUsuario.setEmail("teste@teste.com.br");
        tUsuario.setSenha("123456");
        tUsuario.setIdFacebook("123456");
      */ 
        
 
 	

    


        
        

        HibernateUtil.iniciarTransacao();
//
        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
        Session tSessao = tFabrica.getCurrentSession();
        
        cCurso = (Curso) tSessao.get(Curso.class,1);

       //Incluindo
     //  tSessao.save(tUsuario);
//
      //Recuperando
      //  tUsuario = (Usuario) tSessao.get(Usuario.class,1);
//
        //Alterando
//        tSessao.merge(tUsuario);
//
        //Removendo
     // tSessao.delete(tUsuario);
//
//        //Recuperando geral
//        Query tQuery = tSessao.createQuery("FROM Usuario");
//        List<Usuario> tLista = tQuery.list();
//
//        for (Usuario tUsuario2 : tLista)
//        {
//        System.out.println(tUsuario2);
//        }
//
//        System.out.println("Usuario recuperado : " + tUsuario);
//
//        //Recuperando por criterio
//        Criteria tCriterio = tSessao.createCriteria(Usuario.class);
//        tCriterio.add(Restrictions.or(Restrictions.ilike("nome", "jori%"), Restrictions.eq("id", 6)));
//
//        List<Usuario> tLista = tCriterio.list();
//
//        for (Usuario tUsuario2 : tLista)
//        {
//            System.out.println(tUsuario2);
//        }
//
//        HibernateUtil.confirmarTransacao();
//
//        HibernateUtil.fecharConexao();
    }

}

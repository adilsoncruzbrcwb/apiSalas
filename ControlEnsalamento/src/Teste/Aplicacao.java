//package Teste;
//
//import java.util.List;
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//
//public class Aplicacao
//{
//
//    public static void main(String[] args)
//    {
//        Contato tContato = new Contato();
//        tContato.setCodigo(2);
//        tContato.setNome("Felisberta Frundelfo");
//        tContato.setTelefone(41994343L);
//
//        HibernateUtil.iniciarTransacao();
//
//        SessionFactory tFabrica = HibernateUtil.getSessionFactory();
//        Session tSessao = tFabrica.getCurrentSession();
//
//        //Incluindo
//        tSessao.save(tContato);
//
//        //Recuperando
//        tContato = (Contato) tSessao.get(Contato.class,1);
//
//        //Alterando
//        tSessao.merge(tContato);
//
//        //Removendo
//        tSessao.delete(tContato);
//
//        //Recuperando geral
//        Query tQuery = tSessao.createQuery("FROM CONTATO");
//        List<Contato> tLista = tQuery.list();
//
//        for (Contato tContato2 : tLista)
//        {
//        System.out.println(tContato2);
//        }
//
//        System.out.println("Contato recuperado : " + tContato);
//
//        //Recuperando por criterio
//        Criteria tCriterio = tSessao.createCriteria(Contato.class);
//        tCriterio.add(Restrictions.or(Restrictions.ilike("nome", "jori%"), Restrictions.eq("id", 6)));
//
//        List<Contato> tLista = tCriterio.list();
//
//        for (Contato tContato2 : tLista)
//        {
//            System.out.println(tContato2);
//        }
//
//        HibernateUtil.confirmarTransacao();
//
//        HibernateUtil.fecharConexao();
//    }
//
//}

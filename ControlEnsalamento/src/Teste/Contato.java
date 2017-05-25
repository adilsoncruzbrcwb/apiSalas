//package Teste;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//
//@Entity(name = "CONTATO")
//public class Contato
//{
//    private int    codigo;
//    private String nome;
//    private long   telefone;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XPTO")
//    @SequenceGenerator(name = "XPTO", sequenceName = "CONTATO_SEQ", allocationSize = 1)
//    @Column(name="ID")
//    public int getCodigo()
//    {
//        return codigo;
//    }
//
//    public void setCodigo(int pCodigo)
//    {
//        codigo = pCodigo;
//    }
//
//    @Column(name="NOME")
//    public String getNome()
//    {
//        return nome;
//    }
//
//    public void setNome(String pNome)
//    {
//        nome = pNome;
//    }
//
//    @Column(name="TELEFONE")
//    public long getTelefone()
//    {
//        return telefone;
//    }
//
//    public void setTelefone(long pTelefone)
//    {
//        telefone = pTelefone;
//    }
//
//    @Override
//    public String toString()
//    {
//        StringBuilder tBuilder = new StringBuilder();
//        tBuilder.append("Contato [codigo=");
//        tBuilder.append(codigo);
//        tBuilder.append(", nome=");
//        tBuilder.append(nome);
//        tBuilder.append(", telefone=");
//        tBuilder.append(telefone);
//        tBuilder.append("]");
//        return tBuilder.toString();
//    }
//
//}

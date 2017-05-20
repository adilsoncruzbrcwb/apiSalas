package br.ensalamento.teste;

import br.ensalamento.hibernate.HibernateUtil;

public class TesteModel {
	
	public static void main (String []args){
		HibernateUtil.iniciarTransacao();
		HibernateUtil.confirmarTransacao();
		HibernateUtil.fecharConexao();
	}

	
	
}

package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class BuscaConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta c = manager.find(Conta.class, 1);
		
		System.out.println(c.getTitular());
		
		manager.getTransaction().commit();
	}

}

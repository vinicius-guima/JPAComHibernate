package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
	
		Conta c = new Conta();
		
		c.setTitular("VINICIUS");
		c.setNumero("123");
		c.setAgencia("13");
		c.setBanco("Itau");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		
		
		manager.clear();
		
	}
}

package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Cliente;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	
	public static void main(String[] args) {
		
		Conta c = new Conta();
		c.setId(1);
		
		Cliente  cli = new Cliente();
		cli.setNome("Jaqueline");
		cli.setEndereco("Rua: Maceio");
		cli.setProfissao("Dentista");
		cli.setConta(c);
		
		Cliente  cl = new Cliente();
		cl.setNome("Harley Quin");
		cl.setEndereco("Rua: Gothan");
		cl.setProfissao("Psicologa");
		cl.setConta(c);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction();
		
		manager.getTransaction().begin();
		
		manager.persist(cli);
		// manager.persist(cl); após as notations não é mais possivel ter 2 clientes para a mesma conta 
		
		manager.getTransaction().commit();
	}

}

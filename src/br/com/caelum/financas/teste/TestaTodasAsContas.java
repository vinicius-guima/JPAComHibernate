package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaTodasAsContas {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes"; // join fech para o padrao lazy, faz o join para que traga tudo numa so query
		Query query = manager.createQuery(jpql);						                // left join fetch traz tudo da tabela ao lado esquerdo 
		List<Conta> todasAsContas= query.getResultList();
		
		for (Conta conta : todasAsContas) {
			
			System.out.println("Titular  : " + conta.getTitular());
			System.out.println("Descricao: ");
			System.out.println(conta.getMovimentacoes());
		}
				
	}

}

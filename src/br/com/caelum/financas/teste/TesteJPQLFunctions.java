package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQLFunctions {
	
public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
//		Conta conta = new Conta();
//		conta.setId(1);
		
		Conta conta1 = manager.find(Conta.class, 1);
		
		
		String sumjpql ="select sum(m.valor) from Movimentacao m where m.conta = :pConta"+
				" and m.tipo = :pTipo"+
				" order by m.valor desc";
		
		String avgjpql ="select avg(m.valor) from Movimentacao m where m.conta = :pConta"+
				" and m.tipo = :pTipo"+
				" order by m.valor desc"; // Função avg devolve um double 
		
		String maiorValor = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
				// Função avg devolve um Big Decimal 
		
		String qtdMovimentacoesNaConta = "select count(m) from Movimentacao m where m.conta = :pConta"; // devolve um Long
	
		
		
		Query query = manager.createQuery(qtdMovimentacoesNaConta);
		query.setParameter("pConta", conta1);
		//query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		//BigDecimal soma = (BigDecimal) query.getSingleResult();
		//Double media =  (Double) query.getSingleResult();
		//BigDecimal maior = (BigDecimal) query.getSingleResult();
		Long qtd = (Long) query.getSingleResult();
		
		//System.out.println("A média é : +" + media);
		//System.out.println("A soma é  : " + soma);
		//System.out.println("A movimentação de maior valor é :" +  maior);
		System.out.println("A Sr(a) " + conta1.getTitular() + " tem " + qtd +" movimentações em sua conta.");
				
		manager.getTransaction().commit();
		manager.close();
	}

}

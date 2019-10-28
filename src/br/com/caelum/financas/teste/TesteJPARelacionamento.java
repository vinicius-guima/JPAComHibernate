package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.model.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Movimentacao mv = new Movimentacao();
		Conta c = new Conta();
		
		c.setAgencia("007");
		c.setBanco("Inter");
		c.setNumero("1551");
		c.setTitular("BATMAN");
		
		mv.setValor(new BigDecimal(100.01));
		mv.setData(Calendar.getInstance());
		mv.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mv.setDescricao("Academia");
		mv.setConta(c);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(c);
		manager.persist(mv);
		
		manager.getTransaction().commit();
		
		
		

	}
}

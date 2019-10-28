package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.model.Categoria;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.model.TipoMovimentacao;

public class PopulaMovimentacoesComCategoria {
	
	public static void main(String[] args) { 

        Categoria categoria1 = new Categoria("viagem");

        Categoria categoria2 = new Categoria("neg�cios");
        
        Conta conta = new Conta();
        conta.setId(2);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance()); //hoje
        movimentacao1.setDescricao("Viagem � SP");
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategoria(Arrays.asList(categoria1,categoria2));
        
        movimentacao1.setConta(conta);
        
        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        
        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(amanha); // amanha
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(categoria1);
        em.persist(categoria2);
        
        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();    
        em.close();    
    }

}

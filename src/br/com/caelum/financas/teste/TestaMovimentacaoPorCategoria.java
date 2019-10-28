package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.model.Categoria;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacaoPorCategoria {
	
public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		
		String jpql ="select m from Movimentacao m join m.categoria c where c = :pCategoria";
	
		Query query = manager.createQuery(jpql);
		query.setParameter("pCategoria", categoria);

		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Conta.Id : " + movimentacao.getTipoMovimentacao());
			System.out.println("Nome     : "  + movimentacao.getConta().getTitular());
 			System.out.println("Dscrição : " + movimentacao.getDescricao());
 			
			System.out.println("----------------------------------------------");
		}
				
		manager.getTransaction().commit();
		manager.close();
	}

}

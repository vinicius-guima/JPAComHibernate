package br.com.caelum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.TipoMovimentacao;

public class MovimentacaoDAO {
	
	private EntityManager manager;

	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}


	public List<Double> getMediasPorDiaEPorTipo(TipoMovimentacao saida, Conta conta) {

		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.tipo = :pTipo" + " group by m.data";

		TypedQuery<Double> query = manager.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", saida);

		return query.getResultList();
	}



	

}

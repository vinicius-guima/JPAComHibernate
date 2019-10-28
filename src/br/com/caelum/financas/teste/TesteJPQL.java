package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.dao.MovimentacaoDAO;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		MovimentacaoDAO dao = new MovimentacaoDAO(manager);
		List<Double> medias = dao.getMediasPorDiaEPorTipo(TipoMovimentacao.SAIDA, conta);
		
		for (Double media : medias) {
			System.out.println("A media é " + media );
		}
		
		manager.getTransaction().commit();
		manager.close();
	}

}

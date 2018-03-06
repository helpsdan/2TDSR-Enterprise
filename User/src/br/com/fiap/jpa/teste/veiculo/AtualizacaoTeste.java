package br.com.fiap.jpa.teste.veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Veiculo;

public class AtualizacaoTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		Veiculo veiculo = new Veiculo("ABS-1234", "Azul", 2013);
		
		em.merge(veiculo);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}

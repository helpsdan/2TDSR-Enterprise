package br.com.fiap.jpa.teste.veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Veiculo;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("oracle");
			
			EntityManager em = fabrica.createEntityManager();
			
			Veiculo veiculo = em.find(Veiculo.class, 1);
			
			System.out.println(veiculo.getCodigoVeiculo() + veiculo.getPlaca() + veiculo.getCor()+ veiculo.getAno());
			
			em.close();
			fabrica.close();

	}

}

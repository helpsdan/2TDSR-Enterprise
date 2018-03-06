package br.com.fiap.jpa.teste.veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Veiculo;

public class CadastroTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
			
			EntityManager em = fabrica.createEntityManager();
			
			Veiculo veiculo = new Veiculo("ABC-1234","Azul", 2013);
			
			em.persist(veiculo);
			em.getTransaction().begin();
			em.getTransaction().commit();
			
			em.close();
			fabrica.close();
	}

}

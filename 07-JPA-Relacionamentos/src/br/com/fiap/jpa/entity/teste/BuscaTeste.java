package br.com.fiap.jpa.entity.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		NotaFiscalDAO dao = new NotaFiscalDAOImpl(em);
		
		// buscar uma nota fiscal
		NotaFiscal nota = dao.read(1);
		
		// Exibir o CNPJ
		System.out.println(nota.getCnpj());
		

		// Exibir a descrição do pedido
		System.out.println(nota.getPedido().getDescricao());

		em.close();
		fabrica.close();
		
	}

}

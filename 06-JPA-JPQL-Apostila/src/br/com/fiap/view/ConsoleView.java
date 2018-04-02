package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Listar cidades
		
		CidadeDAO dao = new CidadeDAOImpl(em);
		List<Cidade> listar = dao.listar();
		System.out.println("LISTAR CIDADES");
		for (Cidade cidade : listar) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		System.out.println("BUSCAR POR NOME");
		listar = dao.buscarPorNome("S");
		for (Cidade cidade : listar) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		/*
		// Listar Clientes
		ClienteDAO cli = new ClienteDAOImpl(em);
		List<Cliente> listarClientes = cli.listar();
		System.out.println("LISTA CLIENTES");
		for (Cliente cliente : listarClientes) {
			System.out.println(cliente.getNome());
		}
		*/
		em.close();
		fabrica.close();
	}

}




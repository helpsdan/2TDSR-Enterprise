package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.entity.Reserva;

public class ConsoleView3 {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
	EntityManager em = fabrica.createEntityManager();
	
	ReservaDAO reservaDAO = new ReservaDAOImpl(em);
	
	List<Reserva> lista = reservaDAO.buscarPorCidade("Sao Paulo");
	
	for (Reserva reserva : lista) {
		System.out.println(reserva.getPacote().getDescricao() + " - " + reserva.getCliente().getEndereco().getCidade().getNome());
	}
	
	PacoteDAO pacoteDAO = new PacoteDAOImpl(em);
	
	System.out.println("Pacotes com transportes: " + pacoteDAO.contarPorTransporte());
	
	
	
	em.close();
	fabrica.close();

	
	
	
	}
	
}

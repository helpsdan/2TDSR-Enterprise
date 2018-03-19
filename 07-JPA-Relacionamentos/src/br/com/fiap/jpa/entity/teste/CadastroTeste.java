package br.com.fiap.jpa.entity.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ItemPedidoDAO;
import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.StatusPedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		// Cadastrar a nota fiscal e pedido

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		PedidoDAO pedidoDAO = new PedidoDAOImpl(em);
		NotaFiscalDAO notaDAO = new NotaFiscalDAOImpl(em);
		
		//Cadastrar
		Pedido pedido = new Pedido("Churros", StatusPedido.APROVADO);
		NotaFiscal nota = new NotaFiscal(5, "1234567984", pedido);
		
		ItemPedido item = new ItemPedido();
		item.setQuantidade(12);
		item.setValor(5);
		
		ItemPedido item1 = new ItemPedido();
		item.setQuantidade(15);
		item.setValor(10);
		
		ItemPedido item2 = new ItemPedido();
		item.setQuantidade(4);
		item.setValor(1.5);
		
		pedido.adicionarItem(item);
		pedido.adicionarItem(item1);
		pedido.adicionarItem(item2);
		
		try {
			pedidoDAO.create(pedido);
			notaDAO.create(nota);
			notaDAO.commit();
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
	
			
		
		em.close();
		fabrica.close();
		
	}

}

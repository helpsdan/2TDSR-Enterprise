package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ItemPedidoDAO;
import br.com.fiap.jpa.entity.ItemPedido;

public class ItemPedidoDAOImpl extends GenericDAOImpl<ItemPedido, Integer>
implements ItemPedidoDAO{

	public ItemPedidoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

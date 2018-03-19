package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_PEDIDO")
@SequenceGenerator(name="item", sequenceName="SQ_T_ITEM_NOTA", allocationSize =1)
public class ItemPedido {

	@Id
	@GeneratedValue(generator="item", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_item_pedido")
	private int codigo;
	
	@Column(name="nr_quantidade", nullable=false)
	private int quantidade;
	
	@Column(name="vl_preco",nullable=false)
	private double valor;
	
	@ManyToOne
	@JoinColumn(name="cd_pedido")
	private Pedido pedido;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}

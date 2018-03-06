package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NaoEncontradaException;

public class VeiculoDAOImpl implements VeiculoDAO {

	private EntityManager em;
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public Veiculo cadastrar(Veiculo veiculo) {
		em.persist(veiculo);
		return veiculo;
	}

	@Override
	public Veiculo atualizar(Veiculo veiculo) {
		em.merge(veiculo);
		return veiculo;
	}

	@Override
	public void remover(int codigoVeiculo) throws NaoEncontradaException {
		Veiculo veiculo = buscar(codigoVeiculo);
		if(veiculo == null)
			throw new NaoEncontradaException();
		em.remove(veiculo);
	}

	@Override
	public Veiculo buscar(int codigoVeiculo) {
		return em.find(Veiculo.class, codigoVeiculo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}

}

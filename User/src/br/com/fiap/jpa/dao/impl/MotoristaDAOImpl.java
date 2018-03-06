package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NaoEncontradaException;

public class MotoristaDAOImpl implements MotoristaDAO {

	private EntityManager em;

	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Motorista cadastrar(Motorista motorista) {
		em.persist(motorista);
		return motorista;
	}

	@Override
	public Motorista atualizar(Motorista motorista) {
		em.merge(motorista);
		return motorista;
	}

	@Override
	public void remover(int numeroCarteira) throws NaoEncontradaException {
		Motorista motorista = buscar(numeroCarteira);
		if (motorista == null)
			throw new NaoEncontradaException();
		em.remove(motorista);
	}

	@Override
	public Motorista buscar(int numeroCarteira) {
		return em.find(Motorista.class, numeroCarteira);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}

}

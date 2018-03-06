package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NaoEncontradaException;

public interface MotoristaDAO {

	Motorista cadastrar(Motorista motorista);
	Motorista atualizar(Motorista motorista);
	void remover(int numeroCarteira) throws NaoEncontradaException;
	Motorista buscar(int numeroCarteira);
	
	void commit() throws CommitException;
}

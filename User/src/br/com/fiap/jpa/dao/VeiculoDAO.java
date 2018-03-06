package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.NaoEncontradaException;

public interface VeiculoDAO {

	Veiculo cadastrar (Veiculo veiculo);
	Veiculo atualizar (Veiculo veiculo);
	void remover(int codigoVeiculo) throws NaoEncontradaException;
	Veiculo buscar(int codigoVeiculo);
	
	void commit() throws CommitException;
}

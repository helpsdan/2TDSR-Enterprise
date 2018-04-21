package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
	double calcularMediaPreco();
	
	//CONTAR A QUANTIDADE DE PACOTES QUE POSSUEM TRANSPORTE
	long contarPorTransporte();
	
	// SOMAR OS PREÇOS DOS PACOTES POR PERIODO DE DATA
}

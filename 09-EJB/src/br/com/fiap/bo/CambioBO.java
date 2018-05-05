package br.com.fiap.bo;

import javax.ejb.Remote;

@Remote
public interface CambioBO {

	void adicionarDolar(double valor);
	
	double verTotal();
	
}

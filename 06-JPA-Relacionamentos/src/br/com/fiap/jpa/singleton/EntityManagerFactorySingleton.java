package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// 1- Construtor privado

	private EntityManagerFactorySingleton() {

	}

	// 2- Atributo privado est�tico

	private static EntityManagerFactory fabrica;

	// 3- M�todo publico est�tico
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}

}

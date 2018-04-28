package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {

	public static void main(String[] args) {

		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//CADASTRAR UMA PESSOA, PF E PJ
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		Pessoa pessoa = new Pessoa("Daniel", "Londrina");
		PessoaFisica pessoaFisica = new PessoaFisica("Douglas","São Paulo", "0123456789", 
													new GregorianCalendar(2017, Calendar.NOVEMBER,11));
		PessoaJuridica pessoaJuridica = new PessoaJuridica("Thiago", "China", "46114766857", 
													new GregorianCalendar(2017, Calendar.MARCH,18));
		
		try {
			dao.create(pessoa);
			dao.create(pessoaFisica);
			dao.create(pessoaJuridica);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		
		em.close();
		fabrica.close();
		
	}

}

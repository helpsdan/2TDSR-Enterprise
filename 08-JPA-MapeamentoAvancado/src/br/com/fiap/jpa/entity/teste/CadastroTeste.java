package br.com.fiap.jpa.entity.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.ContaCorrenteDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.dao.impl.ContaCorrenteDAOImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.ContaCorrente;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		ContaCorrenteDAO dao = new ContaCorrenteDAOImpl(em);

		ContaCorrente cc = new ContaCorrente(1, 1, 100, new GregorianCalendar(2010, Calendar.MARCH, 20));

		try {
			dao.create(cc);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		Medico medico = new Medico(123, "jão");
		Paciente paciente = new Paciente("maria", new GregorianCalendar(1999, Calendar.NOVEMBER,11));
		Consulta consulta = new Consulta(medico, paciente, Calendar.getInstance(), true, "21A");
		
		ConsultaDAO consultaDAO = new ConsultaDAOImpl(em);
		
		
		try {
			consultaDAO.create(consulta);
			consultaDAO.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}		
		
		em.close();
		fabrica.close();
		
	}

}

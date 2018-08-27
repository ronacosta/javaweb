package br.unipe.fujioka.java.web;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class EditaCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();
		
		Cliente editaCliente = new Cliente();
		editaCliente.setNome("Ronaldo Costa");
		editaCliente.setDataFim(new Date());
		editaCliente.setDataInicio(new Date());
		
		Cliente cliente =  manager.find(Cliente.class, 1L);
		cliente.setNome(editaCliente.getNome());
		cliente.setDataInicio(editaCliente.getDataInicio());
		cliente.setDataFim(editaCliente.getDataFim());
		manager.getTransaction().begin();
		manager.persist(cliente);		
		manager.getTransaction().commit();
		
		manager.close();
	}

}

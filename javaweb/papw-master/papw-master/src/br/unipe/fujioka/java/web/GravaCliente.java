package br.unipe.fujioka.java.web;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class GravaCliente {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();
		Cliente cliente = new Cliente();
		cliente.setNome("Rodrigo Fujioka");
		cliente.setMatricula("1");
		cliente.setDataFim(new Date());
		cliente.setDataInicio(new Date());
		System.out.println(cliente);
		manager.getTransaction().begin();
		manager.persist(cliente);		
		manager.getTransaction().commit();
		
		manager.close();
		
		
		
		
	}

}

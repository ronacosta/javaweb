package br.unipe.fujioka.java.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class DesativarCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();

		Cliente cliente = manager.find(Cliente.class, 33L);

		cliente.setAtivo(false);
		
		manager.getTransaction().begin();
		manager.persist(cliente);		
		manager.getTransaction().commit();
		manager.close();

	}

}

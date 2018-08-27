package br.unipe.fujioka.java.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class RemoverCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();
		
		Cliente cliente = manager.find(Cliente.class, 1L);
		
		System.out.println("Removendo cliente: " + cliente.getNome());
		
		manager.getTransaction().begin();
		manager.remove(cliente);		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}

}

package br.unipe.fujioka.java.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class AtivarCliente {

//	Após executar a class, execute a class ListaCliente e verifique as alterações
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();

		Cliente cliente = manager.find(Cliente.class, 1L);

		cliente.setAtivo(true);
		
		manager.getTransaction().begin();
		manager.persist(cliente);		
		manager.getTransaction().commit();
		manager.close();
	}

}

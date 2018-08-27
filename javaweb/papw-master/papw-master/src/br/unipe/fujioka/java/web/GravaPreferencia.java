package br.unipe.fujioka.java.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.fujioka.java.web.entidades.Cliente;
import br.unipe.fujioka.java.web.entidades.Preferencia;

public class GravaPreferencia {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();
		
		Cliente cliente = manager.find(Cliente.class, 1L);
		
		Preferencia preferencia = new Preferencia();
		preferencia.setDescricao("Carro 2 Portas");
		preferencia.setCliente(cliente);
		
		Preferencia preferencia2 = new Preferencia();
		preferencia2.setDescricao("Casa 2 comodos");
		preferencia2.setCliente(cliente);
		
		System.out.println(preferencia);
		manager.getTransaction().begin();
		manager.persist(preferencia);
		manager.persist(preferencia2);
		manager.getTransaction().commit();
		
		manager.close();

	}

}

package br.unipe.fujioka.java.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import br.unipe.fujioka.java.web.entidades.Cliente;

public class ListaCliente {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();
				
		Query query = manager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista =  query.getResultList();
		
		for(Cliente c : lista) 		
			System.out.println(
				" ------" +
				"\n ID: " + c.getId() + 
				"\n Cliente: " + c.getNome() +
				"\n Ativo: " + c.getAtivo() +
				"\n ------"
				);
		
		manager.close();
		factory.close();
		
		
		
	}

}

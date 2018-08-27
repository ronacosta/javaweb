package br.unipe.fujioka.java.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unipe.fujioka.java.web.entidades.Cliente;
import br.unipe.fujioka.java.web.entidades.Preferencia;

public class ListaPreferencia {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
		EntityManager manager = factory.createEntityManager();
		
		Integer matricula = 1;
		
		Query q = manager.createQuery("select p from Preferencia p where p.cliente.matricula = " + matricula);
		List<Preferencia> lista =  q.getResultList();
		System.out.println(lista);
		
		for(Preferencia p : lista)
			System.out.println(
				" ------" +
				"\n ID: " + p.getId() + 
				"\n Descricão: " + p.getDescricao() +
				"\n Cliente: " + p.getCliente().getNome() +
				"\n ------"
				);
		
		manager.close();
		factory.close();

	}

}

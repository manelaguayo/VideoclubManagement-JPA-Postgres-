package Managers_Main;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Genere;

public class GenereManager {

	public void AddGenere(Genere genere){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		em.persist(genere);
		em.getTransaction().commit();
		em.close();
	}
	

	public void ListGeneres(){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		
		List<Genere> result = em.createNamedQuery("From Genere", Genere.class)
				.getResultList();
		
		for (Genere genere: result){
			
			System.out.println(genere.toString());
			
		}
		
		System.out.println("###############################");

		em.getTransaction().commit();
		em.close();
	}
	

	public void RemoveGenere(Integer id_genere){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Genere genere= (Genere) em.find(Genere.class, id_genere);

		em.remove(genere);
		em.getTransaction().commit();
		em.close();
	}
	

	public void UpdateGenere(Integer id_genere, String new_genere_name){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Genere genere= (Genere) em.find(Genere.class, id_genere);

		genere.setDescripcio(new_genere_name);
		
		em.merge(genere);
		em.getTransaction().commit();
		em.close();
	}
	
}

package Managers_Main;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Pelicula;


public class PeliculaManager {

	
	public void AddPelicula(Pelicula peli){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		em.persist(peli);
		em.getTransaction().commit();
		em.close();
	}
	

	public void ListPelicules(){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		
		List<Pelicula> result = em.createNamedQuery("From Pelicula", Pelicula.class)
				.getResultList();
		
		for (Pelicula peli: result){
			
			System.out.println(peli.toString());
			
		}
		
		System.out.println("###############################");

		em.getTransaction().commit();
		em.close();
	}
	

	public void RemovePelicula(Integer id_peli){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Pelicula peli= (Pelicula) em.find(Pelicula.class, id_peli);
		
		em.remove(peli);
		em.getTransaction().commit();
		em.close();
	}
	

	public void UpdateTitlePelicula(Integer id_actor, Integer id_peli, String new_title_peli){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Pelicula peli= (Pelicula) em.find(Pelicula.class, id_peli);

		peli.setTitol_pelicula(new_title_peli);
		
		em.merge(peli);
		em.getTransaction().commit();
		em.close();
	}
	
}

package Managers_Main;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Client;
import Entities.Pelicula;
import Entities.Visualitzacio;

public class VisualitzacioManager {

	
	public void AddVisualitzacio(Visualitzacio visualitzacio){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		em.merge(visualitzacio);
		em.getTransaction().commit();
		em.close();
	}
	

	public void ListVisualitzacions(){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		
		List<Visualitzacio> result = em.createNamedQuery("From Visualitzacio", Visualitzacio.class)
				.getResultList();
		
		for (Visualitzacio visual: result){
			
			System.out.println(visual.toString());
			
		}
		
		System.out.println("###############################");

		em.getTransaction().commit();
		em.close();
	}
	

	public void RemoveVisualitzacio(int hashCode){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Visualitzacio visual= (Visualitzacio) em.find(Visualitzacio.class, hashCode);

		em.remove(visual);
		em.getTransaction().commit();
		em.close();
	}
		
	
}

package Managers_Main;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Actuacio;

public class ActuacioManager {

	public void AddActuacio(Actuacio actuacio){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		em.persist(actuacio);
		em.getTransaction().commit();
		em.close();
	}
	

	public void ListActuacions(){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		
		List<Actuacio> result = em.createNamedQuery("From Actuacio", Actuacio.class)
				.getResultList();
		
		for (Actuacio actuacio: result){
			
			System.out.println(actuacio.toString());
			
		}
		
		System.out.println("###############################");

		em.getTransaction().commit();
		em.close();
	}
	

	public void RemoveActuacio(int hashCode){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Actuacio actuacio2= (Actuacio) em.find(Actuacio.class, hashCode);
		
		em.remove(actuacio2);
		em.getTransaction().commit();
		em.close();
	}
	

	public void UpdateActuacio(int hashCode, String new_personatge){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();	
		
		Actuacio actuacio2= (Actuacio) em.find(Actuacio.class, hashCode);

		actuacio2.setPersonatge(new_personatge);
		
		em.merge(actuacio2);
		em.getTransaction().commit();
		em.close();
	}
	
}

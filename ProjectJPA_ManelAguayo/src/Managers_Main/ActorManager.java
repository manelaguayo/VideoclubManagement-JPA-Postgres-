package Managers_Main;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Actor;

public class ActorManager {

	
	public void AddActor(Actor actor){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		em.persist(actor);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void ListActors(){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		
		List<Actor> result = em.createQuery("from Actor", Actor.class)
				.getResultList();
		for (Actor actor : result) {
			System.out.println(actor.toString());
		}
		
		System.out.println("###############################");
		
		em.getTransaction().commit();
		em.close();
		
		
	}
	
	public void RemoveActor(Integer id_actor){
		
		EntityManager em = mainJPA.emf.createEntityManager();
		em.getTransaction().begin();
		Actor actor = (Actor) em.find(Actor.class, id_actor);
		em.remove(actor);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void UpdateActor(Integer id_actor, String name){
		
		EntityManager em = mainJPA.emf.createEntityManager();
		em.getTransaction().begin();
		Actor actor = (Actor) em.find(Actor.class, id_actor);
	
		actor.setNom(name);
		em.merge(actor);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	
}

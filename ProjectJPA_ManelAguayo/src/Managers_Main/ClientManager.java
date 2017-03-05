package Managers_Main;
import java.util.List;

import javax.persistence.EntityManager;

import Entities.Client;

public class ClientManager {

public void AddClient(Client client){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		em.persist(client);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void ListClients(){
		
		EntityManager em= mainJPA.emf.createEntityManager();
		em.getTransaction().begin();		
		
		List<Client> result = em.createQuery("from Client", Client.class)
				.getResultList();
		for (Client client : result) {
			System.out.println(client.toString());
		}
		
		System.out.println("###############################");
		
		em.getTransaction().commit();
		em.close();
		
		
	}
	
	public void RemoveClient(String code_client){
		
		EntityManager em = mainJPA.emf.createEntityManager();
		em.getTransaction().begin();
		Client client = (Client) em.find(Client.class, code_client);
		em.remove(client);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void UpdateNameClient(String code_client, String name){
		
		EntityManager em = mainJPA.emf.createEntityManager();
		em.getTransaction().begin();
		Client client = (Client) em.find(Client.class, code_client);
	
		client.setName(name);
		em.merge(client);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}

package Managers_Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Actor;
import Entities.Actuacio;
import Entities.Pelicula;
import Entities.Visualitzacio;
import Entities.Genere;
import Tools.FileAccessor;

public class mainJPA {

	public static EntityManagerFactory emf;
	FileAccessor fa= new FileAccessor();	
	
	ActorManager AC = new ActorManager();
	ClientManager CM= new ClientManager();
	ActuacioManager ActuacioM = new ActuacioManager();
	PeliculaManager PM= new PeliculaManager();
	VisualitzacioManager VM= new VisualitzacioManager();		
	GenereManager GM= new GenereManager();
	
	public static void main(String[] args) throws IOException, ParseException {
		
			try{
			
				emf= Persistence.createEntityManagerFactory("VideoclubJPA");
			}catch (Throwable ex){
				
				System.err.println("Failed to create EntityManagerFactory object");
				throw new ExceptionInInitializerError(ex);
			}
			
			mainJPA MM= new mainJPA();
			int opcio=-1;
			
			while (opcio!=4){
				
				opcio=MM.menu();
				System.out.println(opcio);
				
				switch (opcio){
				
				case 1: 
						System.out.println("Càrrega de dades realitzada correctament.");
						MM.LoadDataToDB(); 
						break;
				case 2: 
					
						Genere nouGenere= MM.CrearGenere();
						MM.GM.AddGenere(nouGenere);
						System.out.println("Genere "+nouGenere.getDescripcio()+ " creat.");
						break;
						
				case 3: MM.UpdatePersonatgeActuacio(); //Actualitzem l'actuacio on l'actor 1 a la peli 7 fa de Messi.
						System.out.println("Actualització de personatge realitzada correctament.");
						break;
						
				case 4: 
						System.exit(0);
						break;
	
				
				}
			}
			
	}
			
		public void LoadDataToDB() throws IOException, ParseException{	
					
		fa.readActors("actor.csv");
		fa.readClients("clients.csv");
		fa.readGeneres("generes.csv");
		fa.readPelicula("peliculas.csv");
		fa.readActuacions("actuacions.csv");
		fa.readVisualitzacions("visualitzacions.csv");
		
		
		for (Visualitzacio visual: fa.llistaVisualitzacions){
		
			VM.AddVisualitzacio(visual);
			
		}
		
	}
	
		public int menu() throws IOException{
			
			System.out.println("PROJECTE JPA - A.Alhama M.Aguayo ");
			System.out.println("1. Càrrega dades a la base de dades.");
			System.out.println("2. Afegir nou gènere.");
			System.out.println("3. Modificar personatge d'actuació (predefinida).");
			System.out.println("4. Sortir");

			int opcio=-1;
			
			System.out.println("Escull una opció: ");
			Scanner br= new Scanner(System.in);
			
			opcio= br.nextInt();
		
			return opcio;
			
		}
		
		public Genere CrearGenere() throws IOException{
			
			Scanner br= new Scanner(System.in) ;
			System.out.println("Introdueix un id de genere (int): ");
			int id= br.nextInt();
			br.nextLine();
			System.out.println("Introdueix una descripcio: ");
			String descp= br.nextLine();
			
			Genere gen= new Genere(id, descp);
			
			return gen;
		}
		
		public void UpdatePersonatgeActuacio(){
			
			for (int i=0; i<fa.llistaPelicules.size(); i++){
				
				for (int j=0; j<fa.llistaPelicules.get(i).getActuacions().size(); j++){
					
					while (fa.llistaPelicules.get(i).getActuacions().iterator().hasNext()){
						
						Actuacio act=fa.llistaPelicules.get(i).getActuacions().iterator().next();
						
						if (act.getCodi_actor().getCodi_actor()== 1
								&& act.getCodi_pelicula().getId_pelicula()==7
								&& act.getPersonatge().equalsIgnoreCase("Messi")){
								
								int hash= act.hashCode();
								ActuacioM.UpdateActuacio(hash, "Superman");

							}
							
						}
					}
					
				}
				
			}
		
		
		/*
		 * S'ha decidit esborrar aquest mètode del menú perque teníem problemes
		 * per esborrar una pel·lícula en Cascade.ALL.
		 * 
		 * 
		 * public void EsborrarPelicula(){
			
			PM.ListPelicules();		
			System.out.println("Introdueix un id de pelicula per esborrar: ");
			@SuppressWarnings("resource")
			int id= new Scanner(System.in).nextInt();
			
			PM.RemovePelicula(id);
			
		}*/
	
}





package Entities;

public class Actor {
	

	private int codi_actor;
	private String nom;
	private String nacionality;
	
	public Actor(){
		
		
	}
	public Actor(int codi, String nom2, String nacionalitat) {
		
		this.codi_actor=codi;
		this.nom=nom2;
		this.nacionality=nacionalitat;
	}
	
	public int getCodi_actor() {
		return codi_actor;
	}
	public void setCodi_actor(int codi_actor) {
		this.codi_actor = codi_actor;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNacionality() {
		return nacionality;
	}
	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}
		
	@Override
	public String toString() {
		return "Actor [codi_actor=" + codi_actor + ", nom=" + nom + ", nacionality=" + nacionality + "]";
	}

}

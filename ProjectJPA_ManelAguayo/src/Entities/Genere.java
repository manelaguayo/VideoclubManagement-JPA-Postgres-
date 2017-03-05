package Entities;

public class Genere {

	private int id_genere;
	private String descripcio;
	
	public Genere(){
		
		
	}
	
	public Genere(int id_genere, String descripcio) {
		
		this.id_genere=id_genere;
		this.descripcio=descripcio;
		
	}
	
	public int getId_genere() {
		return id_genere;
	}
	public void setId_genere(int id_genere) {
		this.id_genere = id_genere;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	@Override
	public String toString() {
		return "Genere [id_genere=" + id_genere + ", descripcio=" + descripcio + "]";
	}
	
	
	
}

package Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
public class Pelicula implements Serializable
{

	private int id_pelicula;
	private String titol_pelicula;
	private Genere genere;

	private Set<Actuacio> llistat_actuacions = new HashSet<Actuacio> ();
	
	
	public Pelicula(int id_pelicula, String titol_pelicula, Genere genere) 
	{
		super();
		this.id_pelicula = id_pelicula;
		this.titol_pelicula = titol_pelicula;
		this.genere = genere;
	}
	
	public Pelicula(int id_pelicula, String titol_pelicula, Genere genere, Set<Actuacio> llistat_actuacions) 
	{
		super();
		this.id_pelicula = id_pelicula;
		this.titol_pelicula = titol_pelicula;
		this.genere = genere;
		this.llistat_actuacions = llistat_actuacions;
	}
	
	public Pelicula() 
	{
		super();
	}
	
	public int getId_pelicula() 
	{
		return id_pelicula;
	}
	
	public void setId_pelicula(int id_pelicula) 
	{
		this.id_pelicula = id_pelicula;
	}
	
	public String getTitol_pelicula() 
	{
		return titol_pelicula;
	}
	
	public void setTitol_pelicula(String titol_pelicula) 
	{
		this.titol_pelicula = titol_pelicula;
	}
	
	public void addActuacions(Actuacio act)
	{
		llistat_actuacions.add(act);
	}
	
	public Set<Actuacio> getActuacions()
	{
		return llistat_actuacions;
		
	}
	
	
	public void setLlistat_actuacions(HashSet<Actuacio> llistat_actuacions) 
	{
		this.llistat_actuacions = llistat_actuacions;
	}
	
	public Genere getGenere() 
	{
		return genere;
	}
	
	public void setGenere(Genere genere) 
	{
		this.genere = genere;
	}
	

	@Override
	public String toString() 
	{
		return "Pelicula [id_pelicula=" + id_pelicula + ", titol_pelicula=" + titol_pelicula + ", genere=" + genere
				+ ", llistat_actuacions=" + llistat_actuacions + "]";
	}
	
	
	
		
}

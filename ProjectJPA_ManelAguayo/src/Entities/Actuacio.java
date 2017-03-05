package Entities;

import java.io.Serializable;

import Managers_Main.ActuacioPK;

@SuppressWarnings("serial")
public class Actuacio implements Serializable
{

	private Actor codi_actor;
	private Pelicula codi_pelicula;
	private String personatge;
	
	
	public Actuacio(Actor codi_actor, Pelicula codi_pelicula, String personatge) 
	{
		super();
		this.codi_actor = codi_actor;
		this.codi_pelicula = codi_pelicula;
		this.personatge = personatge;
	}

	public Actuacio() 
	{
		super();
	}

	public String getPersonatge() 
	{
		return personatge;
	}
	
	public void setPersonatge(String personatge) 
	{
		this.personatge = personatge;
	}
	
	public Pelicula getCodi_pelicula() 
	{
		return codi_pelicula;
	}
	
	public void setCodi_pelicula(Pelicula codi_pelicula) 
	{
		this.codi_pelicula = codi_pelicula;
	}
	
	public Actor getCodi_actor() 
	{
		return codi_actor;
	}
	
	public void setCodi_actor(Actor codi_actor) 
	{
		this.codi_actor = codi_actor;
	}
	
	
}

package Managers_Main;


import java.io.Serializable;

import Entities.Actor;
import Entities.Pelicula;

public class ActuacioPK implements Serializable {

	private Actor codi_actor;
	private Pelicula codi_pelicula;
	private String personatge;
	
	
	public ActuacioPK(){
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof ActuacioPK)) return false;
		ActuacioPK pk = (ActuacioPK) obj;
		return pk.codi_actor.equals(this.codi_actor) &&
				pk.codi_pelicula.equals(this.codi_pelicula) &&
				pk.personatge.equals(this.personatge);
	}

	@Override
	public int hashCode() {
		
		return (int) this.codi_actor.getCodi_actor() + codi_pelicula.getId_pelicula() + personatge.hashCode();
	}


	
}

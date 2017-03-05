package Managers_Main;
import java.io.Serializable;
import java.util.Date;

import Entities.Actor;
import Entities.Client;
import Entities.Pelicula;

public class VisualitzacioPK implements Serializable {

	private Date data_entrada;
	private Client client_view;
	private Pelicula peli_view;
	
	public VisualitzacioPK(){
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof ActuacioPK)) return false;
		VisualitzacioPK pk = (VisualitzacioPK) obj;
		return pk.data_entrada.equals(this.data_entrada) &&
				pk.client_view.equals(this.client_view) &&
				pk.peli_view.equals(this.peli_view);
	}

	@Override
	public int hashCode() {
		
		return (int) this.data_entrada.getTime() + Integer.parseInt(client_view.getCode()) + peli_view.hashCode();
	}
	
}

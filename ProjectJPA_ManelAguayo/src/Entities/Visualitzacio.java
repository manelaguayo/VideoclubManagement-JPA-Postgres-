package Entities;

import java.util.Date;

import Managers_Main.VisualitzacioPK;

public class Visualitzacio extends VisualitzacioPK {

	private Date data_entrada;
	private Client client_view;
	private Pelicula peli_view;
	
	public Visualitzacio(){
		
		
	}
	
	public Visualitzacio(Date date, Client client, Pelicula peli){
		
		this.data_entrada=date;
		this.client_view=client;
		this.peli_view=peli;
		
	}
	
	public Date getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}
	public Client getClient_view() {
		return client_view;
	}
	public void setClient_view(Client client_view) {
		this.client_view = client_view;
	}
	public Pelicula getPeli_view() {
		return peli_view;
	}
	public void setPeli_view(Pelicula peli_view) {
		this.peli_view = peli_view;
	}

	@Override
	public String toString() {
		return "Visualitzacio [data_entrada=" + data_entrada + ", client_view=" + client_view + ", peli_view="
				+ peli_view + "]";
	}
	
	
	
	
	
}

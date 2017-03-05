package Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import Entities.Actor;
import Entities.Actuacio;
import Entities.Client;
import Entities.Genere;
import Entities.Pelicula;
import Entities.Visualitzacio;

public class FileAccessor {

	public ArrayList<Actor> llistaActors = new ArrayList<Actor>();
	public ArrayList<Pelicula> llistaPelicules = new ArrayList<Pelicula>();
	public ArrayList<Client> llistaClients = new ArrayList<Client>();
	public ArrayList<Genere> llistatGeneres = new ArrayList<Genere>();
	public ArrayList<Visualitzacio> llistaVisualitzacions = new ArrayList<Visualitzacio>();

	public void readActors(String src) throws IOException {
		int codi;
		String nom;
		String nacionalitat;

		BufferedReader br = new BufferedReader(new FileReader(src));
		String linea = "";
		while ((linea = br.readLine()) != null)

		{
			StringTokenizer token = new StringTokenizer(linea, ",");

			codi = Integer.parseInt(token.nextToken());
			nom = token.nextToken();
			nacionalitat = token.nextToken();

			llistaActors.add(new Actor(codi, nom, nacionalitat));

		}
		br.close();

	}

	public void readPelicula(String src) throws IOException {

		int id;
		String titol;

		BufferedReader br = new BufferedReader(new FileReader(src));
		String linea = "";
		while ((linea = br.readLine()) != null)

		{
			StringTokenizer token = new StringTokenizer(linea, ",");

			id = Integer.parseInt(token.nextToken());

			titol = token.nextToken();

			int genid = Integer.parseInt(token.nextToken());

			for (int i = 0; i < llistatGeneres.size(); i++) {

				if (genid == llistatGeneres.get(i).getId_genere()) {

					llistaPelicules.add(new Pelicula(id, titol, llistatGeneres.get(i)));
				}
			}

		}

		br.close();

	}

	public void readActuacions(String src) throws IOException {
		int codi_actor;

		int codi_pelicula;

		String personatge;

		BufferedReader br = new BufferedReader(new FileReader(src));
		String linea = "";
		while ((linea = br.readLine()) != null)

		{
			StringTokenizer token = new StringTokenizer(linea, ",");

			codi_actor = Integer.parseInt(token.nextToken());

			codi_pelicula = Integer.parseInt(token.nextToken());

			personatge = token.nextToken();

			for (int i = 0; i < llistaActors.size(); i++) {
				for (int j = 0; j < llistaPelicules.size(); j++) {
					if (codi_actor == llistaActors.get(i).getCodi_actor()
							&& codi_pelicula == llistaPelicules.get(j).getId_pelicula()) {

						Actuacio actuacio = new Actuacio(llistaActors.get(i), llistaPelicules.get(j), personatge);

						llistaPelicules.get(j).addActuacions(actuacio);

					}
				}
			}

		}

		br.close();

	}

	public void readClients(String src) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(src));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");

			llistaClients.add(new Client(str.nextToken(), str.nextToken()));

		}
		br.close();

	}

	public void readVisualitzacions(String src) throws IOException, ParseException {

		Date data_visualitzacio = null;
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

		BufferedReader br = new BufferedReader(new FileReader(src));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");

			data_visualitzacio = dateformat.parse(str.nextToken());

			String id_client = str.nextToken();

			int id_peli = Integer.parseInt(str.nextToken());

			for (int i = 0; i < llistaClients.size(); i++) {
				for (int j = 0; j < llistaPelicules.size(); j++) {

					if (id_client.equals(llistaClients.get(i).getCode())
							&& id_peli == llistaPelicules.get(j).getId_pelicula()) {

						llistaVisualitzacions.add(
								new Visualitzacio(data_visualitzacio, llistaClients.get(i), llistaPelicules.get(j)));
					}

				}

			}

		}

		br.close();

	}

	public void readGeneres(String src) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(src));
		String linea = "";
		while ((linea = br.readLine()) != null) {
			StringTokenizer str = new StringTokenizer(linea, ",");

			llistatGeneres.add(new Genere(Integer.parseInt(str.nextToken()), str.nextToken()));

		}
		br.close();

	}

}

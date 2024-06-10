package getdata;

import netdatatypes.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Matrice {
	private ArrayList<Route> routes = new ArrayList<Route>();
	private ArrayList<City> cities = new ArrayList<City>();
	
	public Matrice() {}
	
	public Matrice(String city_name) throws IOException, CsvException {
		
		Reader reader = Files.newBufferedReader(Paths.get("src/csv/Data - " + city_name + ".csv"));
		CSVReader csv_reader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		
		List<String[]> data = csv_reader.readAll();
		
		for(int i = 0; i < data.size(); i++) {
			listCities(data.get(i)[0]);
			listRoutes(data.get(i)[0].split(" - "), data.get(i)[1].split(" - "), countCosts(Integer.parseInt(data.get(i)[2])), Integer.parseInt(data.get(i)[2]));
		}
		this.cities.add(this.cities.get(1));
		this.cities.remove(1);
	}
	
	public ArrayList<Route> getRoutes() {
		return this.routes;
	}

	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
	
	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public void listCities(String cities) {
		String[] cities_local = cities.split(" - ");
		for(int i = 0; i < cities_local.length; i++) {
			if(!verifyCity(cities_local[i])) {
				this.cities.add(new City(cities_local[i]));
			}
		}
	}
	
	public boolean verifyCity(String city) {
		for(int i = 0; i < this.cities.size(); i++) {
			if((!this.cities.isEmpty()) && (this.cities.get(i).getName().equals(city))) {
				return true;
			}
		}
		return false;
	}
	
	public City searchCity(String city) {
		for(int i = 0; i < this.cities.size(); i++) {
			if(cities.get(i).getName().equals(city)){
				return cities.get(i);
			}
		}
		return null;
	}

	public void listRoutes(String[] cities_names, String[] cities_distances, double cost, int demand) {
		double weight;
		Route route;
		
		for(int i = 0; i < cities_distances.length; i++) {
			weight = weighter(Integer.parseInt(cities_distances[i]), cost, demand);
			route = new Route(searchCity(cities_names[i]), searchCity(cities_names[i+1]), weight);
			if(routes.isEmpty()) {
				routes.add(route);
			}
			else {
				verifyRoute(route);
			}
			route = null;
		}
	}
	
	public double weighter(int distance, double cost, int demand) {
		double weight;
		
		weight = ((distance*100)+cost)/10000 + demand;
		
		return weight;
	}
	
	public void verifyRoute(Route route) {
		int index = route.isIn(routes);
		if(index == -1) {
			routes.add(route);
		}
		else if(routes.get(index).getWeight() > route.getWeight()) {
			routes.set(index, route);
		}
	}
	
	public Route searchRoute(String source, String destination) {
		for(int i = 0; i < routes.size(); i++) {
			if((routes.get(i).getSource().getName().equals(source)) && (routes.get(i).getDestination().getName().equals(destination))) {
				return routes.get(i);
			}
		}
		return null;
	}
	
	public double countCosts(int distance) {
		double costs;
		
		costs = (distance*3.6*4.69)+(((distance/850)*60+20)*4.13);
		
		return costs;
	}
}

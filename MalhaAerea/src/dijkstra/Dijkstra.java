package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import com.opencsv.exceptions.CsvException;
import getdata.*;
import netdatatypes.*;
import java.io.IOException;

public class Dijkstra{
	private Matrice weights;
	private ArrayList<City> open;
	private ArrayList<City> closed = new ArrayList<City>();
	private ArrayList<City> smallest_path = new ArrayList<City>();
	private ArrayList<City> neighbourhood = new ArrayList<City>();
	private ArrayList<Integer> index = new ArrayList<Integer>();
	
	public Dijkstra() {}
	
	public void initialize(String destination) throws IOException, CsvException {
		this.weights = new Matrice(destination);
		this.open = new ArrayList<City>(weights.getCities());

		this.closed.clear();
		this.smallest_path.clear();
		this.neighbourhood.clear();
		this.index.clear();
	}
	
	public void getNeighbours(String source, ArrayList<Route> routes, ArrayList<City> open){
		for(int i = 0; i < routes.size(); i++) {
			if(routes.get(i).getSource().getName().equals(source)) {
				for(int j = 0; j < open.size(); j++) {
					if(open.get(j).getName().equals(routes.get(i).getDestination().getName())) {
						neighbourhood.add(routes.get(i).getDestination());
						index.add(i);									
					}
				}
			}
		}
	}
	
	public ArrayList<City> algorithm(String destination) throws IOException, CsvException{
		this.initialize(destination);
 		City current = weights.getCities().get(0);
 		
 		current.setDistance(0);	
 		current.setLastStop(current);
 		
 		this.closed.add(current);
 		this.open.remove(0);
 		getNeighbours(weights.getCities().get(0).getName(), weights.getRoutes(), open);
 		
 		
 		for(int j = 1; j < weights.getCities().size(); j++) {
 			for(int k = 0; k < neighbourhood.size(); k++) {
 				if(weights.getCities().get(j).equals(neighbourhood.get(k))){
 					weights.getCities().get(j).setDistance(weights.getRoutes().get(index.get(k)).getWeight());
 					weights.getCities().get(j).setLastStop(current);
 				}
 			}
 			if(weights.getCities().get(j).getLastStop() != current) {
 				weights.getCities().get(j).setDistance(Integer.MAX_VALUE);
 				weights.getCities().get(j).setLastStop(null);
 			}
 		}
 		
 		while(!this.open.isEmpty()) {
 			current = this.open.get(0);
 			for(int i = 1; i < this.open.size(); i++) {		
 				if(this.open.get(i).getDistance() < current.getDistance()) {
 					current = this.open.get(i);
 				}
 			}
 			
 			this.open.remove(current);
 			this.closed.add(current);
 			this.neighbourhood.clear();
 			getNeighbours(current.getName(), weights.getRoutes(), this.open);
 			
 			
 			if(!neighbourhood.isEmpty()) {
 	 			for(int j = 0; j < neighbourhood.size(); j++) {
 	 				if(neighbourhood.get(j).getDistance() > (current.getDistance() + weights.getRoutes().get(index.get(j)).getWeight())) {
 	 					neighbourhood.get(j).setDistance(current.getDistance() + weights.getRoutes().get(index.get(j)).getWeight());
 	 					neighbourhood.get(j).setLastStop(current);
 	 				}
 	 			}
 			}
 		}	
 		
 		current = weights.getCities().get(weights.getCities().size()-1);
 		
 		smallest_path.add(current);
 		while(current != weights.getCities().get(0)) {
 			current = current.getLastStop();
 			smallest_path.add(current);
 		}
 		Collections.reverse(smallest_path);
 		return smallest_path;
	}

	public Matrice getWeights() {
		return weights;
	}

	public void setWeights(Matrice weights) {
		this.weights = weights;
	}
}
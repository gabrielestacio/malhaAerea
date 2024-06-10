package netdatatypes;

import java.util.ArrayList;

public class Route{
	private City source;
	private City destination;
	private double weight;
	
	public Route(City source, City destination, double weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public City getSource() {
		return this.source;
	}

	public void setSource(City source) {
		this.source = source;
	}

	public City getDestination() {
		return this.destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int isIn(ArrayList<Route> routes) {
		for(int i = 0; i < routes.size(); i++) {
			if(this == routes.get(i)) {
				return i;
			}
		}
		return -1;
	}
}
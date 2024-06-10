package netdatatypes;

import java.util.ArrayList;

public class City{
	private double distance;
	private String name;
	private City last_stop;
	
	public City(String name) {
		this.name = name;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public City getLastStop() {
		return last_stop;
	}
	
	public void setLastStop(City last_stop) {
		this.last_stop = last_stop;
	}
	
	public boolean isIn(ArrayList<City> cities) {
		for(int i = 0; i < cities.size(); i++) {
			if(this == cities.get(i)) {
				return true;
			}
		}
		return false;
	}
}
package HealthFreak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Graph {
	
	private static String[] conditions = Constants.conditions;
	private List<List<Integer>> graph;
	
	public Graph(){
		graph = new ArrayList<List<Integer>>();
		for (int i = 0; i<City.citiesCount; i++){
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j<City.citiesCount; j++){
				temp.add(0);
			}
			graph.add(temp);
		}
	}
	
	public void connectedTo(City[] citiesArray, String condition){
		int conditionIndex = Arrays.asList(conditions).indexOf(condition);
		List<City> cities = Arrays.asList(citiesArray);
		cities = cities.stream()
			      .filter(Objects::nonNull)
			      .collect(Collectors.toList());
		for (int i = 0; i<cities.size(); i++){
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j<cities.size(); j++){
				temp.add(0);
			}
			this.graph.add(temp);
		}
		for (int i = 0; i< this.graph.get(0).size(); i++){
			//System.out.println(cities.get(i).getTop());
			for (int j=0; j< this.graph.get(0).size(); j++){
				if (cities.get(i).getTop().contains(conditionIndex) && cities.get(j).getTop().contains(conditionIndex)){
					this.graph.get(i).set(j,1);
				}
			}
		}
	}
	public List<List<Integer>> getGraph(){
		return this.graph;
	}
}

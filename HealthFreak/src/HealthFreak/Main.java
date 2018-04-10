package HealthFreak;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;

import HealthFreak.CSVFile;
import HealthFreak.CsvParser4;
import HealthFreak.CSVFile;
import HealthFreak.City;
import HealthFreak.Graph;

// cityNmae at index 3
// population at index 17
// location at index 18
// condition at index 20
/**
 * Main Class used for reading CSV file and initialing object arrays
 * @author Faisal
 *
 */
public class Main {
	
	private static String[] conditions = Constants.conditions;
	static City[] cities; 
	/**
	 * Method used to read CSV file and initialize object arrays
	 */
	public static void main(String[]args) {
		{
			cities = new City[City.objArray.length];
			try {
				
				File csvFile = Constants.csvFile;
				CSVFile file = CsvParser4.parseFile(csvFile,  false,  ','); // parse file and store in objects
				CSVFile.toArray();
				for(int i = 1; i < City.objArray.length; i++) {
					try{
						int indexOfCity = findCity(cities, City.objArray[i].getValue(3)); // 
						String name = City.objArray[i].getValue(3);
						int population = Integer.parseInt(City.objArray[i].getValue(17));
						int condIndex = Arrays.asList(conditions).indexOf(City.objArray[i].getValue(20));
						if (cities[indexOfCity] != null){ // if city does exist in city array
							if (condIndex != -1){
								cities[indexOfCity].setCond(condIndex); // update the condition count
							}
						}else{ // otherwise create a new city
							if (!name.equals("")){
								cities[indexOfCity] = new City(name, population);
								if (condIndex != -1){
									cities[indexOfCity].setCond(condIndex);
								}
							}
						}
					}catch (Exception e) {
						System.out.println("Not valid city");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Top 3 Conditions for all cities:");
			
			for (int i =0; i<cities.length; i++){
				
				if (cities[i]!=null){
					cities[i].top_three();
					System.out.println(cities[i].getTop());
				}
			}
			System.out.println(City.citiesCount);
			cities = Arrays.copyOfRange(cities,0,City.citiesCount);
			Graph graph = new Graph();
			graph.connectedTo(cities, "DIABETES");
			System.out.println(graph.getGraph());	
		}
		
	}
	/**
	 * Method used to find where to append next city object
	 * @param cities - city object array
	 * @param city - string name of city
	 */
	public static int findCity(City[] cities, String city){ 
		for (int i =0; i<cities.length; i++){
			
			if (cities[i] == null){
				return i;
			}
			else if(city.equals(cities[i].getCity())){
				return i;
			}
		}
		return -1;
	}
}

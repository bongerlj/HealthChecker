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
public class Main {
	
	private static String[] conditions = new String[]{"ACCESS2","ARTHRITIS","BINGE","BPHIGH","BPMED","CANCER","CASTHMA","CHD","CSMOKING","DIABETES","HIGHCHOL","KIDNEY","OBESITY"};
	static City[] cities; 
	public static void main(String[]args) {
		{
			cities = new City[City.objArray.length];
			try {
				
				File csvFile = new File("ex.csv");
				CSVFile file = CsvParser4.parseFile(csvFile,  false,  ',');
				//System.out.println(file);
				CSVFile.toArray();
				
				
				
				//System.out.println(City.objArray[2].getValue(17));
				for(int i = 1; i < City.objArray.length; i++) {
					try{
						int indexOfCity = findCity(cities, City.objArray[i].getValue(3));
						String name = City.objArray[i].getValue(3);
						int population = Integer.parseInt(City.objArray[i].getValue(17));
						//Point location = new Point();
						int condIndex = Arrays.asList(conditions).indexOf(City.objArray[i].getValue(20));
						if (cities[indexOfCity] != null){
							if (condIndex != -1){
								cities[indexOfCity].setCond(condIndex);
								//cities[indexOfCity].setCond(0);
							}
						}else{
							cities[indexOfCity] = new City(name, population);
							if (condIndex != -1){
								cities[indexOfCity].setCond(condIndex);
							}
							
						}
						//
					}catch (Exception e) {
						System.out.println("Not valid city");
					}
						
					//System.out.println(City.objArray[i].getValue(20));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Top 3 Conditions for all cities:");
			
			for (int i =0; i<cities.length; i++){
				
				if (cities[i]!=null){
					cities[i].top_three();
					//System.out.println(Arrays.toString(cities[i].getCond()));
					System.out.println(cities[i].getTop());
				}
			}
			System.out.println(City.citiesCount);
			City[] citiesList = Arrays.copyOfRange(cities,0,City.citiesCount);
			System.out.println(Search.search(citiesList, "Davie").getCity());
			List<List<Integer>> graph = Graph.connectedTo(cities, "DIABETES");
			System.out.println(graph);	
		}
		
	}
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

	public static Point point(String p){
		String first;
		String second;
		for (int i=0; i<p.length(); i++){
		}
		return new Point(0,0);
		
	}
}

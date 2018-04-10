package HealthFreak;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Class City ADT that creates city objects
 * @author Group 27
 */
public class City {
	private String cityName;
	private int population;
	public static int citiesCount = 0;
	private List<Integer> top;
	private int [] cond = new int [Constants.conditions.length];
	static CSVRecord[] objArray = new CSVRecord[Constants.NumberOfRows];
	/**
	 * Constructor to construct city object
	 * @param cityName - name of city
	 * @param population - population number of city
	 */
	City(String cityName, int population){
		citiesCount+=1;
		this.cityName=cityName;
		this.population = population;
		
	}
	/**
	 * Accessor to get objarray value
	 * @return objarray
	 */
	static CSVRecord[] getArray() {
		return objArray;
	}
	/**
	 * Accessor to get city name
	 * @return cityname
	 */
	public String getCity(){
		return cityName;
	}
	/**
	 * Accessor to get conditions array
	 * @return cond
	 */
	public int [] getCond(){
		return cond;
	}
	/**
	 * Accessor to get condition at index
	 * @return cond at index n
	 */
	public int getCond(int n){
		return cond [n];
	}
	/**
	 * Mutator increments the count of the condition in index
	 * @param index in condition 
	 */
	public void setCond(int index){
		this.cond[index]+=1;
	}
	/**
	 * Method used to find value in list
	 * @return val - array of integers
	 * @param v - integer index to find
	 */
	private static int index(List<Integer> val,int v){
		if (val != null){
			if (val.contains(v)){
				return index(val, v+1);
			}
			else{
				return v;
			}
		}
		else{
			return v;
		}
	}
	/**
	 * Method used to find top 3 prevelant conditions within city
	 */
	public void top_three(){
		List<Integer> values = new ArrayList<Integer>();
		for  (int j = 0; j<3; j++){
			int largest = index(values, 0);
			
			for (int i = largest; i<this.cond.length; i++){
				//System.out.println(this.cond[i]>this.cond[largest]);
				if (this.cond[i]>this.cond[largest] && !values.contains(i)){
					largest = i;
				}
			}
			
			values.add(largest);
		}
		this.top = values;
	}
	/**
	 * Accessor to get the top 3 prevelant conditions in city
	 * @return top
	 */
	public List<Integer> getTop(){
		return this.top;
	}
}

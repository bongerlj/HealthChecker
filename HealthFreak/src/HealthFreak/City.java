package HealthFreak;
import java.io.*;

public class City {
	private int N = 25;
	
	private String cityName;
	private int population;
	private Point pos;
	private int [] cond = new int [N];
	static CSVRecord[] objArray = new CSVRecord[32];

	City(String cityName, int population){
		this.cityName=cityName;
		this.population = population;
		
	}
	
	static CSVRecord[] getArray() {
		return objArray;
	}
	
	private String getCity(){
		return cityName;
	}
	public int [] getCond(){
		return cond;
	}
	public int getCond(int n){
		return cond [n];
	}
	public void setCond(int [] cond){
		this.cond=cond;
	}
	public void setPos(String l){
		//will have to loop through in main program b\c there is no random access to a single line in file
		String[] posString = l.split(",");
		pos = new Point (Integer.parseInt(posString[0]), Integer.parseInt(posString[1]));
	}
	public Point getPos(){
		return pos;
	}
}

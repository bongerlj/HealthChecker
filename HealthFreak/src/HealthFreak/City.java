package HealthFreak;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class City {
	private int N = 25;
	
	private String cityName;
	private int population;
	private Point pos;
	private List<Integer> top;
	private int [] cond = new int [N];
	static CSVRecord[] objArray = new CSVRecord[239];

	City(String cityName, int population){
		this.cityName=cityName;
		this.population = population;
		
	}
	
	static CSVRecord[] getArray() {
		return objArray;
	}
	
	public String getCity(){
		return cityName;
	}
	public int [] getCond(){
		return cond;
	}
	public int getCond(int n){
		return cond [n];
	}
	public void setCond(int index){
		this.cond[index]+=1;
	}
	public void setPos(String l){
		//will have to loop through in main program b\c there is no random access to a single line in file
		String[] posString = l.split(",");
		pos = new Point (Integer.parseInt(posString[0]), Integer.parseInt(posString[1]));
	}
	public Point getPos(){
		return pos;
	}
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
	
	public List<Integer> getTop(){
		return this.top;
	}
}

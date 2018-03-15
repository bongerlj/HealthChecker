package health_checker;

import java.util.ArrayList;
import java.util.List;

public class CSVRecord {
	
	private List<String> data;
	
	public CSVRecord() {
		data = new ArrayList<String>();
	}
	
	public void addValue(String value) {
		data.add(value);
	}
	
	public void removeValue(String value) {
		data.remove(value);
	}
	
	public void removeValue(int index) {
		data.remove(index);
	}
	
	public String getValue(int index) {
		return data.get(index);
	}
	
	public List<String> getData() {
		return data;
	}
	
	public String toString() {
		String string = "CSVRecord{";
		
		for(String value : data) {
			string += value + " ; ";
		}
		
		return string.substring(0, string.length() - 3) + "}";
	}

}

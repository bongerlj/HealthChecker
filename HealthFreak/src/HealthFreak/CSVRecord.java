package HealthFreak;

import java.util.ArrayList;
import java.util.List;
/**
 * CSVRecord class to keep records in objects
 * @author Group 27
 *
 */
public class CSVRecord {
	
	private List<String> data;
	/**
	 * Constructor to construct the CSV object
	 */
	public CSVRecord() {
		data = new ArrayList<String>();
	}
	/**
	 * Mutator adds new record
	 * @param value - record to add
	 */
	public void addValue(String value) {
		data.add(value);
	}
	/**
	 * Mutator removes new record
	 * @param value - record to rmeove
	 */
	public void removeValue(String value) {
		data.remove(value);
	}
	/**
	 * Mutator remove new record
	 * @param value - record to remove by index
	 */
	public void removeValue(int index) {
		data.remove(index);
	}
	/**
	 * Accessor gets record at index
	 * @return data
	 */
	public String getValue(int index) {
		return data.get(index);
	}
	/**
	 * Accessor gets record at index
	 * @return data
	 */
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

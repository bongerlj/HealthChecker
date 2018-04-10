package HealthFreak;

import java.util.ArrayList;
import java.util.List;
import HealthFreak.City;
/**
 * CSVFile class meant to store row values in csv file
 */
public class CSVFile {
	
	private String path;
	private String name;
	
	private CSVRecord header;
	private static List<CSVRecord> records;
	/**
	 * Constructor to construct CSVFile object
	 * @param path - path to csvfile
	 * @param name - name of csv file
	 */
	public CSVFile(String path, String name) {
		this.path = path;
		this.name = name;
		
		this.records = new ArrayList<CSVRecord>();
	}
	/**
	 * Mutator to add record
	 * @param record - record to store
	 */
	public void addRecord(CSVRecord record) {
		records.add(record);
	}
	/**
	 * Mutator to remove record
	 * @param record - record to remove by object
	 */
	public void removeRecord(CSVRecord record) {
		records.remove(record);
	}
	/**
	 * Mutator to remove record
	 * @param record - record to remove by index
	 */
	public void removeRecord(int index) {
		records.remove(index);
	}
	/**
	 * Accessor to get record
	 * @return record - record to get
	 */
	public static CSVRecord getRecord(int index) {
		return records.get(index);
	}
	/**
	 * Accessor to get header
	 * @return header - header to get
	 */
	public CSVRecord getHeader() {
		return header;
	}
	/**
	 * Mutator to set record
	 * @param header - header to set
	 */
	public void setHeader(CSVRecord header) {
		this.header = header;
	}
	/**
	 * Accessor to get path
	 * @return path - path to get
	 */
	public String getPath() {
		return path;
	}
	/**
	 * Accessor to get name
	 * @return name - name to get
	 */
	public String getName() {
		return name;
	}
	/**
	 * Accessor to get records list
	 * @return records - list of records to get
	 */
	public List<CSVRecord> getRecords() {
		return records;
	}
	/**
	 * Accessor to CSVRecord 
	 * @return objArray 
	 */
	public static CSVRecord[] toArray() {
		City.getArray();
		for(int i = 0; i < records.size(); i++) {
			City.objArray[i] = getRecord(i);
		}
		return City.objArray;
	}
	/**
	 * Accessor to get string value of CSVRecord 
	 * @return string value of CSVRecord 
	 */
	public String toString() {
		String string = "CSVFile [path:" + path + ", name=" + name + "]\nHeader{" + header + "}\n{\n";
		
		for(CSVRecord record : records) {
			string += record + "\n";
		}
		
		return string + "}";
		
	}

}

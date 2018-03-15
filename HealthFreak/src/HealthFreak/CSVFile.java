package HealthFreak;

import java.util.ArrayList;
import java.util.List;

public class CSVFile {
	
	private String path;
	private String name;
	
	private CSVRecord header;
	private List<CSVRecord> records;
	
	public CSVFile(String path, String name) {
		this.path = path;
		this.name = name;
		
		this.records = new ArrayList<CSVRecord>();
	}
	
	public void addRecord(CSVRecord record) {
		records.add(record);
	}
	
	public void removeRecord(CSVRecord record) {
		records.remove(record);
	}
	
	public void removeRecord(int index) {
		records.remove(index);
	}
	
	public CSVRecord getRecord(int index) {
		return records.get(index);
	}

	public CSVRecord getHeader() {
		return header;
	}

	public void setHeader(CSVRecord header) {
		this.header = header;
	}

	public String getPath() {
		return path;
	}

	public String getName() {
		return name;
	}

	public List<CSVRecord> getRecords() {
		return records;
	}
	
	public String toString() {
		String string = "CSVFile [path:" + path + ", name=" + name + "]\nHeader{" + header + "}\n{\n";
		
		for(CSVRecord record : records) {
			string += record + "\n";
		}
		
		return string + "}";
		
	}

}

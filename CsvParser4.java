package health_checker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class CsvParser4 {
	
	public static CSVFile parseFile(File csvFile, boolean hasHeader, char delim) throws Exception {
		
		CSVFile file = new CSVFile(csvFile.getPath(), csvFile.getName());
		
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		
		if(hasHeader) {
			String headerLine = br.readLine();
			
			CSVRecord header = processRecord(headerLine, delim);
			file.setHeader(header);	
		}
		
		String line;
		while((line = br.readLine()) != null) {
			CSVRecord record = processRecord(line, delim);
			file.addRecord(record);
		}
		br.close();
		return file;
	}
	
	private static CSVRecord processRecord(String line, char delim) {
		if(line == null || line.equals("")) {
			return null;
		}
		
		CSVRecord record = new CSVRecord();
		boolean inQuotes = false;
		
		char[] chars = line.toCharArray();
		StringBuffer value = new StringBuffer();
		
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '\"') {
				if((i + 1) < chars.length && chars[i + 1] == '\"') {
					value.append("\"");
				} else {
					inQuotes = !inQuotes;
				}
			} else if(chars[i] == delim) {
				if(inQuotes) {
					value.append(delim);
				} else {
					record.addValue(value.toString());
					value = new StringBuffer();
				}
			} else {
				value.append(chars[i]);
			}
		}
		record.addValue(value.toString());
		return record;
	}
	
}

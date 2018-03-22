package HealthFreak;

import java.io.File;
import HealthFreak.CSVFile;
import HealthFreak.CsvParser4;
import HealthFreak.CSVFile;

public class Main {
	
	public static void main(String[]args) {
		{
			try {
				File csvFile = new File("ex.csv");
				CSVFile file = CsvParser4.parseFile(csvFile,  true,  ',');
				//System.out.println(file);
				CSVFile.toArray();
				for(int i = 0; i < City.objArray.length; i++) {
					System.out.println(City.objArray[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

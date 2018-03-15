package HealthFreak;

import java.io.File;
import HealthFreak.CSVFile;
import HealthFreak.CsvParser4;

public class Main {
	
	public static void main(String[]args) {
		{
			try {
				File csvFile = new File("data.csv");
				CSVFile file = CsvParser4.parseFile(csvFile,  false,  ',');
				System.out.println(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

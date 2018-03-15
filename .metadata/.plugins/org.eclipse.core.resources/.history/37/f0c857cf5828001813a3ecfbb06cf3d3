package health_checker;

import java.io.File;
import health_checker.CSVFile;
import health_checker.CsvParser4;

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

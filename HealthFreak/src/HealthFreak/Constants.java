package HealthFreak;

import java.io.File;
/**
 * Constants class used to store constants
 */
public class Constants {
	
	public static String[] conditions = new String[]{"ACCESS2","ARTHRITIS","BINGE","BPHIGH","BPMED","CANCER","CASTHMA","CHD","CSMOKING","DIABETES","HIGHCHOL","KIDNEY","OBESITY"};
	
	// change the following for faster testing
	
	//public static File csvFile = new File("data/500_Cities__Local_Data_for_Better_Health__2017_release.csv");
	public static File csvFile = new File("data/ex.csv");
	
	
	public static int NumberOfRows = 900000;
}

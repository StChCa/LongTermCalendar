package Calendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class SaveUtility {
	
	static File savePathFile;
	public static String saveLoc;
	
	public static boolean hasSaveFile() {
		// make a new desktop folder to hold info
		savePathFile = new File(System.getProperty("user.home") + "/Desktop/LTCalendar/savePath.txt");
		File parentFolder = new File(System.getProperty("user.home") + "/Desktop/LTCalendar");
		
		// if the save path doesnt exist make it and prompt for user to give path to save everything
		if (!savePathFile.exists()) {
			if(!parentFolder.exists()){
				parentFolder.mkdirs();
			}
			pointToSaveLocation();
			return false;
		} else{
			// if the save path does exist, then read the file and udate stuff
			try{
				BufferedReader br = new BufferedReader(new FileReader(savePathFile));
				try {
				    StringBuilder sb = new StringBuilder();
				    String line = br.readLine();

				    while (line != null) {
				        sb.append(line);
				        sb.append(System.lineSeparator());
				        line = br.readLine();
				    }
				    saveLoc = sb.toString();
				} finally {
				    br.close();
				    System.out.println(saveLoc);
				}
			} catch(IOException e){
				e.printStackTrace();
			}
			return true;
		}
	}
	
	public static void pointToSaveLocation(){

		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter path to where Save files are located:");
		String userInputPath = reader.next(); // Scans the next token of the input as an int.
		//once finished
		reader.close();		
		
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(savePathFile)));
		    writer.write(userInputPath);
		    System.out.println("Value written to file: " + userInputPath);
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	}
	
	public static void load(){
		System.out.println("This will be where we load from the file");
	}
	
	public static void saveEmployeeList(EmployeeList emps){
		
		String formattedCsv = emps.toCsv();
		
		writeCsv(formattedCsv, saveLoc);
		
		
	}
	
	public static boolean writeCsv(String formattedCsv, String fileLocation){
		
		// TODO create the file if it doesn't exist then write to it
		
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(fileLocation)));
		    writer.write(formattedCsv);
		    System.out.println("Value written to file: " + formattedCsv);
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
		return true;
	}
	
}

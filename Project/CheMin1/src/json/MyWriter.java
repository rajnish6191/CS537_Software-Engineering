package json;


import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyWriter {

	public MyWriter(Object myObject, String  groupNumber) {
		
		// groupNumber is your group number
		
		// This file is saved into the source folder for this Java Project
		String myFilePath = groupNumber + ".json";
		
		// json is used to create a json object that is spaced nicely
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Instantiate the writer since we're writing to a JSON file.
		FileWriter writer = null;
		try {
			writer = new FileWriter(myFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Object is converted to a JSON String
		String jsonString = gson.toJson(myObject);
		
		// Write the file
		try {
			writer.write(jsonString);
			System.out.println(myFilePath + " written to file.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Close the Writer
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

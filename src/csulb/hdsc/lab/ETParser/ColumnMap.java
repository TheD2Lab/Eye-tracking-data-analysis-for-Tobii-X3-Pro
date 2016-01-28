package csulb.hdsc.lab.ETParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class ColumnMap {
	HashMap<String,Integer> qualities_map = new HashMap<>();
	String line;
	public ColumnMap( String map_location ) {
		
		File data = new File( map_location ); 
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader( data );

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
           
    
            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
            	String[] split_line = line.split("\t");
            	qualities_map.put( split_line[0] , Integer.parseInt( split_line[1] ) );
            	
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                data.getName() + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + data.getName() + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	
	}
	
	public HashMap<String,Integer> retriveMap() {
		return qualities_map;
	}
}

package csulb.hdsc.lab.ETParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//import csulb.hdsc.lab.data.User;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class ETParser {

	private String line;
	private HashMap<Integer,SummaryStatistics> summaries;
	private File data;
	private HashMap<String,Integer> qualities_map;
	private HashMap<Integer,ArrayList<String>> raw_data;
	
	
	public ETParser(String file_location ) {
		
		summaries = new HashMap<>();

		data = new File( file_location ); 
		qualities_map = new HashMap<>();
		raw_data = new HashMap<>();
		
		parse();
		
	}
	
	public void parse() {
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader( data );

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            String[] header_line;
            if ( line != null ) {
            	header_line = line.split("\t");
            	//System.out.println( header_line.length );
            	
            	header_line[0] = header_line[0].substring(3, header_line[0].length() );
            	
            	for ( int i = 0 ; i < header_line.length; i++ ) {
            		//System.out.println( header_line[i] + ": " + i );
            		qualities_map.put( header_line[i], i);
            		
            		// Initial array for all column data
					raw_data.put( i, new ArrayList<>() );

            	}
            	
            	// remove weird encoding from first str in header_line array
            	
            	int leftValidity = qualities_map.get( "ValidityLeft" ); 
    			int rightValidity = qualities_map.get( "ValidityRight" );     			
    			int lineCount = 1;
            	while((line = bufferedReader.readLine()) != null) {
            		lineCount++;
            		String[] split_line = line.split("\t");
            		//System.out.println( "length: " + split_line.length );
//            		if( split_line.length == 85 ) {
//            			System.out.println("Pause");
//            		}
//            		System.out.println( Arrays.toString( split_line ) );
            		
            		// this block skips InstructionStart, Instruction End Lines, which are shorter than normal lines in length
//            		if ( split_line.length < header_line.length - 3 ) {
//            			continue;
//            		}
            		
            		for ( int i = 0 ; i<header_line.length;i++) {
            			
        				int columnIdx = qualities_map.get( header_line[i] );

            			if ( i > split_line.length - 1 || split_line.length - 1 < leftValidity || split_line.length - 1 < rightValidity ) {
            				raw_data.get( columnIdx ).add("N/A");
            				continue;
            			}
        				
//            			int leftValidity = qualities_map.get( "ValidityLeft" ); 
//            			int rightValidity = qualities_map.get( "ValidityRight" ); 
            			//System.out.println(i);
            			//System.out.println( header_line[i] );
            			if ( Integer.parseInt(split_line[leftValidity]) == 0 && Integer.parseInt(split_line[rightValidity]) == 0 ) {
            				
            				
            				if ( !split_line[i].equals("") && split_line[i].matches("^\\d*\\.?\\d*$") ) { 
            					if ( !summaries.containsKey( columnIdx  )) {
            						summaries.put( columnIdx , new SummaryStatistics() );
            					}

            					summaries.get( columnIdx ).addValue( Double.parseDouble( split_line[i] ) );
            				}

            				raw_data.get( columnIdx ).add( split_line[i] );
            			} else {
            				raw_data.get( columnIdx ).add("N/A");
            			}

            		}
            	} 
            	System.out.println("LINECOUNT: " + lineCount );
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
	
	public SummaryStatistics getDescSummaryOfKthColumn( int k ) {
		return summaries.get(k);
	}
	
	public ArrayList<String> getRawColumnData( int idx ) {
		return raw_data.get(idx);
	}
	
	
	public void printColumn( int columnIdx ) {
		ArrayList<String> columnData = raw_data.get( columnIdx );
		ArrayList<String> validLeftData = raw_data.get( qualities_map.get("ValidityLeft") );
		ArrayList<String> validRightData = raw_data.get( qualities_map.get("ValidityRight") );
		Boolean empty = false;
		for ( int i = 0 ; i < columnData.size(); i++ ) {
			System.out.println( columnData.get(i) + "  " + validLeftData.get(i) + "  " + validRightData.get(i) );
			if ( columnData.get(i).equals("") ) {
				empty = true;
			}
		}
		System.out.println( "empty: " + empty );
		
	}
	
	public HashMap<String,Integer> getMap() {
		return qualities_map;
	}
	
}

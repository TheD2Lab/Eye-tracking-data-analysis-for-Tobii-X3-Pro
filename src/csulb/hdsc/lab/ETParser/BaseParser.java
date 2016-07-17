package csulb.hdsc.lab.ETParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public abstract class BaseParser {
	
	protected String line;
	protected HashMap<Integer,SummaryStatistics> summaries;
	protected File data;
	protected HashMap<String,Integer> attributes_map;
	protected HashMap<Integer,ArrayList<String>> raw_data;
	
	protected int invalid_rows;
	protected int valid_rows;
	
	public BaseParser(String file_location ) {
		
		summaries = new HashMap<>();

		data = new File( file_location ); 
		attributes_map = new HashMap<>();
		raw_data = new HashMap<>();
		
		//parse();
		
	}

	public BaseParser() {
		attributes_map = new HashMap<>();
		raw_data = new HashMap<>();
		summaries = new HashMap<>();

	}


	public abstract void parse();

	public int getInvalidRows() {
		return invalid_rows;
	}
	
	public int getValidRows() {
		return valid_rows;
	}
	
	public HashMap<Integer, ArrayList<String>> getRawData() {
		return raw_data;
	}
	
	public SummaryStatistics getDescSummaryOfKthColumn( int k ) {
		return summaries.get(k);
	}
	
	public ArrayList<String> getRawColumnData( int idx ) {
		return raw_data.get(idx);
	}
	
	
	public void printColumn( int columnIdx ) {
		ArrayList<String> columnData = raw_data.get( columnIdx );
		ArrayList<String> validLeftData = raw_data.get( attributes_map.get("ValidityLeft") );
		ArrayList<String> validRightData = raw_data.get( attributes_map.get("ValidityRight") );
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
		return attributes_map;
	}
}

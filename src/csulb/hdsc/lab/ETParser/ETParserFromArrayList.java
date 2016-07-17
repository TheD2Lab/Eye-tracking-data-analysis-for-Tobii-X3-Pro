package csulb.hdsc.lab.ETParser;


import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class ETParserFromArrayList extends BaseParser {

	String[] header_line;
	ArrayList<String[]> lines;
	public ETParserFromArrayList( String[] header, ArrayList<String[]> arrayList){
		super();

		header_line = header;
		this.lines = arrayList;
		
		parse();
	}

	@Override
	public void parse() {
		Iterator<String[]> iter = lines.iterator();
		for ( int i = 0 ; i < header_line.length; i++ ) {
			//System.out.println( header_line[i] + ": " + i );
			attributes_map.put( header_line[i], i);

			// Initial array for all column data
			raw_data.put( i, new ArrayList<>() );

		}


		int leftValidityIdx = attributes_map.get( "ValidityLeft" ); 
		int rightValidityIdx = attributes_map.get( "ValidityRight" );     			
		int lineCount = 0;

		while( iter.hasNext() ) {
			lineCount++;
			String[] split_line = iter.next();
			//System.out.println( "length: " + split_line.length );
			//            		if( split_line.length == 85 ) {
			//            			System.out.println("Pause");
			//            		}
			//            		System.out.println( Arrays.toString( split_line ) );

			// this block skips InstructionStart, Instruction End Lines, which are shorter than normal lines in length
			//            		if ( split_line.length < header_line.length - 3 ) {
			//            			continue;
			//            		}

			// Set Initial validity to be false till it is checked to be 0s
			int leftValidity = - 1;
			int rightValidity = - 1;

			if ( leftValidityIdx <= split_line.length && rightValidityIdx <= split_line.length ) {
				leftValidity =  Integer.parseInt(split_line[leftValidityIdx]);
				rightValidity = Integer.parseInt(split_line[rightValidityIdx]);

				if ( leftValidity != 0 && rightValidity != 0 ) {
					invalid_rows++;
				} else {
					valid_rows++;
				}

			} else {
				invalid_rows++;
			}

			if ( leftValidity == -1 || rightValidity == -1 ) {
				continue;
			}

			// Notice we are iterating over the entire set of attributes. Some rows will not have all attributes output.
			for ( int i = 0 ; i<header_line.length;i++) {

				int columnIdx = attributes_map.get( header_line[i] );


				// Adding "N/A" keeps the data within the same row to be aligned among different columns. 
				/* index i cannot be greater than the split line, add "N/A" for any index pass this point ( happens for short row ) 
				 *  all rows that do not have validity for right and left eye will instead add N/A
				 */
				//            			if ( i > split_line.length - 1 || split_line.length - 1 < leftValidityIdx || split_line.length - 1 < rightValidityIdx ) {
				if 	( i > split_line.length - 1) {
					raw_data.get( columnIdx ).add("N/A");
					continue;
				}





				if ( leftValidity == 0 && rightValidity  == 0 ) {


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
//		System.out.println("LINECOUNT: " + lineCount );
//		System.out.println("ValidRows: " + valid_rows );
//		System.out.println("InvalidRows: " + invalid_rows );

	}

}


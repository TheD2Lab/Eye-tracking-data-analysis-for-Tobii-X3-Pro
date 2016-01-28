package csulb.hdsc.lab.implementation;

import java.util.ArrayList;

public class PupilAvg implements Implementation {

	@Override
	// Pupil Average data can be either -1.00 or an empty string. Both of which will be excluded.
	public double compute(ArrayList<String> data_array) {
		double sum = 0;
		int count = 0;
//		System.out.println( "ArraySize: " + data_array.size() );
		for ( int i = 0 ; i < data_array.size(); i++ ) {
			String str_val = data_array.get(i);
			if ( !str_val.equals("") && !str_val.equals("N/A") ){
				double val = Double.parseDouble( data_array.get(i) );
				if ( val != -1.00 ) {
					sum+= Double.parseDouble( data_array.get(i) );
					count++;
				}
			}
		}
		System.out.println( sum/count );
		return sum/count;
	}

}

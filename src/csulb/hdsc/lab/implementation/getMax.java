package csulb.hdsc.lab.implementation;

import java.util.ArrayList;

public class getMax implements DataColumnImplementation {

	@Override
	public double compute(ArrayList<String> data_array) {
		// TODO Auto-generated method stub
		Double max = (double) 0;
		for ( int i = 0 ; i < data_array.size(); i++ ) {
			String str = data_array.get(i);
			if ( str.equals("") || str.equals("N/A") ) {
				continue;
			}
			Double val = Double.parseDouble(data_array.get(i));
			if ( val > max ) {
				max = val;
			}
		}
		
		return max;
	}

}

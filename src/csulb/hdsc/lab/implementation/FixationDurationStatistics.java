package csulb.hdsc.lab.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import csulb.hdsc.lab.datastructures.Median;

public class FixationDurationStatistics extends Analysis {
	
	private Median<Integer> median;
	
	
	public FixationDurationStatistics( HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ){
		super();
		this.summary = new SummaryStatistics();
		median = new Median<>();
		crossColumnCompute( raw_data, map);
		
	}


	@Override
	protected void crossColumnCompute(HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ) {

		ArrayList<String> fixationNumData = raw_data.get( map.get("GazeEventType") );
		ArrayList<String> gazeEventDurationData = raw_data.get( map.get("GazeEventDuration") );

		for ( int i = 0 ; i < fixationNumData.size(); i++ ) {
			String fix_str = fixationNumData.get(i);
			if ( fix_str.equals("Fixation") ) {
				String duration_str = gazeEventDurationData.get(i);
				if ( duration_str.equals("") || duration_str.equals("N/A") )  {
					continue;
				}
				Integer val = Integer.parseInt( duration_str );
				median.add( val );
				summary.addValue(val);

			}
		}
		
	}
	
	public double getMean(){
		return summary.getMean();
	}
	
	public long getN(){
		return summary.getN();
	}
	
	public double getStdev() {
		return summary.getStandardDeviation();
	}
	
	public double getMax() {
		return summary.getMax();
	}
	
	public double getMin() {
		return summary.getMin();
	}
	
	public double getMedian() {
		return median.compute();
	}
	
	public double getSum(){
		return summary.getSum();
	}
	
	
	
	

}

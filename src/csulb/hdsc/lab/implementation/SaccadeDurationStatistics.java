package csulb.hdsc.lab.implementation;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import csulb.hdsc.lab.datastructures.Median;


public class SaccadeDurationStatistics extends Analysis {

private Median<Double> median;
	
	
	public SaccadeDurationStatistics( HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ){

		super();
		this.summary = new SummaryStatistics();
		median = new Median<>();
		crossColumnCompute( raw_data, map);
		
	}


	@Override
	protected void crossColumnCompute(HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ) {
		
		ArrayList<String> fixationEventData = raw_data.get( map.get("GazeEventType") );
		ArrayList<String> fixationNumData = raw_data.get( map.get("SaccadeIndex") );
		ArrayList<String> gazeEventDurationData = raw_data.get( map.get("GazeEventDuration") );
		

		
		int prevFixNum = 0; 
		int curFixNum;
		for ( int i = 0 ; i < fixationEventData.size(); i++ ) {
			
			String fix_str = fixationEventData.get(i);
			if ( fix_str.equals("Saccade") && ( curFixNum = Integer.parseInt( fixationNumData.get(i)) ) != prevFixNum  ) {
				String duration_str = gazeEventDurationData.get(i);
				if ( duration_str.equals("") || duration_str.equals("N/A") )  {
					continue;
				}
				prevFixNum = curFixNum;
				Double val = Double.parseDouble( duration_str );
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

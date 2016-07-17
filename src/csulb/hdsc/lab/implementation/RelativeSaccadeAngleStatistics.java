package csulb.hdsc.lab.implementation;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import csulb.hdsc.lab.datastructures.Median;

public class RelativeSaccadeAngleStatistics extends Analysis {
	
	private Median<Double> median;
	
	public RelativeSaccadeAngleStatistics( HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ){
		super();
		this.summary = new SummaryStatistics();
		median = new Median<>();
		crossColumnCompute( raw_data, map);
		
	}
	
	@Override
	protected void crossColumnCompute(HashMap<Integer, ArrayList<String>> raw_data, HashMap<String, Integer> map) {
		
		ArrayList<String> fixationEventData = raw_data.get( map.get("GazeEventType") );
		ArrayList<String> fixationNumData = raw_data.get( map.get("FixationIndex") );
		ArrayList<String> AbsAngleData = raw_data.get( map.get("RelativeSaccadicDirection") );
		

		
		int prevFixNum = 0; 
		int curFixNum;
		for ( int i = 0 ; i < fixationEventData.size(); i++ ) {
			
			String fix_str = fixationEventData.get(i);
			if ( fix_str.equals("Fixation") && ( curFixNum = Integer.parseInt( fixationNumData.get(i)) ) != prevFixNum  ) {
				String angle_str = AbsAngleData.get(i);
				// Take out empty or null data in the data column.
				if ( angle_str.equals("") || angle_str.equals("N/A") )  {
//					System.out.println("HERE i: " + i );
					continue;
				}
				prevFixNum = curFixNum;
				Double val = Double.parseDouble( angle_str );
				median.add( val );
				summary.addValue(val);
			}
		}
		
	}
	

	@Override
	public long getN() {
		return summary.getN();
	}

	@Override
	public double getMean() {
		return summary.getMean();
	}

	@Override
	public double getStdev() {
		return summary.getStandardDeviation();
	}

	@Override
	public double getMax() {
		return summary.getMax();
	}

	@Override
	public double getMin() {
		return summary.getMin();
	}

	@Override
	public double getMedian() {
		return median.compute();

	}

	@Override
	public double getSum() {
		return summary.getSum();
	}

}

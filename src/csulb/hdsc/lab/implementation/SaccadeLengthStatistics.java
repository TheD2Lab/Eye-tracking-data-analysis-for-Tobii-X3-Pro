package csulb.hdsc.lab.implementation;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import csulb.hdsc.lab.datastructures.Median;
import csulb.hdsc.lab.datastructures.OneSaccade;
import csulb.hdsc.lab.datastructures.Point;

public class SaccadeLengthStatistics extends Analysis {
private Median<Double> median;
	
	
	public SaccadeLengthStatistics( HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ){
		super();
		this.summary = new SummaryStatistics();
		median = new Median<>();
		crossColumnCompute( raw_data, map);
		
	}


	@Override
	protected void crossColumnCompute(HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ) {
		
		ArrayList<String> saccadeEventData = raw_data.get( map.get("GazeEventType") );
		ArrayList<String> saccadeNumData = raw_data.get( map.get("SaccadeIndex") );
		ArrayList<String> eyeXPos = raw_data.get( map.get("GazePointX (ADCSpx)") );
		ArrayList<String> eyeYPos = raw_data.get( map.get("GazePointY (ADCSpx)") );
		
		int prevSacNum = 0; 
		int curSacNum;
		OneSaccade cur_saccade = null;
		
		for ( int i = 0 ; i < saccadeEventData.size(); i++ ) {
			String fix_str = saccadeEventData.get(i);
			if ( fix_str.equals("Saccade") ) {
				if ( ( curSacNum = Integer.parseInt( saccadeNumData.get(i)) ) != prevSacNum ) {
					if ( cur_saccade == null ) {
						cur_saccade = new OneSaccade();
					} else {
						if ( cur_saccade.getNPoints() > 1 ) {
							summary.addValue( cur_saccade.getTotalLength() );
						}
						median.add( cur_saccade.getTotalLength() );
						cur_saccade = new OneSaccade();
					}
					
				}
				cur_saccade.add( new Point( Double.parseDouble( eyeXPos.get(i) ) , Double.parseDouble( eyeYPos.get(i) ) ) );
				prevSacNum = curSacNum;

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

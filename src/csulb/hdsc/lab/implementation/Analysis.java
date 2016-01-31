package csulb.hdsc.lab.implementation;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public abstract class Analysis {
	public SummaryStatistics summary; 
	protected abstract void crossColumnCompute( HashMap<Integer, ArrayList<String>> raw_data, HashMap<String,Integer> map ); 
	public abstract long getN();
	public abstract double getMean();
	public abstract double getStdev();
	public abstract double getMax();
	public abstract double getMin();
	public abstract double getMedian();
	public abstract double getSum();

}

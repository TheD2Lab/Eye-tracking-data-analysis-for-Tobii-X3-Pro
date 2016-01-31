package csulb.hdsc.lab.data;

import java.util.ArrayList;
import java.util.HashMap;

import csulb.hdsc.lab.implementation.Analysis;
import csulb.hdsc.lab.implementation.DataColumnImplementation;
import csulb.hdsc.lab.implementation.FixationDurationStatistics;

public class Fixations {
	
	private int total_num;
	private double sum_duration;
	private double mean_duration;
	private double median_duration;
	private double StDev_duration;
	private double min_duration;
	private double max_duration;
	public Fixations(){};
	
	
	public double getSumDuration(){
		return sum_duration;
	}
	
	public int getN() {
		return total_num;
	}
	
	public void setN( ArrayList<String> data , DataColumnImplementation i ) {
		total_num = (int) i.compute(data);
	}
	
	public void setSumDuration ( Analysis a ) {
		sum_duration = a.getSum();
	}
	
	public void setMeanDuration( Analysis a ) {
		mean_duration = a.getMean();
	}
	
	public void setStDev( Analysis a ) {
		StDev_duration = a.getStdev();
	}
	
	public void setMinDuration( Analysis a ) {
		min_duration = a.getMin();
	}
	
	public void setMaxDuration( Analysis a ) {
		max_duration = a.getMax();
	}
	
	public void setMedian( Analysis a ) {
		median_duration = a.getMedian();
	}
	
	@Override
	public String toString(){
		
		String output = "";
		output += "Number of Fixations: " + total_num;
		output += "\nSum of durations: " + sum_duration;
		output += "\nMean of durations: " + mean_duration;
		output += "\nMedian of durations: " + median_duration;
		output += "\nMax of durations: " + max_duration;
		output += "\nMin of durations: " + min_duration;
		output += "\nStandard Devivation of durations: " + StDev_duration;

		return output;
	}
	
	
}

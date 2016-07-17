package csulb.hdsc.lab.data;

import java.util.ArrayList;

import org.simpleframework.xml.Element;

import csulb.hdsc.lab.implementation.Analysis;
import csulb.hdsc.lab.implementation.DataColumnImplementation;

public class Fixations {
	@Element
	private int total_num;
	@Element
	private double sum_duration;
	@Element
	private double mean_duration;
	@Element
	private double median_duration;
	@Element
	private double StDev_duration;
	@Element
	private double min_duration;
	@Element
	private double max_duration;
	public Fixations(){};
	
	public double getSum_duration() {
		return sum_duration;
	}


	public double getMean_duration() {
		return mean_duration;
	}


	public double getMedian_duration() {
		return median_duration;
	}


	public double getStDev_duration() {
		return StDev_duration;
	}


	public double getMin_duration() {
		return min_duration;
	}


	public double getMax_duration() {
		return max_duration;
	}


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
	
	public void setStDevDuration( Analysis a ) {
		StDev_duration = a.getStdev();
	}
	
	public void setMinDuration( Analysis a ) {
		min_duration = a.getMin();
	}
	
	public void setMaxDuration( Analysis a ) {
		max_duration = a.getMax();
	}
	
	public void setMedianDuration( Analysis a ) {
		median_duration = a.getMedian();
	}
	
	public void setTotalN( Analysis a ) {
		total_num = (int) a.getN();
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

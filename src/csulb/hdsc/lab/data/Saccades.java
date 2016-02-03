package csulb.hdsc.lab.data;

import csulb.hdsc.lab.implementation.Analysis;

public class Saccades {

	private int total_num;
	private double sum_length;
	private double mean_length;
	private double median_length;
	private double StDev_length;
	private double min_length;
	private double max_length;
	private double sum_duration;
	private double mean_duration;
	private double median_duration;
	private double StDev_duration;
	private double min_duration;
	private double max_duration;
	
	
	public double getSumDuration(){
		return sum_duration;
	}
	
	public void setTotalN( Analysis a ) {
		total_num = (int)a.getN();
	}
	
	public void setSumLength( Analysis a ) {
		sum_length = a.getSum();
	}

	public void setMeanLength( Analysis a ) {
		mean_length = a.getMean();
	}
	
	public void setMedianLength( Analysis a ) {
		median_length = a.getMedian();
	}
	
	public void setStDev( Analysis a ) {
		StDev_length = a.getStdev();
	}
	
	public void setMinLength( Analysis a ) {
		min_length = a.getMin();
	}
	
	public void setMaxLength( Analysis a ) {
		max_length = a.getMax();
	}
	
	public void setSumDuration( Analysis a ) {
		sum_duration = a.getSum();
	}
	
	public void setMeanDuration( Analysis a ) {
		mean_duration = a.getMean();
	}
	
	public void setMedianDuration( Analysis a ) {
		median_duration = a.getMedian();
	}
	
	public void setStDevDuration( Analysis a ) {
		StDev_duration = a.getStdev();
	}
	
	public void setMaxDuration( Analysis a ) {
		max_duration = a.getMax();
	}
	
	public void setMinDuration( Analysis a ) {
		min_duration = a.getMin();
	}
	
	
	
	
	@Override
	public String toString(){
		
		String output = "";
		output += "Number of Saccades: " + total_num;
		output += "\nSum of lengths: " + sum_length;
		output += "\nMean of lengths: " + mean_length;
		output += "\nMedian of lengths: " + median_length;
		output += "\nMax of lengths: " + max_length;
		output += "\nMin of lengths: " + min_length;
		output += "\nStandard Devivation of lengths: " + StDev_length;
		output += "\nSum of durations: " + sum_duration;
		output += "\nMean of durataion: " + mean_duration;
		output += "\nMedian of durations: " + median_duration;
		output += "\nMax of durations: " + max_duration;
		output += "\nMin of durations: " + min_duration;
		output += "\nStandard Devivation of durations: " + StDev_duration;

		return output;
	}
	
}

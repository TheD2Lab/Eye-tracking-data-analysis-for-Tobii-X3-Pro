package csulb.hdsc.lab.data;

import org.simpleframework.xml.Element;

import csulb.hdsc.lab.implementation.Analysis;

public class Saccades {
	
	@Element
	private int total_num;
	@Element
	private double sum_length;
	@Element
	private double mean_length;
	@Element
	private double median_length;
	@Element
	private double StDev_length;
	@Element
	private double min_length;
	@Element
	private double max_length;
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
	
	@Element
	private double sum_abs_angle;
	@Element
	private double mean_abs_angle;
	@Element
	private double median_abs_angle;
	@Element
	private double StDev_abs_angle;
	@Element
	private double min_abs_angle;
	@Element
	private double max_abs_angle;
	
	@Element
	private double sum_rel_angle;
	@Element
	private double mean_rel_angle;
	@Element
	private double median_rel_angle;
	@Element
	private double StDev_rel_angle;
	@Element
	private double min_rel_angle;
	@Element
	private double max_rel_angle;
	
	public double getSumDuration(){
		return sum_duration;
	}
	
	
	public int getN(){
		return total_num;
	}
	
	
	public double getSum_length() {
		return sum_length;
	}


	public double getMean_length() {
		return mean_length;
	}


	public double getMedian_length() {
		return median_length;
	}


	public double getStDev_length() {
		return StDev_length;
	}


	public double getMin_length() {
		return min_length;
	}


	public double getMax_length() {
		return max_length;
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


	public double getSum_abs_angle() {
		return sum_abs_angle;
	}


	public double getMean_abs_angle() {
		return mean_abs_angle;
	}


	public double getMedian_abs_angle() {
		return median_abs_angle;
	}


	public double getStDev_abs_angle() {
		return StDev_abs_angle;
	}


	public double getMin_abs_angle() {
		return min_abs_angle;
	}


	public double getMax_abs_angle() {
		return max_abs_angle;
	}


	public double getSum_rel_angle() {
		return sum_rel_angle;
	}


	public double getMean_rel_angle() {
		return mean_rel_angle;
	}


	public double getMedian_rel_angle() {
		return median_rel_angle;
	}


	public double getStDev_rel_angle() {
		return StDev_rel_angle;
	}


	public double getMin_rel_angle() {
		return min_rel_angle;
	}


	public double getMax_rel_angle() {
		return max_rel_angle;
	}

	
	////
	
	
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
	
	public void setStDevLength( Analysis a ) {
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
	
	
	//////////
	
	public void setSumAbsAngle( Analysis a ) {
		sum_abs_angle = a.getSum();
	}
	
	public void setMeanAbsAngle( Analysis a ) {
		mean_abs_angle = a.getMean();
	}
	
	public void setMedianAbsAngle( Analysis a ) {
		median_abs_angle = a.getMedian();
	}
	
	public void setStDevAbsAngle( Analysis a ) {
		StDev_abs_angle = a.getStdev();
	}
	
	public void setMaxAbsAngle( Analysis a ) {
		max_abs_angle = a.getMax();
	}
	
	public void setMinAbsAngle( Analysis a ) {
		min_abs_angle = a.getMin();
	}
	
	
	////////
	
	public void setSumRelAngle( Analysis a ) {
		sum_rel_angle = a.getSum();
	}
	
	public void setMeanRelAngle( Analysis a ) {
		mean_rel_angle = a.getMean();
	}
	
	public void setMedianRelAngle( Analysis a ) {
		median_rel_angle = a.getMedian();
	}
	
	public void setStDevRelAngle( Analysis a ) {
		StDev_rel_angle = a.getStdev();
	}
	
	public void setMaxRelAngle( Analysis a ) {
		max_rel_angle = a.getMax();
	}
	
	public void setMinRelAngle( Analysis a ) {
		min_rel_angle = a.getMin();
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
		output += "\nMean of durations: " + mean_duration;
		output += "\nMedian of durations: " + median_duration;
		output += "\nMax of durations: " + max_duration;
		output += "\nMin of durations: " + min_duration;
		output += "\nStandard Devivation of durations: " + StDev_duration;
		output += "\nSum of absolute angles: " + sum_abs_angle;
		output += "\nMean of absolute angles: " + mean_abs_angle;
		output += "\nMedian of absolute angles: " + median_abs_angle;
		output += "\nMax of absolute angles: " + max_abs_angle;
		output += "\nMin of absolute angles: " + min_abs_angle;
		output += "\nStandard Devivation of absolute angles: " + StDev_abs_angle;
		output += "\nSum of relative angles: " + sum_rel_angle;
		output += "\nMean of relative angles: " + mean_rel_angle;
		output += "\nMedian of relative angles: " + median_rel_angle;
		output += "\nMax of relative angles: " + max_rel_angle;
		output += "\nMin of relative angles: " + min_rel_angle;
		output += "\nStandard Devivation of relative angles: " + StDev_rel_angle;

		return output;
	}
	
}

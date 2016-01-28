package csulb.hdsc.lab.data;

public class Pupils {
	
	private double base_avg_left_pipil_size;
	private double base_avg_right_pipil_size;
	private double base_avg_both_pipil_size;
	
	private double avg_left_pipil_size;
	private double avg_right_pipil_size;
	private double avg_both_pipil_size;

	
	public Pupils(){};
	
	
	public double getAvgLeftPupil() {
		return avg_left_pipil_size;
	}
	
	public void setAvgLeftPupil( Double d ) {
		avg_left_pipil_size = d;
	}
	
	public void setAvgRightPupil( Double d ) {
		avg_right_pipil_size = d;
	}
	
	public void setAvgBothPupil() throws Exception {
		if ( avg_left_pipil_size == 0 || avg_right_pipil_size == 0 ) {
			throw new Exception("Left OR Right Avg Size has not been set");
		}
		avg_both_pipil_size = ( avg_left_pipil_size + avg_right_pipil_size ) / 2;
	}
	
	public double getAvgRightPupil() {
		return avg_right_pipil_size;
	}
	
	public double getAvgBothPupil() {
		return avg_both_pipil_size;
	}
	
}

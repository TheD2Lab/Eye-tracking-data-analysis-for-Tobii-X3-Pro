package csulb.hdsc.lab.math;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
public class DescriptiveMath {
	
	public static void main( String args[] ) {
		
		SummaryStatistics test = new SummaryStatistics();
		test.addValue(1);
		test.addValue(2);
		test.addValue(3);
		
		System.out.println( test.getSum() );
	}
	
	
	private int getSum( String[] values ){
		
		SummaryStatistics numbers = new SummaryStatistics();
		for ( String str : values ) {
			numbers.addValue( Double.parseDouble(str) );
		}
		return (int) numbers.getSum();
	}
	
	private int getCountOfK( String[] values, int k ) {
		SummaryStatistics numbers = new SummaryStatistics();
		for ( String str : values ) {
			if ( Integer.parseInt(str) == k ) {
				numbers.addValue(1);
			}
		}
		return (int) numbers.getSum();
				
	}
	
	
	
	
}

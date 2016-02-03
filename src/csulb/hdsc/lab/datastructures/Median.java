package csulb.hdsc.lab.datastructures;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median<E extends Number> {

	PriorityQueue<E> max;
	PriorityQueue<E> min;
	
	
	public Median() {
		max = new PriorityQueue<>( 10, Collections.reverseOrder() );
		min = new PriorityQueue<>();
		
	}
	
	public void add( E val ) {
		
		if ( max.isEmpty() ) {
			max.add( val );
			return;
		}
		
		if ( max.peek().doubleValue() < val.doubleValue() ) {
			min.add( val );
		} else {
			max.add( val );
		}

		if ( max.size() - min.size() >= 2 ) {
			min.add( max.poll() );
		} else if ( max.size() - min.size() <= -2 ) {
			max.add( min.poll() );
		}
	}
	
	public double compute(){
		if ( max.size() == min.size() ) {
			return ( max.peek().doubleValue() + min.peek().doubleValue() ) / 2;

		} else if ( max.size() < min.size() ) {
		    return min.peek().doubleValue();
		} else {
		    return max.peek().doubleValue();
		}
		
	}
	
	public double size() {
		return max.size() + min.size();
	}
}

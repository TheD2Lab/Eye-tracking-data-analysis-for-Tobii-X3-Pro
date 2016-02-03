package csulb.hdsc.lab.datastructures;

import java.util.ArrayList;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class OneSaccade {
	
	SummaryStatistics lengths;
	ArrayList<Point> points;
	
	public OneSaccade() {
		lengths = new SummaryStatistics();
		points = new ArrayList<>();
	}
	
	public void add( Double x, Double y ) {
		if ( points.isEmpty() ) {
			points.add( new Point( x, y ) );
			return;
		}
		Point curPoint = new Point(x,y);
		double distance = distance( curPoint , points.get( points.size() - 1) );
		points.add( curPoint );

		lengths.addValue( distance );
	}
	
	public void add ( Point p ) {
		if ( points.isEmpty() ) {
			points.add( p );
			return;
		}
		double distance = distance( p, points.get( points.size() - 1 ) );
		points.add( p );

		lengths.addValue( distance );
	}
	
	private double distance( Point p1, Point p2 ){
		double ans = Math.sqrt( (p1.x-p2.x) * ( p1.x-p2.x) + (p1.y-p2.y) * (p1.y-p2.y) );
		return ans;
	}
	
	public int getNPoints() {
		return points.size();
	}
	
	public double getTotalLength() {
		double res = lengths.getSum();
		
		return res;
	}
	
}

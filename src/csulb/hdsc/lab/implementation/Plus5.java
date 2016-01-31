package csulb.hdsc.lab.implementation;

import java.util.ArrayList;

public class Plus5 extends ImplementationDecorator {
	
	private ArrayList<ArrayList<String>> raw_data;
	public Plus5(DataColumnImplementation imp ) {
		super(imp);
		//raw_data = raw;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double compute( ArrayList<String> data ){
		double res = super.compute(data);
		return res+5;
	}

}

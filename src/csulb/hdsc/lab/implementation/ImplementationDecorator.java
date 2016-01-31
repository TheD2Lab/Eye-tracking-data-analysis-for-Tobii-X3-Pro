package csulb.hdsc.lab.implementation;

import java.util.ArrayList;

public class ImplementationDecorator implements DataColumnImplementation {
	
	private DataColumnImplementation imp;
	
	public ImplementationDecorator( DataColumnImplementation imp ) {
		this.imp = imp;
	}
	@Override
	public double compute(ArrayList<String> data_array) {
		return imp.compute(data_array);
	}

}

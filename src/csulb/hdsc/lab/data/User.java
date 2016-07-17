package csulb.hdsc.lab.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.Root;

import csulb.hdsc.lab.ETParser.ColumnMap;
import csulb.hdsc.lab.ETParser.ETParserFromFile;
import csulb.hdsc.lab.ETParser.BaseParser;
import csulb.hdsc.lab.datastructures.Median;
import csulb.hdsc.lab.implementation.FixationDurationStatistics;
import csulb.hdsc.lab.implementation.AbsoluteSaccadeAngleStatistics;
import csulb.hdsc.lab.implementation.DataColumnImplementation;
import csulb.hdsc.lab.implementation.Plus5;
import csulb.hdsc.lab.implementation.PupilAvg;
import csulb.hdsc.lab.implementation.RelativeSaccadeAngleStatistics;
import csulb.hdsc.lab.implementation.SaccadeLengthStatistics;
import csulb.hdsc.lab.implementation.SaccadeDurationStatistics;
import csulb.hdsc.lab.implementation.getMax;

@Root(name="Run")
public class User {
	
	@Element
	public int LengthOfTime;
	
	@Element
	private int base_valid_recording;
	@Element
	private int base_invalid_recording;

	@Element
	private Pupils pupils;
	@Element
	private Fixations fixations;
	@Element
	private Saccades saccades;
	//private BaseParser parser;
	//@ElementMap
	private HashMap<String,Integer> map;
	
	public User(){
		
	}
	public User( BaseParser parser ){
		
		
		pupils = new Pupils();
		fixations = new Fixations();
		saccades = new Saccades();
		//this.parser = parser;
				
		map = parser.getMap();
		
		pupils.setAvgLeftPupil( getPupilAvg( parser, "PupilLeft", new PupilAvg() ) );
		pupils.setAvgRightPupil( getPupilAvg( parser, "PupilRight", new PupilAvg() ) );
		
		try {
			pupils.setAvgBothPupil();
			//System.out.println( pupils.getAvgBothPupil() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fixations.setN( parser.getRawColumnData(map.get("FixationIndex")) , new getMax() );
		
		
		// Fixation count might not match the final in the data because a single fixation might be eliminated by the processing the validities
		FixationDurationStatistics fds = new FixationDurationStatistics(parser.getRawData() , parser.getMap());
		fixations.setTotalN( fds );
		fixations.setSumDuration( fds );
		fixations.setMeanDuration( fds );
		fixations.setMaxDuration( fds );
		fixations.setMinDuration( fds );
		fixations.setStDevDuration( fds );
		fixations.setMedianDuration( fds );
//		System.out.println( getFixationsDetail() ) ;
		
		SaccadeLengthStatistics sls = new SaccadeLengthStatistics( parser.getRawData(), parser.getMap() ) ;
		saccades.setSumLength( sls );
		saccades.setMeanLength( sls );
		saccades.setMaxLength( sls );
		saccades.setMinLength( sls );
		saccades.setStDevLength( sls );
		saccades.setMedianLength( sls );

		SaccadeDurationStatistics sds = new SaccadeDurationStatistics( parser.getRawData(), parser.getMap() ) ;
		saccades.setSumDuration( sds );
		saccades.setMeanDuration( sds );
		saccades.setMedianDuration( sds );
		saccades.setMaxDuration( sds );
		saccades.setMinDuration( sds );
		saccades.setStDevDuration( sds );
		
		saccades.setTotalN( sds );

		AbsoluteSaccadeAngleStatistics asa = new AbsoluteSaccadeAngleStatistics( parser.getRawData(), parser.getMap() );
		
		saccades.setSumAbsAngle( asa );
		saccades.setMeanAbsAngle( asa );
		saccades.setMedianAbsAngle( asa );
		saccades.setMaxAbsAngle( asa );
		saccades.setMinAbsAngle( asa );
		saccades.setStDevAbsAngle( asa );
		
		
		RelativeSaccadeAngleStatistics rsa = new RelativeSaccadeAngleStatistics( parser.getRawData(), parser.getMap() );
		saccades.setSumRelAngle( rsa );
		saccades.setMeanRelAngle( rsa );
		saccades.setMedianRelAngle( rsa );
		saccades.setMaxRelAngle( rsa );
		saccades.setMinRelAngle( rsa );
		saccades.setStDevRelAngle( rsa );
		
		
		
//		System.out.println( getSaccadesDetail() ) ;		
		

	}
	
	public double getDataByIdx( int k ) {
		switch(k) {
			case 0:
				return LengthOfTime;
			case 1:
				return getFixationToSaccadeRatio();
			case 2:
				return getFixationsData().getN();
			case 3:
				return getFixationsData().getSum_duration();
			case 4:
				return this.getSaccadesData().getSum_length();
			case 5:
				return getSaccadesData().getSumDuration();
			case 6:
				return getSaccadesData().getSum_abs_angle();
			default:
				return getSaccadesData().getSum_rel_angle();
		}
	}
	
	public int getBaseValidNRecords() {
		return base_valid_recording;
	}
	
	public int getBaseInvalidNRecordS(){
		return base_invalid_recording;
	}
	
	
	public double getFixationToSaccadeRatio() {
		return fixations.getSumDuration() / saccades.getSumDuration();
	}
	
	public Pupils getPupilData(){
		return pupils;
		
	}
	
	public Saccades getSaccadesData(){
		return saccades;
	}
	
	public Fixations getFixationsData(){
		return fixations;
	}
	
	public String getFixationsDetail(){
		return fixations.toString();
	}
	
	public String getSaccadesDetail(){
		return saccades.toString();
	}
	
	private double getPupilAvg( BaseParser parser, String column_name, DataColumnImplementation implementation ) {
//		System.out.println( column_name );
//		System.out.println( parser.getRawColumnData(1) ); 
		ArrayList<String> pupil_data = parser.getRawColumnData( map.get( column_name ) ); 
		
//		for ( int i = 0 ; i< pupil_data.size(); i++ ) {
//			System.out.println( pupil_data.get(i) );
//		}
		return implementation.compute( pupil_data );
		
	}
	
	
	
//	public static void main( String args[] ){
////		./TestData/Testing_Data_Export.tsv
//		//ColumnMap custom_map = new ColumnMap("./Mappings/QualitiesToColumns.txt");
//		ETParserFromFile parser = new ETParserFromFile("../DesktopMobileExperiment/AnhTestResults/MobileAnatomy/P12_Mobile_Anatomy.tsv");
//		User user = new User( parser );
//		
////		parser.printColumn( parser.getMap().get("SaccadeIndex") );
////		parser.printColumn( parser.getMap().get("PupilLeft") );
////		parser.printColumn( parser.getMap().get("AbsoluteSaccadicDirection") );
//		
//		HashMap<String,Integer> map = parser.getMap();
////		ArrayList<String> indexData = parser.getRawColumnData( map.get("SaccadeIndex"));
////		ArrayList<String> AbsSaccadeData = parser.getRawColumnData( map.get("AbsoluteSaccadicDirection"));
////		System.out.println( indexData.size() );
////		System.out.println( AbsSaccadeData.size() );
////
////		for( int i = 0 ; i < indexData.size() ; i++ ) {
////			System.out.println( indexData.get(i) + "  " + AbsSaccadeData.get(i) );
////		}
//		
////		parser.printColumn( map.get("GazeEventDuration") );
//		
//		ArrayList<String> leftvalidity = parser.getRawColumnData( map.get("ValidityLeft"));
//		for ( String x : leftvalidity ) {
//			if( !x.equals("0") && !x.equals("N/A") ) {
//				System.out.println("HERE");
//			}
//		}
//		
//		System.out.println( "FixationSaccadeRatio:" + user.getFixationToSaccadeRatio() );
//	}
}

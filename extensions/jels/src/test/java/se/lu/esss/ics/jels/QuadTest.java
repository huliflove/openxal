package se.lu.esss.ics.jels;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import se.lu.esss.ics.jels.model.elem.jels.JElsElementMapping;
import xal.smf.AcceleratorSeq;
import xal.smf.attr.ApertureBucket;
import xal.smf.impl.Quadrupole;

@RunWith(Parameterized.class)
public class QuadTest extends SingleElementTest {	

	public QuadTest(SingleElementTestData data) {
		super(data);
	}

	@Parameters
	public static Collection<Object[]> tests() {
		final double frequency = 4.025e8, current = 0;
		
		List<Object []> tests = new ArrayList<>();
		
		// basic test, E=3MeV, Q=-16		
		tests.add(new Object[] {new SingleElementTestData() {{
			probe = setupOpenXALProbe( 3e6, frequency, current); 
			elementMapping = JElsElementMapping.getInstance();
			sequence = quad(70., -16., 15., 0., 0., 0., 0., 0.);
			
			// TW transfer matrix
			TWTransferMatrix = new double[][]{ 
					{+1.160625e+00, +7.370925e-02, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+4.708370e+00, +1.160625e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +8.475396e-01, +6.640505e-02, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, -4.241796e+00, +8.475396e-01, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +6.955452e-02}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 		
			};
			
			// TW correlation matrix
			TWGamma = 1.003197291; 
			TWCorrelationMatrix = new double[][] { 
					{+1.001561e-12, +5.228219e-12, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+5.228219e-12, +3.415331e-11, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +8.733876e-13, -2.953358e-12, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, -2.953358e-12, +1.780296e-11, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +3.361266e-12, +2.249328e-12}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +2.249328e-12, +5.280827e-12}};
			
			// ELS results
			elsPosition = 7.000000E-02;
			elsSigma = new double[] {1.000780E-03, 9.345521E-04, 1.833376E-03};
			elsBeta = new double[] {3.820541E-01, 3.342766E-01, 9.435362E-01};			
		}}});
		
		// high energy test, E=2.5GeV, Q=-16
		tests.add(new Object[] {new SingleElementTestData() {{
			probe = setupOpenXALProbe( 2.5e9, frequency, current); 
			elementMapping = JElsElementMapping.getInstance();
			sequence = quad(70., -16., 15., 0., 0., 0., 0., 0.);
			
			// TW transfer matrix
			TWTransferMatrix = new double[][]{
				{+1.003555e+00, +7.008293e-02, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{+1.016284e-01, +1.003555e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +9.964493e-01, +6.991713e-02, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, -1.013880e-01, +9.964493e-01, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +5.213029e-03}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 		
			};
	
			// TW correlation matrix
			TWGamma = 3.664409209; 
			TWCorrelationMatrix = new double[][] {
				{+1.734644e-14, +2.979657e-14, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{+2.979657e-14, +2.553578e-13, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +2.689426e-14, +2.809946e-14, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +2.809946e-14, +1.601717e-13, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +5.719022e-15, +5.106308e-14}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +5.106308e-14, +1.599526e-12}, 
			};
		}}});	
		
		// basic test, E=3MeV, Q=16
		tests.add(new Object[] {new SingleElementTestData() {{
			probe = setupOpenXALProbe( 3e6, frequency, current);
			elementMapping = JElsElementMapping.getInstance();
			sequence = quad(70., 16., 15., 0., 0., 0., 0., 0.);
			
			// TW transfer matrix
			TWTransferMatrix = new double[][]{
				{+8.475396e-01, +6.640505e-02, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{-4.241796e+00, +8.475396e-01, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +1.160625e+00, +7.370925e-02, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +4.708370e+00, +1.160625e+00, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +6.955452e-02}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 
			};
			
			// TW correlation matrix
			TWGamma = 1.003197291;
			TWCorrelationMatrix = new double[][] {
				{+5.606844e-13, -1.476716e-12, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{-1.476716e-12, +1.614641e-11, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +1.583302e-12, +7.733000e-12, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +7.733000e-12, +4.208032e-11, +0.000000e+00, +0.000000e+00}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +3.361266e-12, +2.249328e-12}, 
				{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +2.249328e-12, +5.280827e-12}, 
			};
			
			// ELS results
			elsPosition = 7.000000E-02;
			elsSigma = new double[] { 7.487886E-04, 1.258293E-03, 1.833376E-03};
			elsBeta = new double[] {2.138779E-01, 6.059861E-01, 9.435362E-01};
		}}});
			
		// high energy test, E=2.5GeV, Q=16
		tests.add(new Object[] {new SingleElementTestData() {{
				probe = setupOpenXALProbe( 2.5e9, frequency, current); 
			    elementMapping = JElsElementMapping.getInstance();
				sequence = quad(70., 16., 15., 0., 0., 0., 0., 0.);
				// TW transfer matrix
				TWTransferMatrix = new double[][]{
					{+9.964493e-01, +6.991713e-02, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{-1.013880e-01, +9.964493e-01, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +1.003555e+00, +7.008293e-02, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +1.016284e-01, +1.003555e+00, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +5.213029e-03}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 	 		
				};
				
				// TW correlation matrix
				TWGamma = 3.664409209;
				TWCorrelationMatrix = new double[][] {
						{+1.712016e-14, +2.638128e-14, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
						{+2.638128e-14, +2.475260e-13, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
						{+0.000000e+00, +0.000000e+00, +2.725861e-14, +3.354165e-14, +0.000000e+00, +0.000000e+00}, 
						{+0.000000e+00, +0.000000e+00, +3.354165e-14, +1.703375e-13, +0.000000e+00, +0.000000e+00}, 
						{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +5.719022e-15, +5.106308e-14}, 
						{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +5.106308e-14, +1.599526e-12}, 
				};
		}}});
		
		// bigger beta variation test, E=3MeV, Q=-16		
		tests.add(new Object[] {new SingleElementTestData() {{
			probe = setupOpenXALProbe( 3e6, frequency, current,
					new double[][]{{-0.1763,0.3,0.2098},
				  		{-0.3247,0.4,0.2091},
				  		{-0.5283,0.8,0.2851}}); 
			elementMapping = JElsElementMapping.getInstance();
			sequence = quad(70., -16., 15., 0., 0., 0., 0., 0.);
			
			// TW transfer matrix
			TWTransferMatrix = new double[][]{ 
					{+1.160625e+00, +7.370925e-02, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+4.708370e+00, +1.160625e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +8.475396e-01, +6.640505e-02, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, -4.241796e+00, +8.475396e-01, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +6.955452e-02}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 		
			};
			
			// TW correlation matrix
			TWGamma = 1.003197291; 
			TWCorrelationMatrix = new double[][] { 
					{+1.187423e-06, +5.851465e-06, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+5.851465e-06, +3.462287e-05, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +8.780590e-07, -2.980439e-06, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, -2.980439e-06, +1.789126e-05, +0.000000e+00, +0.000000e+00}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +3.121332e-06, +2.280733e-06}, 
					{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +2.280733e-06, +5.732338e-06}, 
			};		
		}}});
		
		// basic test, E=3MeV, Q=-16		
				tests.add(new Object[] {new SingleElementTestData() {{
					probe = setupOpenXALProbe2( 3e6, frequency, 30.0e-3); 
					elementMapping = JElsElementMapping.getInstance();
					sequence = quad(70., -16., 15., 0., 0., 0., 0., 0.);
					
					// TW transfer matrix
					TWTransferMatrix = new double[][]{ 
							{+1.160625e+00, +7.370925e-02, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+4.708370e+00, +1.160625e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +8.475396e-01, +6.640505e-02, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -4.241796e+00, +8.475396e-01, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +6.955452e-02}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 		
					};

					
					// TW correlation matrix
					TWGamma = 1.003197291; 
					TWCorrelationMatrix = new double[][] { 
							{+1.038199e-06, +5.859669e-06, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+5.859669e-06, +3.969189e-05, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +9.061416e-07, -2.552999e-06, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -2.552999e-06, +1.472658e-05, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +3.416879e-06, +3.069598e-06}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +3.069598e-06, +6.471760e-06}};
				}}});

				tests.add(new Object[] {new SingleElementTestData() {{
					probe = setupOpenXALProbe2( 3e6, frequency, 30.0e-3); 
					elementMapping = JElsElementMapping.getInstance();
					sequence = quad(5000., -16., 15., 0., 0., 0., 0., 0.);
					
					// TW transfer matrix
					TWTransferMatrix = new double[][]{ 
							{+1.132742e+17, +1.417283e+16, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+9.053264e+17, +1.132742e+17, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -6.379448e-01, +9.635244e-02, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -6.154763e+00, -6.379448e-01, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +4.968180e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 

					};

					// TW correlation matrix
					TWGamma = 1.003197291; 
					TWCorrelationMatrix = new double[][] { 
							{+1.000000e+25, +6.819195e+27, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+6.819195e+27, +1.000000e+25, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +2.508888e-07, +2.454528e-06, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +2.454528e-06, +5.122298e-05, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +3.359821e-04, +6.339603e-05}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +6.339603e-05, +1.199989e-05}, 
					};
				}}});

				tests.add(new Object[] {new SingleElementTestData() {{
					probe = setupOpenXALProbe2( 20e9, frequency, 30.0e-3); 
					elementMapping = JElsElementMapping.getInstance();
					sequence = quad(5000., -16., 15., 0., 0., 0., 0., 0.);
					
					// TW transfer matrix
					TWTransferMatrix = new double[][]{ 
							{+5.526161e+00, +1.134948e+01, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+2.602626e+00, +5.526161e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -7.335668e-01, +1.419210e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -3.254486e-01, -7.335668e-01, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00, +1.004074e-02}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.000000e+00}, 
					};

					// TW correlation matrix
					TWGamma = 22.315273669; 
					TWCorrelationMatrix = new double[][] { 
							{+5.815553e-06, +2.830545e-06, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+2.830545e-06, +1.377698e-06, +0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +5.492668e-08, -2.913093e-08, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, -2.913093e-08, +1.705164e-08, +0.000000e+00, +0.000000e+00}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.231478e-09, +1.139644e-07}, 
							{+0.000000e+00, +0.000000e+00, +0.000000e+00, +0.000000e+00, +1.139644e-07, +1.067940e-05},  
					};
				}}});

				
		return tests;
	}
	
	/**
	 * 
	 * @param L length
	 * @param G field
	 * @param R aperture
	 * @param Phi skew angle 
	 * @param G3 sextupole gradient (T/m^2)
	 * @param G4 octupole gradient (T/m^2)
	 * @param G5 decapole gradient (T/m^2)
	 * @param G6 dodecapole gradient (T/m^2)
	 * @return
	 */
	public static AcceleratorSeq quad(double L, double G, double R, double Phi, double G3, double G4, double G5, double G6)
	{
		AcceleratorSeq sequence = new AcceleratorSeq("QuadTest");
		Quadrupole quad = new Quadrupole("quad") { // there's no setter for type (you need to extend class)
			{_type="Q"; }
		};
		quad.setPosition(L*1e-3*0.5); //always position on center!
		quad.setLength(L*1e-3); // effLength below is actually the only one read 
		quad.getMagBucket().setEffLength(L*1e-3);
		quad.setDfltField(G);
		quad.getMagBucket().setPolarity(1);
		quad.getAper().setAperX(R*1e-3);
		quad.getAper().setAperY(R*1e-3);
		quad.getAper().setShape(ApertureBucket.iRectangle);
		sequence.addNode(quad);
		sequence.setLength(L*1e-3);	
		return sequence;
	}
}

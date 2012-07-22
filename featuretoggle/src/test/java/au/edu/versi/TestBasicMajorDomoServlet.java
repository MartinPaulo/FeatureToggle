package au.edu.versi;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBasicMajorDomoServlet {

    
    @Before
    public void setUpBasicFeature() {
        StartupFeatureSet features = new StartupFeatureSet() {

            @Override
            public boolean isBasicApplication() {
                return true;
            }
            
        };
        FeatureSetFactory.setCurrentFeatureSet(features);
    }
    
    @Test
    public void test() {
        MajorDomoServlet majorDomo = new MajorDomoServlet();
        assertTrue(MajorDomoServlet.BASIC_INDEX_JSP.equals(majorDomo.getHomePage()));
    }

}

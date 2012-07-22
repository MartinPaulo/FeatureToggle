package au.edu.versi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RuntimeFeatureSet implements StartupFeatureSet {

    private static final String LUXURY_LEVEL = "luxury.level";
    private static final String BASIC_APP = "basic";
    private static final String FEATURE_FILE_NAME = "features.properties";
    private static Properties FEATURES = loadFeatures();
    
    private static boolean isBasic = getBooleanValue(BASIC_APP, LUXURY_LEVEL);

    private static Properties loadFeatures() {
        Properties result = new Properties();
        try {
            InputStream resourceAsStream =Thread.currentThread().getContextClassLoader().getResourceAsStream(FEATURE_FILE_NAME);
            if (null == resourceAsStream) {
                throw new RuntimeException("Could not find config file " + FEATURE_FILE_NAME);
            }
            result.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not read config file " + FEATURE_FILE_NAME, e);
        }
        return result;
    }

    private static boolean getBooleanValue(String ifMatches, String property) {
        return ifMatches.equals(getFeatureToggleSetting(property));
    }

    private static String getFeatureToggleSetting(String featureName) {
        String result = FEATURES.getProperty(featureName);
        if (null == result) {
            throw new RuntimeException("Could not find " + featureName +" setting ");
        }
        if (("${" + featureName +"}").equals(result)) {
            throw new RuntimeException("The "+featureName + " setting has not been defined!");
        }
        return result;
    }

    @Override
    public boolean isBasicApplication() {
        return isBasic;
    }


}

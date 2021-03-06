package au.edu.versi;

/**
 * To test we have to dependency inject: that way we can inject feature set one, test, inject feature set two, test
 * etc... 
 * @author Martin Paulo
 */
public class FeatureSetFactory {

    private static StartupFeatureSet currentFeatureSet;

    public static StartupFeatureSet getFeatureSet() {
        if (currentFeatureSet == null) {
            currentFeatureSet = new RuntimeFeatureSet();
        }
        return currentFeatureSet;
    }

    /**
     * Poor man's dependency injection :) A chance to set the Feature Set before it is used.
     */
    public static void setCurrentFeatureSet(StartupFeatureSet set) {
        currentFeatureSet = set;
    }

    /**
     * Just to ensure that there will be no instances of the factory floating around
     */
    private FeatureSetFactory() {
    };
}

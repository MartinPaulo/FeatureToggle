package au.edu.versi;

/**
 * This is the list of Feature toggles that we support at startup. 
 * Presented as an interface so that we can inject different values during testing.
 * @author Martin Paulo
 */
public interface StartupFeatureSet {

    /**
     * @return true if we are running the simple application, false if there are bells and whistles
     */
    boolean isBasicApplication();
}

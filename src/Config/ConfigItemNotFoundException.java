package Config;

/**
 * @author Archie Gunasekara
 * @date 14.09.2015
 */
public class ConfigItemNotFoundException extends Exception {

    public ConfigItemNotFoundException(String configItem) {
        
        super("Item '" + configItem + "' not found in the configuration file");
    }
}
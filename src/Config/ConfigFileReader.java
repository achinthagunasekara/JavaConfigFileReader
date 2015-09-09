package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Achintha Gunasekara
 * @date 07.09.2015
 */

public class ConfigFileReader {
    
    //Configuration file used by the config reader
    private final String file = "config.properties";
    private final Properties properties;
    private static ConfigFileReader instance;
    
    public static ConfigFileReader getConfigFileReaderInstance() throws IOException {
	
        //there can only be once instance of the config reader
        if(instance == null) {
			
            instance = new ConfigFileReader();
        }
        
        return instance;
    }
    
    //read and load the config file
    private ConfigFileReader() throws IOException {
		
        properties = new Properties();
        properties.load(new FileInputStream(file));
    }
    
    //get the propery value for strng s
    public String getPropertyFor(String s) {
        
        return properties.getProperty(s);
    }
    //returns int property
    public Integer getIntPropertyFor(String s) {
        
        return Integer.parseInt(getPropertyFor(s));
    }
    
    //returns double property
    public Double getDoublePropertyFor(String s) {
        
        return Double.parseDouble(getPropertyFor(s));
    }
    
    //returns bool property
    public Boolean getBooleanPropertyFor(String s) {
        
        return Boolean.parseBoolean(getPropertyFor(s));
    }
}
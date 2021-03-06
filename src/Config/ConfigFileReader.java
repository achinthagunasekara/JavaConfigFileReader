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
    //config file must be located inside the application path
    private final String file = "config.properties";
    private Properties properties;
    private static ConfigFileReader instance;
    
    public static ConfigFileReader getConfigFileReaderInstance() throws IOException {
	
        //there can only be once instance of the config reader
        if(instance == null) {
			
            instance = new ConfigFileReader();
        }
        
        return instance;
    }
    
    private ConfigFileReader() throws IOException {
		
        loadConfig(file);
    }
    
    //read and load the config file
    private void loadConfig(String configFile) throws IOException {
        
        properties = new Properties();
        properties.load(new FileInputStream(configFile));
    }
    
    //reloads the configuration during runtime
    public void reloadConfig() throws IOException {
        
        loadConfig(file);
    }
    
    //reloads the configuration during runtime from a provided configuration file
    public void reloadConfig(String configFile) throws IOException {
        
        loadConfig(configFile);
    }
    
    //get the propery value for strng s
    public String getPropertyFor(String configItem) throws ConfigItemNotFoundException {
        
        String value = properties.getProperty(configItem);
        
        if(value == null) {
            
            throw new ConfigItemNotFoundException(configItem);
        }
        
        return value;
    }
    //returns int property
    public Integer getIntPropertyFor(String configItem) throws ConfigItemNotFoundException {
        
        return Integer.parseInt(getPropertyFor(configItem));
    }
    
    //returns double property
    public Double getDoublePropertyFor(String configItem) throws ConfigItemNotFoundException {
        
        return Double.parseDouble(getPropertyFor(configItem));
    }
    
    //returns bool property
    public Boolean getBooleanPropertyFor(String s) throws ConfigItemNotFoundException {
        
        return Boolean.parseBoolean(getPropertyFor(s));
    }
}
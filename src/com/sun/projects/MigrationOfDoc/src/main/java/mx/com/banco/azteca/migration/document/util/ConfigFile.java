package mx.com.banco.azteca.migration.document.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**.
 * @author Carlos Cuaya Xinto
 */
public class ConfigFile {
    private static final Logger log = Logger.getLogger(ConfigFile.class);
    
    private  Properties properties;
   
    public ConfigFile() {
        loadProperties();
    }
    
    private void loadProperties() {
        final String configFilePath;
        configFilePath = "mx/com/banco/azteca/migration/document/config/" +
                         "config.properties";
        
        properties = new Properties();
        
        InputStream inputStream = getClass().getClassLoader().
                                  getResourceAsStream(configFilePath);
        
        
        try {
            properties.load(inputStream);
        } catch (IOException ex) {
            log.error("ex: " + ex);
        }
    }
    
    public String getProperty(String key){
        return properties.getProperty(key);
    }
    
     public int getIntProperty(String key){
         int value = 0;
         try {
             value = Integer.parseInt(properties.getProperty(key));
         } catch (NumberFormatException e) {
             log.error("e:" + e);
         }
         
        return value;
    }

}

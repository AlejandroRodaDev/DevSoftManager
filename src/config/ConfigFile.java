package config;

//region Imports
import util.AlertDialog;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
//endregion

public class ConfigFile {

    //region Var
    private File file;
    private Properties properties;
    private static final String PATH = "src/config\\Settings.properties";
    //endregion

    //region Builder
    public ConfigFile() {
        init();
    }
    //endregion

    //region Init
    private void init(){
        properties = new Properties();
        file = new File(PATH);
    }
    //endregion

    //region Private Methods
    private void setDefaultConfigFile() {
        setDefaultProperties();
        try {
            properties.store(new FileWriter(file.getAbsolutePath()),
                    "Configuration Settings");
        } catch (IOException e) {
            AlertDialog.errorDialog("Error when assigning default properties");
        }
    }

    private void setDefaultProperties(){
        properties.setProperty("remember", "true");
        properties.setProperty("lastUser", "default");
        properties.setProperty("language", "es_ES");
    }

    private void setProperties(String remember, String user, String language){
        properties.setProperty("remember", remember);
        properties.setProperty("lastUser", user);
        properties.setProperty("language", language);
    }

    private void readConfigFile() {
        try {
            properties.load(new FileReader(PATH));
        } catch (IOException e) {
            AlertDialog.errorDialog("Error reading configuration file");
        }
    }
    //endregion

    //region Public Methods
    public void createConfigFile(){
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                AlertDialog.errorDialog("Error creating configuration file");
            }
            setDefaultConfigFile();
        }
    }

    public String getValue(String property){
        readConfigFile();
        return properties.getProperty(property);
    }

    public void updateConfigFile(String remember, String user, String language) {
       setProperties(remember,user, language);
        try {
            properties.store(new FileWriter(file.getAbsolutePath()),
                    "Login Settings");
        } catch (IOException e) {
            AlertDialog.errorDialog("Error updating configuration file");
        }
    }
    //endregion
}

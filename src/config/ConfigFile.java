package config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {

    private File file;
    private Properties properties;
    private final String path = "src/config\\Settings.properties";

    public ConfigFile() {
        properties = new Properties();
    }

    public void createConfigFile(){

        file = new File(path);

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                //AlertUtil.errorAlert("Error creating configuration file");
            }
            assignDefaultConfigFile();
        }
    }

    private void assignDefaultConfigFile() {

        addProperties();
        try {
            properties.store(new FileWriter(file.getAbsolutePath()),
                    "Configuration Settings");
        } catch (IOException e) {
            //AlertUtil.errorAlert("Error when assigning default properties");
        }
    }

    public void loadConfigFile() {

        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            //AlertUtil.errorAlert("Error loading configuration file");
        }
    }

    private void updateConfigFile() {

    }

    private void addProperties(){
        properties.setProperty("remember", "true");
        properties.setProperty("lastUser", "default");
        properties.setProperty("language", "es_ES");
    }
}

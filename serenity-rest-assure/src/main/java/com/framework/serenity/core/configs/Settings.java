package com.framework.serenity.core.configs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author trantrongnhan
 * <p>
 * Class implementation for common functions relating to loading or getting configurations information
 */
public class Settings {

    /**
     * Read data from properties file
     *
     * @param fileName String
     * @return Properties
     * @throws IOException IOException catch handling
     */
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fileNotFoundError) {
            fileNotFoundError.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}

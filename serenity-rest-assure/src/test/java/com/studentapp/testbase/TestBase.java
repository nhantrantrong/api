package com.studentapp.testbase;

import com.framework.serenity.core.configs.Settings;
import com.studentapp.requests.StudentAppRequestsFactory;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Properties;

/**
 * Creator: Nhan.Tran Trong
 * Implement some initialization, beforeClass and afterClass for preparation and cleaning up test
 *
 */
public class TestBase extends StudentAppRequestsFactory{
    private static final String testsPropertiesFile = "./src/test/resources/configs/tests.properties";
    public static Properties prop;

    @BeforeClass
    public static void init() throws IOException {
        prop = Settings.readPropertiesFile(testsPropertiesFile);
        initRequests(prop.getProperty("baseUrl"));
    }
}

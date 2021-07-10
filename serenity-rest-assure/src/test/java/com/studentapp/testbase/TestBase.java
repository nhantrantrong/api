package com.studentapp.testbase;

import com.framework.serenity.core.configs.Settings;
import com.studentapp.requests.StudentAppBusiness;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class TestBase {
    private static final String testsPropertiesFile = "./src/test/resources/configs/tests.properties";
    public static Properties prop;
    public static StudentAppBusiness studentRequests;

    @BeforeClass
    public static void init() throws IOException {
        prop = Settings.readPropertiesFile(testsPropertiesFile);
        studentRequests = new StudentAppBusiness(prop.getProperty("baseUrl"));
    }
}

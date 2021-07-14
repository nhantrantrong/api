package com.studentapp.tests;

import com.framework.serenity.core.configs.Settings;
import com.framework.serenity.core.utils.Validations;
import com.studentapp.requests.StudentAppRequestsFactory;
import com.studentapp.steps.StudentAppSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Properties;



/**
 * Creator: Nhan.Tran Trong
 * Implement some initialization, beforeClass and afterClass for preparation and cleaning up test
 */
public class TestBase {
    private static final String testsPropertiesFile = "./src/test/resources/configs/tests.properties";
    private static Properties prop;
    public static StudentAppRequestsFactory requestsFactory = new StudentAppRequestsFactory();
    public static Validations validations = new Validations();

    @Steps
    public StudentAppSteps studentAppSteps;

    @BeforeClass
    public static void init() throws IOException {
        prop = Settings.readPropertiesFile(testsPropertiesFile);
        requestsFactory.initRequests(prop.getProperty("baseUrl"));
    }
}

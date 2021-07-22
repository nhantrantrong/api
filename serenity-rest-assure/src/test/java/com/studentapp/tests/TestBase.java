package com.studentapp.tests;

import com.framework.serenity.core.configs.Settings;
import com.framework.serenity.core.utils.Validations;
import com.studentapp.data.DataFactory;
import com.studentapp.requests.StudentAppRequestsFactory;
import com.studentapp.steps.StudentAppSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Properties;

import static com.studentapp.constants.FileLocations.TESTS_PROPERTIES;


/**
 * @author trantrongnhan
 * <p>
 * Class implementation for beforeClass and afterClass to prepare and clean up test
 */
public class TestBase {
    private static Properties prop;
    public static StudentAppRequestsFactory requestsFactory = new StudentAppRequestsFactory();
    public static Validations validations = new Validations();
    public static DataFactory dataFactory = new DataFactory();

    @Steps
    public StudentAppSteps studentAppSteps;

    @BeforeClass
    public static void init() throws IOException {
        prop = Settings.readPropertiesFile(TESTS_PROPERTIES);
        String baseUrl = prop.getProperty("baseUrl");
        requestsFactory.initRequests(baseUrl);
    }
}

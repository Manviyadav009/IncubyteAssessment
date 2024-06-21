package runnerPackage;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import util.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinition"},
       plugin = {"pretty","junit:target/Cucumber.xml", "html:target/cucumber-reports.HTML"},
        monochrome = true
)
public class TestRunner {
	
	@AfterClass
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}



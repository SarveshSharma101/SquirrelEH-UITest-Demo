import Driver.SetupDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinition", "Driver"},
        monochrome = true,
        plugin = {"pretty", "html:target/HtmlReports/index.html"}
)
public class TestRunner {
    static WebDriver driver;


//    @AfterClass
//    public static void tearDown(){
//        driver.quit();
//    }
}

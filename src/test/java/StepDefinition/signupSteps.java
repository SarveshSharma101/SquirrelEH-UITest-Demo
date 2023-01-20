package StepDefinition;

import Driver.SetupDriver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class signupSteps {
    WebDriver driver;
    @Then("user is on signup page")
    public void userIsOnDashboard() {
//        driver= new ChromeDriver();
        driver = SetupDriver.getDriver();
        WebElement accesslabel = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/h1[2]"));
        if (accesslabel.isDisplayed() && accesslabel.getText().equals("Access Request")) {
            System.out.println("I am on Signup page");
        } else {
            throw new NoSuchElementException("No element found");
        }
    }
}


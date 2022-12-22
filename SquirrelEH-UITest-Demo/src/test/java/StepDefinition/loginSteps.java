package StepDefinition;

import Driver.SetupDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class loginSteps {

    WebDriver driver;
    @Given("user is on login page")
    public void userIsOnLoginPage() {

        driver = SetupDriver.getDriver();
        driver.get("https://squirrel.difinative.com/");
        driver.manage().window().maximize();
        WebElement signInHeader =  driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div/div/div/div/div/div/div[1]/div/h1[2]"));
        if (signInHeader.isDisplayed() && signInHeader.getText().equals("Sign in")){
            System.out.println("I am on login page");
        }else{
            System.out.println("Could not find login page");
        }
    }

    @When("user enters {string} and {string}")
    public void userEntersUnameAndPwd(String email, String password){
        driver = SetupDriver.getDriver();
        WebElement uname = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]"));

        uname.sendKeys(email);
        pwd.sendKeys(password);

        System.out.println("I enter my  uname and pwd");
    }


    @And("click on login button")
    public void userClicksOnLoginButton(){
        driver = SetupDriver.getDriver();
        WebElement submitButton = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
        submitButton.click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(Exception.class);
        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/header/div/div[4]/span[1]"));
            }});
        System.out.println("I click on login button");
    }

    @Then("user successfully lands on dashboard and his {string} is visible in the header")
    public void userIsOnDashboard(String email){
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/header/div/div[4]/span[1]"));
        if (emailElement.isDisplayed() && emailElement.getText().equals(email)){
            System.out.println("I am on Dashboard page");
        }else{
            throw new NoSuchElementException("No element found");
        }
    }
}

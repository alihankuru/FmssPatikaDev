package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginTest {
    WebDriver driver;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_OrangeHRM_login_page() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Add a sleep to ensure the page loads completely
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I enter {string} as the username")
    public void i_enter_as_the_username(String username) {
        WebElement usernameField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        usernameField.sendKeys(username);
        // Add a sleep to wait for any potential AJAX requests or delays
        try {
            Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I enter {string} as the password")
    public void i_enter_as_the_password(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        passwordField.sendKeys(password);
        // Add a sleep to ensure the password is properly entered
        try {
            Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        loginButton.click();
        // Add a sleep to wait for the login process to complete
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Then("I should be redirected to the OrangeHRM dashboard")
    public void i_should_be_redirected_to_the_OrangeHRM_dashboard() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl) : "Redirection to dashboard failed";
        // Add a sleep to ensure the page fully loads
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see an error message saying {string}")
    public void i_should_see_an_error_message_saying(String expectedErrorMessage) {
        // Add a sleep to wait for the error message to appear
        try {
            Thread.sleep(3000); // Sleep for 3 seconds to wait for the error message to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Locate the error message element
        WebElement errorMessageElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")); // Update the XPath as needed

        // Retrieve and verify the error message text
        String actualErrorMessage = errorMessageElement.getText();
        assert actualErrorMessage.equals(expectedErrorMessage) : "Expected error message: '" + expectedErrorMessage + "' but found: '" + actualErrorMessage + "'";
    }



}

package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchTest {

    WebDriver driver;

    @Given("I am on the OrangeHRM dashboard")
    public void i_am_on_the_orangehrm_dashboard() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Perform login
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();

        // Wait for the dashboard to load
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
        searchButton.click();

        // Wait for the search input to become clickable
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I enter {string} in the search bar")
    public void i_enter_in_the_search_bar(String searchTerm) {
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
        searchInput.sendKeys(searchTerm);

        // Wait for search results to load
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @And("I should be able to click on it to navigate to the {string} module")
    public void i_should_be_able_to_click_on_it_to_navigate_to_the_Admin_module(String SearchName) {

            // Locate the span element containing the text 'Admin' and click its parent link
            WebElement adminSpan = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span[text()='" + SearchName + "']"));
            WebElement adminLink = adminSpan.findElement(By.xpath("..")); // Locate the parent <a> element
            adminLink.click();

            // Wait for navigation to complete
            try {
                Thread.sleep(3000); // Sleep for 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Verify navigation to the Admin module page
            //String currentUrl = driver.getCurrentUrl();
            //assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers", currentUrl);



            // Clean up
            driver.quit();
    }




}

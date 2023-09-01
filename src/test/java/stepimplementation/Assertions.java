package stepimplementation;

import com.pg.driver.DriverManage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assertions extends SeleniumUtilities{

    WebDriver driver= DriverManage.getDriver();

    @Then("Search results {string} are displayed")
    public void searchResultsAreDisplayed(String element) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el=locator(driver, UserInputActions.pageElement, element);
        wait.until(ExpectedConditions.visibilityOf(el));
        System.out.println("Element found");

    }
}

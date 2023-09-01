package stepimplementation;

import com.pg.driver.DriverManage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import utils.ReadXmlFile;
import org.dom4j.Element;

import java.time.Duration;

public class UserInputActions extends SeleniumUtilities{
   static WebDriver driver=DriverManage.getDriver();
    static Element pageElement;

    public static void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Given("^User navigates to the homepage$")
    public void user_is_on_Home_Page() throws Throwable {
        driver.manage().window().maximize();
        implicitWait();
        driver.manage().deleteAllCookies();
        System.out.println("driver in userinput is "+driver);
        SeleniumUtilities.getHomePage(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // driver.get("https://www.store.demoqa.com");
    }

    @Given("User opens page {string}")
    public void userOpensPage(String page) throws DocumentException {
        pageElement=ReadXmlFile.getPageName(page);
    }
    @When("User enters {string} in the text field in Element {string}")
    public void userEntersInTheTextFieldInElement(String text, String element) {

        enterTextField(driver,text,pageElement,element);
    }

    @And("User presses {string} on Keyboard for Element {string}")
    public void userPressesOnKeyboardForElement(String keyboardKey, String element) {
        keyboardKey(driver,keyboardKey,pageElement,element);
    }


    @And("User clicks on element {string}")
    public void userClicksOnElement(String element) {
        try{
        clickOnElement(driver,pageElement,element);
        }
        catch(Exception e){
            System.out.println(("Pop up banner not displayed"));

        }
    }
}

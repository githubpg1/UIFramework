package stepimplementation;

import org.dom4j.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReadPropertyFile;
import utils.ReadXmlFile;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SeleniumUtilities {

    static void getHomePage(WebDriver driver) throws IOException {
        String url=ReadPropertyFile.get("url");
        System.out.println("url is "+url);
        System.out.println("driver is "+driver);
        driver.get(url);

    }

    public WebElement locator(WebDriver driver,Element pageElement, String element) {
        Map<String, String> map = ReadXmlFile.getElementLocator(pageElement, element);
        System.out.println(map);
        if (map.containsKey("xpath")) {
            return driver.findElement(By.xpath(map.get("xpath")));
        } else if (map.containsKey("id")) {
           return driver.findElement(By.id(map.get("id")));
        } else if (map.containsKey("tagName")) {
            return driver.findElement(By.tagName(map.get("tagName")));
        } else {
            System.out.println("Element not found");
        }
        return null;
    }

    public void enterTextField(WebDriver driver, String text, Element pageElement, String element) {
       WebElement locator = locator(driver,pageElement, element);
        if(locator==null){
            System.out.println("Locator not found");
        }
        else{
            locator.sendKeys(text);
        }
    }

    public void keyboardKey(WebDriver driver, String keyboardKey, Element pageElement,String element) {
        WebElement locator = locator(driver,pageElement, element);
        if(locator==null){
            System.out.println("Locator not found");
        }
        else if (keyboardKey=="Enter"){
            locator.sendKeys(Keys.ENTER);
        }
    }

    public void clickOnElement(WebDriver driver, Element pageElement, String element) {
        WebElement locator=null;
        try {
            locator = locator(driver, pageElement, element);
        }
        catch(NoSuchElementException e){
            System.out.println("Popup banner not displayed");
        }
        if(Objects.nonNull(locator)) {
            locator.click();
        }
        else{
            System.out.println("Element not found");
        }

    }
}

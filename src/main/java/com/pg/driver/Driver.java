package com.pg.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.ReadPropertyFile;

import java.io.IOException;
import java.util.Objects;

public final class Driver {
    private Driver(){

    }
   //static WebDriver driver;
   static public void initDriver() throws IOException {

        if (Objects.isNull(DriverManage.getDriver())) {
           // System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            //WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
            DriverManage.setDriver(new SafariDriver());
            DriverManage.getDriver().get(ReadPropertyFile.get("url"));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManage.getDriver())){
            DriverManage.getDriver().quit();
            DriverManage.unload();
        }
    }

    }

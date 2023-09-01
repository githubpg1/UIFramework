package com.pg.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManage {

    private DriverManage(){}
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }

    public static void unload(){
        driverThreadLocal.remove();
    }
}

package com.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

    static AppiumDriverLocalService service;

    private static AppiumDriver<MobileElement> driver;

    public static void runAppiumService(){

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();  //consolda log akmaması için
        service.start();
    }

    public static void stopAppiumService(){
        service.stop();
    }

    public static AppiumDriver<MobileElement> getDriver(Device device,App app){
        driver=new AndroidDriver<MobileElement>(service.getUrl(),setCapabilities(device,app));
        return driver;
    }

    private static DesiredCapabilities setCapabilities(Device device,App app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid",device.udid);
        capabilities.setCapability("appium:version",device.version);
        capabilities.setCapability("appium:deviceName",device.deviceName);
        capabilities.setCapability("appium:platformName",device.platformName);
        capabilities.setCapability("appPackage",app.appPackage);
        capabilities.setCapability("appActivity",app.appActivity);
        return capabilities;
    }

    //bu metodu driverı ilk kez tanımladıktan sonra tekrar çağırma ihtiyacı hissettiğinde kullanıyoruz.
    //Driver driver = new Driver();
    //driver.getDriver();
    public static AppiumDriver<MobileElement> getDriver(){
        return driver;
    }



}

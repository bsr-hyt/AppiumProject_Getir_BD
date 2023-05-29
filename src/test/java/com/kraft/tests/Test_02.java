package com.kraft.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_02 {

    //Appiumu cmd den açmak yerine intelijde appiumu kendi içinde çalıştırmak için service kurma;

    AppiumDriverLocalService service;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        //
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid","B1673511013");
        capabilities.setCapability("appium:version","8");
        capabilities.setCapability("appium:deviceName","GM8 go");
        capabilities.setCapability("appium:platformName","Android");
        //adb shell
        //* dumpsys window | grep -E mCurrentFocus
        //com.getir.casestudy.dev/com.getir.casestudy.modules.main.ui.MainActivity
        capabilities.setCapability("appPackage","com.getir.casestudy.dev");
        capabilities.setCapability("appActivity","com.getir.casestudy.modules.splash.ui.SplashActivity");

        //driver'ı ayarlayalım.
        AppiumDriver<MobileElement> driver;

        driver=new AndroidDriver<MobileElement>(service.getUrl(),capabilities);

//        Thread.sleep(2000);
        MobileElement userNameBox = driver.findElement(By.xpath("//*[@text='username']"));
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBox = driver.findElement(By.xpath("//*[@text='Submit']"));

//        Thread.sleep(2000);
        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBox.click();

        driver.closeApp();
        service.stop();
    }
}
//WenDriver --> driver --> url
//AppiumDriver --> driver --> cihaz --> app

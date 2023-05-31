package com.kraft.tests;

import com.utils.App;
import com.utils.Device;
import com.utils.Driver;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Test_04 {

    AppiumDriverLocalService service;
    Device device = Device.Redmi_8;
    App app = App.Getir;
    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {


        Driver.runAppiumService();

        driver = Driver.getDriver(Device.Redmi_8, App.Getir);

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


    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        driver = Utils.openApp(Device.Redmi_8, App.Getir);

        Thread.sleep(3000);
        MobileElement usernameBox = driver.findElement(By.xpath("//[@text='username']"));
        MobileElement passwordBox = driver.findElement(By.xpath("//[@text='password']"));
        MobileElement submitBtn = driver.findElement(By.xpath("//*[@text='Submit']"));
        Thread.sleep(3000);

        usernameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBtn.click();

        driver.closeApp();
        Driver.stopAppiumService();

    }
}

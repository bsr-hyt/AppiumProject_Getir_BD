package com.kraft.tests;

import com.utils.App;
import com.utils.Device;
import com.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_06 {

    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    By luserName = By.xpath("//*[@text='username']");

    @BeforeTest
    public void beforeTest() {
        Driver.runAppiumService();
        driver = Driver.getDriver(Device.Redmi_8, App.Getir);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterTest
    public void afterTest() {
        driver.closeApp();
        Driver.stopAppiumService();
    }

    @Test
    public void test1() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(luserName));

        MobileElement userNameBox = driver.findElement(luserName);
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBox = driver.findElement(By.xpath("//*[@text='Submit']"));

        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBox.click();
    }

}

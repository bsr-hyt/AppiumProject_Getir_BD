package com.kraft.tests;

import com.utils.App;
import com.utils.Device;
import com.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class Test_05 {

    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    By luserName = By.xpath("//*[@text='username']");

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        Driver.runAppiumService();
        driver=Driver.getDriver(Device.Redmi_8,App.Getir);

        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(luserName));

        MobileElement userNameBox = driver.findElement(luserName);
        MobileElement passwordBox = driver.findElement(By.xpath("//*[@text='password']"));
        MobileElement submitBox = driver.findElement(By.xpath("//*[@text='Submit']"));

//        Thread.sleep(2000);
        userNameBox.sendKeys("hello@getir.com");
        passwordBox.sendKeys("hello");
        submitBox.click();

        driver.closeApp();
    }

}

package com.kraft.tests;

import com.utils.App;
import com.utils.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class Test_03 {

    AppiumDriverLocalService service;
    Device device = Device.Redmi_8;
    App app = App.Getir;

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
        capabilities.setCapability("appium:udid",device.udid);
        capabilities.setCapability("appium:version",device.version);
        capabilities.setCapability("appium:deviceName",device.name());
        capabilities.setCapability("appium:platformName",device.platformName);
        //adb shell
        //* dumpsys window | grep -E mCurrentFocus
        //com.getir.casestudy.dev/com.getir.casestudy.modules.main.ui.MainActivity
        capabilities.setCapability("appPackage",app.appPackage);
        capabilities.setCapability("appActivity",app.appActivity);

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

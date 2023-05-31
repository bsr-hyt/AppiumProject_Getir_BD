package com.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

public class Utils {

    static AppiumDriver<MobileElement> driver=Driver.getDriver();
    public static AppiumDriver<MobileElement> openApp(Device device,App app){
        Driver.runAppiumService();
        //yukarda driverı import ettik.
//        Driver.runAppiumService();
        return Driver.getDriver(device, app);
    }

    public static void swipeV(double startPoint, double endPoint) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        new TouchAction<>(driver)
                .press(PointOption.point(width / 2, (int) (height * startPoint)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(width / 2, (int) (height * endPoint)))
                .release()
                .perform();
    }

    public static void swipeUntil(By locator, double start, double end){
        while(driver.findElements(locator).size()<=0){
            Utils.swipeV(start,end);
        }

    }

}

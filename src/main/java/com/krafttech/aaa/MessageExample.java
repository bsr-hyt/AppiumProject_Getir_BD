package com.krafttech.aaa;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public class MessageExample {

    static String xPathLocator = "{3}(//*[@text=\"{0}\"][{1}])[{2}]";

    public static void main(String[] args) {
        System.out.println(xPathofText("Profile"));

        System.out.println(xPathOfText2("Ahmet","3","5","//input"));

    }

    static By xPathofText(String tabName){
        String locator = "//*[@text='"+tabName+"']";
        return By.xpath(locator);
    }

    static By xPathOfText2(String... tabName){
        return By.xpath(MessageFormat.format(xPathLocator,tabName));
    }
}

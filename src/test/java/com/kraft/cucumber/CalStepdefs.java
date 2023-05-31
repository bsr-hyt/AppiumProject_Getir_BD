package com.kraft.cucumber;

import com.utils.App;
import com.utils.Device;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CalStepdefs {

    AppiumDriver<?> driver;
    @Given("The user is start page")
    public void theUserIsStartPage() {
        driver = Utils.openApp(Device.Redmi_8, App.Calculator);
    }

    @When("The user sum of following numbers")
    public void theUserSumOfFollowingNumbers(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        click(list.get(0));
        click("artı");
        click(list.get(1));
        click("artı");
        click(list.get(2));
        click("eşittir");

    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {
        String actualNumber = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assert.assertEquals(Integer.parseInt(actualNumber),result);
    }


    void click(int num){
        driver.findElement(By.xpath("//*[@content-desc='"+num+"']"));
    }

    void click(String operation){
        driver.findElement(By.xpath("//*[@content-desc='"+operation+"']"));
    }


}

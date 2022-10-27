package Functions;

import ObjectRepository.PageObjects;
import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class CommonFunctions extends Base {


    public CommonFunctions() throws IOException {
    }

    PageObjects po = new PageObjects(driver);

    public void convertFlow() {
        po.getAmount().sendKeys("5");
        po.getFrom().sendKeys("USD");
        po.getFrom().sendKeys(Keys.ENTER);
        po.getTo().sendKeys("INR");
        po.getTo().sendKeys(Keys.ENTER);
        po.getConvert().click();
    }

    public void dataFlow() throws InterruptedException {
        Thread.sleep(10000);
        Actions a = new Actions(driver);
        a.moveByOffset(70, 70).click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(po.getAfterConvert()));

        String s = po.getLine1().substring(7, 15);
        double d = Double.parseDouble(s);
        d = d * 5;
        String expected_amount = String.valueOf(d);
        expected_amount = expected_amount.substring(0, 6);

        String actual_amount = po.getConvertedAmount().substring(0, 6);

        Assert.assertEquals(actual_amount, expected_amount);
        System.out.println("Converted amount is: " + po.getConvertedAmount());
    }
}

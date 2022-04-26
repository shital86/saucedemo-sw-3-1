package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl="https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        clickOnElement(By.xpath("//input[@id='login-button']"));

        verifyText("PRODUCTS",By.className("title"),"Product");
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        clickOnElement(By.xpath("//input[@id='login-button']"));

        List<WebElement> number= driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualnumber=number.size();
        int expectednumber= 6;
        Assert.assertEquals("6 product not displayed",expectednumber,actualnumber);

    }
    @After
    public void close(){
        driver.close();
    }
}

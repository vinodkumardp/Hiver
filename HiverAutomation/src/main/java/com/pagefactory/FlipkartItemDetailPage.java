package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by vinoddp on 17/10/19.
 */
public class FlipkartItemDetailPage {

    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[text()='ADD TO CART']")
    public WebElement addtocart;

    @FindBy(how = How.XPATH, using = "//div[@class='_3xFQAD']//span")
    public WebElement price;

    @FindBy(how = How.XPATH, using = "//button[text()='+']")
    public WebElement increasequantity;

    public FlipkartItemDetailPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //get price of pixel 3a
    public String getPrice() throws InterruptedException {

        Thread.sleep(8000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        addtocart.click();
        Thread.sleep(5000);
        increasequantity.click();
        //return price.getText();
        Thread.sleep(5000);
        String[] s1 = price.getText().split("₹");
        return s1[1];
    }

    //get price of iphone 7 plus
    public String getiphone7plusPrice() throws InterruptedException {

        Thread.sleep(8000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        addtocart.click();
        Thread.sleep(5000);
        String[] s1 = price.getText().split("₹");
        return s1[1];
    }

}

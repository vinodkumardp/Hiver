package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;

/**
 * Created by vinoddp on 17/10/19.
 */
public class AmazonItemDetailPage {

    final WebDriver driver;
    @FindBy(how = How.ID, using = "add-to-cart-button")
    public WebElement addtocart;

    @FindBy(how = How.XPATH, using = "//div[@class='a-row a-spacing-micro']//span[2]")
    public WebElement price;

    public AmazonItemDetailPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Check price of mobile added in cart
    public String checkprice() throws InterruptedException
    {
        Thread.sleep(8000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        addtocart.click();
        Thread.sleep(5000);
        return price.getText();
    }

}

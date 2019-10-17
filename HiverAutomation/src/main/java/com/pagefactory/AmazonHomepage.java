package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vinoddp on 16/10/19.
 */
public class AmazonHomepage {

    final WebDriver driver;
    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    public WebElement searchbox;

    @FindBy(how = How.XPATH, using = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
    public WebElement searchicon;


    @FindBy(how = How.XPATH, using = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Apple iPhone 7 Plus (Jet Black, 3GB RAM, 128GB Sto')]")
    public WebElement purchaseitem;

    public AmazonHomepage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Launch Amazon website
    public void launchAmazon()
    {
        driver.get("https://www.amazon.in/");
    }

    //Select an iphone 7 plus
    public void selectIphone()
    {
        searchbox.sendKeys("Apple iPhone 7 Plus (Jet Black, 3GB RAM, 128GB Storage)");
        searchicon.click();
        purchaseitem.click();

    }

}


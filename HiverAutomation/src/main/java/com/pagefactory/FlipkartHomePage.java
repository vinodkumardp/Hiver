package com.pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by vinoddp on 17/10/19.
 */
public class FlipkartHomePage {

    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Electronics')]")
    public WebElement electronics;

    @FindBy(how = How.LINK_TEXT, using = "Pixel 3a | 3a XL")
    public WebElement pixel3a;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Google Pixel 3a (Clearly White, 64 GB)')]")
    public WebElement pixel3aitem;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
    public WebElement searchbox;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Apple iPhone 7 Plus (Jet Black, 128 GB)')]")
    public WebElement iphone7plusitem;

    @FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _29YdH8']")
    public WebElement closelogin;




    public FlipkartHomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    //Launch Flipkart site
    public void launchFlipkart()
    {
        driver.get("https://www.flipkart.com/");
    }

    //Select pixel3a
    public void selectpixel3a()
    {
        closelogin.click();
        electronics.click();
        pixel3a.click();
        pixel3aitem.click();
    }

    //select iphone 7 plus
    public void selectiphone7plus()
    {
        closelogin.click();
        searchbox.click();
        searchbox.sendKeys("apple iphone 7 plus (jet black, 128 gb)");
        searchbox.sendKeys(Keys.ENTER);
        iphone7plusitem.click();
    }

}

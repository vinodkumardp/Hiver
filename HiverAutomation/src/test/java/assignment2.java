import com.pagefactory.AmazonHomepage;
import com.pagefactory.AmazonItemDetailPage;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.pagefactory.FlipkartHomePage;
import com.pagefactory.FlipkartItemDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.NumberFormat;

import java.util.concurrent.TimeUnit;

/**
 * Created by vinoddp on 17/10/19.
 */
public class assignment2 {

    WebDriver driver;
    FlipkartHomePage flipkarthomepage;
    FlipkartItemDetailPage flipkartitemdetail;
    AmazonHomepage amazonhomepage;
    AmazonItemDetailPage amazonitemdetail;
    String iphonepriceamazon;
    String iphonepriceflipkart;

    @BeforeTest
    public void beforeMethod() {

        System.setProperty("webdriver.gecko.driver", "/Users/vinoddp/Documents/personal/Selenium/geckodriver");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        flipkarthomepage = PageFactory.initElements(driver, FlipkartHomePage.class);

        flipkartitemdetail = PageFactory.initElements(driver, FlipkartItemDetailPage.class);

        amazonhomepage = PageFactory.initElements(driver, AmazonHomepage.class);

        amazonitemdetail = PageFactory.initElements(driver, AmazonItemDetailPage.class);
    }

    @Test
    public void iphonepricecompare() throws Exception
    {
        amazonhomepage.launchAmazon();
        amazonhomepage.selectIphone();
        iphonepriceamazon=amazonitemdetail.checkprice();
        flipkarthomepage.launchFlipkart();
        flipkarthomepage.selectiphone7plus();
        iphonepriceflipkart=flipkartitemdetail.getiphone7plusPrice();
        if(Integer.parseInt(iphonepriceamazon.replaceAll(",", "")) > Integer.parseInt(iphonepriceflipkart.replaceAll(",", ""))) {
        Reporter.log("Price of the phone is cheaper in Flipkart which is " + iphonepriceflipkart);
            System.out.println("Price of the phone is cheaper in Flipkart which is " + iphonepriceflipkart);
        }
        else {
            Reporter.log("Price of the phone is cheaper in Amazon which is " + iphonepriceamazon);
            System.out.println("Price of the phone is cheaper in Amazon which is " + iphonepriceamazon);
        }

    }

    @AfterTest
    public void afterMethod()
    {
        driver.quit();
    }


}

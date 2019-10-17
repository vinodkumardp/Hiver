import com.pagefactory.FlipkartHomePage;
import com.pagefactory.FlipkartItemDetailPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


/**
 * Created by vinoddp on 16/10/19.
 */
public class assignment1 {

    WebDriver driver;
    FlipkartHomePage homepage;
    FlipkartItemDetailPage itemdetail;
    String phonesprice;

    @BeforeTest
    public void beforeMethod() {

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homepage = PageFactory.initElements(driver, FlipkartHomePage.class);

        itemdetail = PageFactory.initElements(driver, FlipkartItemDetailPage.class);
    }

    @Test
    public void Pixel3aPrice() throws Exception
    {
        homepage.launchFlipkart();
        homepage.selectpixel3a();
        phonesprice = itemdetail.getPrice();
        Reporter.log("Phone price : " + phonesprice);
        System.out.println("Phone price : " + phonesprice);
    }

    @AfterTest
    public void afterMethod()
    {
        driver.quit();
    }

}

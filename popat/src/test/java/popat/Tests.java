package popat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



public class Tests {

    WebDriver driver;



    @BeforeClass
    public void setup() throws MalformedURLException {
        String nodeUrl = " http://192.168.0.151:20628/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL(nodeUrl), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://gmail.com/");


    }

    @Test(priority = 1, description = "Check sending message")
    @Description("Check sending messag.......")
    @Epic("EPIC001")
    @Feature("Feature1: Send email")
    @Story("Story: Email send")
    @Severity(SeverityLevel.BLOCKER)
    public void clickEmail() {
        IdPage idp = PageFactory.initElements(driver, IdPage.class);
        idp.enterEmail("testgmln@gmail.com");
        GmailPageObjects gp = PageFactory.initElements(driver, GmailPageObjects.class);
        gp.enterPassword("smbtestgm");
        ClickPage cp = PageFactory.initElements(driver, ClickPage.class);
        cp.sendEmail("Елена Арсланова", "testgmln@gmail.com");
        cp.waitVisible(driver);



    }

    @AfterClass
    public void tesrDown() throws InterruptedException {
        driver.quit();
    }
}
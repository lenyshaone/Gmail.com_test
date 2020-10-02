package popat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='yW']")
    List < WebElement > emailThreads;

    @FindBy(xpath = "//span[@class='gb_bb gbii']")
    WebElement profileLogo;

    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    WebElement sendLettrs;

    @FindBy(xpath = "//textarea[@name='to']")
    WebElement toEmail;

    @FindBy(xpath = "//input[@name='subjectbox']")
    WebElement subjectboxEmail;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    WebElement textEmail;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    WebElement lettersEmail;
    @FindBy(xpath = "//div[@class='vh']")
    WebElement waittest;

    int l = 0;
    public void letters(String surname) {
        int ln = 0;
        for (int i = 0; i < emailThreads.size(); i++) {
            if (emailThreads.get(i).getText().contains(surname)) {
                ln = ln + 1;
                l = ln;
            }
        }
    }
    public void sendEmail(String surname, String emailID) {

        letters(surname);
        sendLettrs.click();
        toEmail.sendKeys(emailID + Keys.ENTER);
        subjectboxEmail.sendKeys("Test task. <Arslanova>" + Keys.ENTER);
        textEmail.sendKeys(String.valueOf(l) + " letters from: " + surname);
        lettersEmail.click();

    }
    public void waitVisible(WebDriver driver) {
        (new WebDriverWait(driver, 10))
        .until(ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector(".b8 .bBe .bBf")));
    }




}
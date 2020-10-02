package popat;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GmailPageObjects {


    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;


    public void enterPassword(String password) {

        passwordField.click();
        passwordField.sendKeys(password + Keys.ENTER);
    }
}
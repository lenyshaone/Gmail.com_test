package popat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IdPage {


    @FindBy(xpath = "//input[@id='identifierId']")
    WebElement emailField;

    
    
    public void enterEmail(String emailID) {

        emailField.click();
        emailField.sendKeys(emailID + Keys.ENTER);
    }
}
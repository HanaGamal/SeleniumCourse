package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    WebDriver driver;
    private By email= By.id("email");
    private By retreiveButton=By.id("form_submit");

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }
    public void setemail(String emails){
        driver.findElement(email).sendKeys(emails);
    }
    public EmailSentPage retreiveButtonClick(){
        driver.findElement(retreiveButton).click();
        return new EmailSentPage(driver);
    }

}

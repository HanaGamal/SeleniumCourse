package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By statusAlert = By.id("flash");
    public SecureAreaPage(WebDriver driver){
        this.driver=driver;
    }
    public String getAlert(){
        return driver.findElement(statusAlert).getText(); //get text inside of this element
    }
}

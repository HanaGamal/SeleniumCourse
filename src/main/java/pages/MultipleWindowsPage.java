package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {
    private WebDriver driver;
    private By clickHereButton= By.cssSelector(".example a");

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setClickHereButton(){
        driver.findElement(clickHereButton).click();
    }
}

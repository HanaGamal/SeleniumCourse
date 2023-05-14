package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By firstLink= By.xpath("(//div[@class='example']/a)[1]");
    private By secondLink= By.xpath("(//div[@class='example']/a)[2]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
    public DynamicLoadingExample1Page clickfirstLink(){
        driver.findElement(firstLink).click();
        return new DynamicLoadingExample1Page(driver);
    }
    public DynamicLoadingExample2Page clicksecondLink(){
        driver.findElement(secondLink).click();
        return new DynamicLoadingExample2Page(driver);
    }
    public DynamicLoadingExample2Page openLinkInNewTab(){
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(driver.findElement(secondLink)).keyUp(Keys.CONTROL).build().perform();
        return new DynamicLoadingExample2Page(driver);
    }
}

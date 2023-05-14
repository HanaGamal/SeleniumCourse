package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By startButton= By.cssSelector("#start button");
    private By loadIndicator=By.id("loading");
    private By loadText=By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }
    public void clickstart(){
        driver.findElement(startButton).click();
        /*FluentWait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadIndicator)));*/
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadIndicator)));//wait for an element to disappear

    }

    public String getLoadedText(){
        return driver.findElement(loadText).getText();
    }

    public void verifyStartButton(){
        WebElement startButtons=null;
        try {
            startButtons=driver.findElement(startButton);
        }catch (NoSuchElementException e){
            System.out.println("start button is not found");
        }
        if(startButtons!=null)System.out.println("start button is found");
    }
}

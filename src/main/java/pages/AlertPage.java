package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    private By triggerAlertButton= By.xpath("//button[text()='Click for JS Alert']");
    private By triggerConfirmButton= By.xpath("//button[text()='Click for JS Confirm']");
    private By triggerPromptButton= By.xpath("//button[text()='Click for JS Prompt']");

    private By buttonMsg=By.id("result");
    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }
    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();//used to click ok on the alert
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }
    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }
    public void enterText_inPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public void confirm_clickToCancel(){
        driver.switchTo().alert().dismiss();
    }
    public String confirm_getText(){
        return driver.switchTo().alert().getText();
    }
    public String getMsg(){
        return driver.findElement(buttonMsg).getText();
    }
}

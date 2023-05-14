package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage {
    private WebDriver driver;
    private String iframeId="mce_0_ifr";
    private By textArea= By.id("tinymce");
    private By indentationButton=By.xpath("//button[@title='Increase indent']");

    public EditorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clearTextArea(){//used to clear text inside the iframe
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    private void switchToEditArea(){
        driver.switchTo().frame(iframeId);
    }
    //to exit the iframe
    private void switchToMainArea(){//without this function it will not find the identation button
        driver.switchTo().parentFrame();
    }
    public void clickIndentation(){
        driver.findElement(indentationButton).click();
    }
    public String getTextFromIframe(){
        switchToEditArea();
        String text=driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
}

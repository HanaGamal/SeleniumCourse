package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private By nestedFramesButton=By.xpath("(//ul/li/a)[1]");

    private By framepath=By.xpath("//html/body");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickNestedFrames(){
        driver.findElement(nestedFramesButton).click();
    }
    private void switchtoleftframe(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
    }
    private void switchtobottomframe(){
        driver.switchTo().frame("frame-bottom");
    }
    private void switchtoMain(){
        driver.switchTo().parentFrame();

    }
    public String getleftFrameText(){
        switchtoleftframe();
        String text=driver.findElement(framepath).getText();
        switchtoMain();
        switchtoMain();
        return text;
    }
    public String getbottomFrameText(){
        switchtobottomframe();
        String text=driver.findElement(framepath).getText();
        switchtoMain();
        return text;
    }


}

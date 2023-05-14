package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By scrollText=By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollDown(int index){
        //scroll to function in javascript 0 means no horizontal scrolling
        //only scroll vertically
        String script="window.scrollTo(0, document.body.scrollHeight)";
        while (getNumofParagraphs()<index){
            ((JavascriptExecutor)driver).executeScript(script);
        }
    }
    private int getNumofParagraphs(){
        return driver.findElements(scrollText).size();
    }
}

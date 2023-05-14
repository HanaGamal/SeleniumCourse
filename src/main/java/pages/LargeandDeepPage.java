package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeandDeepPage {
    private WebDriver driver;
    private By table= By.id("large-table");

    public LargeandDeepPage(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToTable(){
        WebElement tableelement=driver.findElement(table);
        String script="arguments[0].scrollIntoView();";
        //allow executing javascript
        //to cast driver to javascript executor
        ((JavascriptExecutor)driver).executeScript(script,tableelement);
        //it will replace argument [0] with tableelement
    }
}

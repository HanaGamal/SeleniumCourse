package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {
    WebDriver driver;
    private By figureBox=By.className("figure");
    private By bocCaption=By.className("figcaption");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }
    //use actions to hover over any figure
    public FigureCaption hoverOverFigure(int index){
        WebElement figure=driver.findElements(figureBox).get(index-1);
        //WebElement figure=driver.findElement(By.xpath("(//div[contains(@class,'figure')])[" + index + "]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(figure).perform();//used to hover
        return new FigureCaption(driver.findElement(figureBox));
    }
    //create inner class for figure caption which appears after hovering over the image
    public class FigureCaption {
        private WebElement caption;
        private By header=By.tagName("h5");
        private By link=By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }
        public String getTitle(){
            return caption.findElement(header).getText();
        }
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }
        //the same function as getLink but return link text not the link in href attribute
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider= By.cssSelector(".sliderContainer input");
    private By span=By.tagName("span");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSpan(){
        return driver.findElement(span).getText();
    }
    public void selectSlider(){
        driver.findElement(slider).click();
    }
    public void moveSlider(int value){

        while(Float.parseFloat(getSpan())!=value){
            if(Float.parseFloat(getSpan())>value){
                driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
            }
            if(Float.parseFloat(getSpan())<value){
                driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
            }
        }
    }
}

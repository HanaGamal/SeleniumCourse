package utils;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate=driver.navigate();
    }
    public void goBack(){
        navigate.back(); //to go back from the current page
    }
    public void goForward(){
        navigate.forward();
    }
    public void refreshPage(){
        navigate.refresh();
    }
    public void goToUrl(String url){
        navigate.to(url);
    }
    //to manage multiple tabs
    public void switchTab(String tabtitle){
        Set<String> windows=driver.getWindowHandles();//hold the address of all the windows unique identifiers
        //these handles change every time we run
        System.out.println("Number of tabs: "+windows.size());
        System.out.println("window handles");//created when the window run
        windows.forEach(System.out::println);
        for (String window:windows){
            System.out.println("Switching to window:  "+window);
            driver.switchTo().window(window);
            System.out.println("current window title is "+driver.getTitle());//to print the title of the window
            if(tabtitle.equals(driver.getTitle()))break;
        }
    }
    public void switchNewTab(){
        Set<String> windows=driver.getWindowHandles();

        for (String window:windows){
            System.out.println("Switching to window:  "+window);
            driver.switchTo().window(window);
            System.out.println("current window title is "+driver.getTitle());//to print the title of the window

        }
    }
}

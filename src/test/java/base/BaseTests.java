package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
        driver=new EventFiringWebDriver(new ChromeDriver(getchromeOptions()));//listen for events
        driver.register(new EventReporter());
        goHome();
        setCookie();
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); //like full screen of videos
        //to set screen size like doing with right click inspect copy the dimensions shown in inspect
        //driver.manage().window().setSize(new Dimension(375,812));

        /*List<WebElement> links=driver.findElements(By.tagName("a"));//get all elements with tag <a>
        System.out.println(links.size());
        //exception if try to find element that does not exist
        //WebElement inputlink= driver.findElement(By.linkText("Inputs"));
        //inputlink.click();
        WebElement shiftContentLink=driver.findElement(By.linkText("Shifting Content"));
        shiftContentLink.click();
        WebElement menuLink=driver.findElement(By.linkText("Example 1: Menu Element"));
        menuLink.click();
        List <WebElement> ulLinks=driver.findElements(By.cssSelector("ul>li"));
        System.out.println(ulLinks.size());
        System.out.println(driver.getTitle()); //get website title*/


        //close any opened window and clear session
        //driver.close();//close the window not the session
    }
    //to let test return to home page before starting the next test otherwise the entire class with
    //different tests would return an error
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage=new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @AfterMethod //run this method if the test failed ITestResult from the testng package
    //which is the result of the test
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera=(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);//save screenshot as file
            //System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
            try{
                //Files.move(screenshot.toPath(), Path.of(new File("screenshots/") + result.getName() + ".png"));
                Files.move(screenshot.toPath(), new File("screenshots/"+result.getName()+".png").toPath());
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    private ChromeOptions getchromeOptions(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");//to remove chrome is being controlled by automation test software
        //options.setHeadless(true);//run without opening the browser so it runs faster
        //run starts and no browser was opened
        ////////////
        return options;
    }
    private void setCookie(){
        Cookie cookie=new Cookie.Builder("tau","123").domain("the-internet.herokuapp.com").build();
        //that creates the cookie and we have to use driver inorder to set the cookie
        driver.manage().addCookie(cookie);
    }
}

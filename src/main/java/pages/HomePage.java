package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public LoginPage clickFormAuthen(){

        clickLink("Form Authentication");
        return new LoginPage(driver);
    }
    public DropdownPage clickDropdown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public ForgotPassword clickforgotPass(){
        clickLink("Forgot Password");
        return new ForgotPassword(driver);
    }
    public HoverPage clickHover(){
        clickLink("Hovers");
        return new HoverPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontal(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }
    public AlertPage clickJavascriptAlert(){
        clickLink("JavaScript Alerts");
        return new AlertPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }
    public EditorPage clickEditor(){
        clickLink("WYSIWYG Editor");
        return new EditorPage(driver);
    }
    public FramesPage clickFrames(){
        clickLink("Frames");
        return new FramesPage(driver);
    }
    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
    public LargeandDeepPage clickLargeandDeep(){
        clickLink("Large & Deep DOM");
        return new LargeandDeepPage(driver);
    }
    public InfiniteScrollPage clickInfiniteScrollPage(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }
    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
    private void clickLink(String linktext){
        driver.findElement(By.linkText(linktext)).click();
    }
}

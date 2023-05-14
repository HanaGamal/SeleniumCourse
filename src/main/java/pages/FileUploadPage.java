package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By chooseFileButton= By.id("file-upload");
    private By uploadFileButton=By.id("file-submit");
    private By uploadFileName=By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadFile(){
        driver.findElement(uploadFileButton).click();
    }
    public void uploadFile(String filepath){
        driver.findElement(chooseFileButton).sendKeys(filepath);
        clickUploadFile();
    }
    public String getuploadFileName(){
        return driver.findElement(uploadFileName).getText();
    }
}

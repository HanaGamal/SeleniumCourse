package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTest extends BaseTests {
    @Test
    public void uploadFileTest(){
        FileUploadPage fileUploadPage=homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\hp\\Pictures\\Saved Pictures\\practice.jpg");
        Assert.assertEquals(fileUploadPage.getuploadFileName(),"practice.jpg");
    }
}

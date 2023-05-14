package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTests {
    @Test
    public void testAlert(){
        AlertPage alertPage=homePage.clickJavascriptAlert();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        Assert.assertEquals(alertPage.getMsg(),"You successfully clicked an alert");
    }
    @Test
    public void testGetTextFromAlert(){
        AlertPage alertPage=homePage.clickJavascriptAlert();
        alertPage.triggerConfirm();
        String text=alertPage.confirm_getText();
        alertPage.confirm_clickToCancel();
        Assert.assertEquals(text,"I am a JS Confirm");
    }
    @Test
    public void testPrompt(){
        AlertPage alertPage=homePage.clickJavascriptAlert();
        alertPage.triggerPrompt();
        alertPage.enterText_inPrompt("tau");
        alertPage.alert_clickToAccept();
        Assert.assertEquals(alertPage.getMsg(), "You entered: "+"tau");
    }
}

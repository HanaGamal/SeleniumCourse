package wait;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;

public class WaitTest extends BaseTests {
    @Test
    public void testWaitExample1(){
        DynamicLoadingPage loadingPage=homePage.clickDynamicLoading();
        DynamicLoadingExample1Page loadingExample1Page=loadingPage.clickfirstLink();
        loadingExample1Page.clickStart();
        Assert.assertEquals(loadingExample1Page.getloadedtest(),"Hello World!");
    }
    @Test
    public void TestWaitExample2(){
        DynamicLoadingPage loadingPage=homePage.clickDynamicLoading();
        DynamicLoadingExample2Page loadPage=loadingPage.clicksecondLink();
        loadPage.clickstart();
        Assert.assertEquals(loadPage.getLoadedText(),"Hello World!");
    }
}

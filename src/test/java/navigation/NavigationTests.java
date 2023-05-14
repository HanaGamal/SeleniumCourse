package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickfirstLink();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goToUrl("https://google.com");
    }
    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().setClickHereButton();
        getWindowManager().switchTab("New Window");

    }
    @Test
    public void testOpenLinkInNewTab(){
        DynamicLoadingPage page1=homePage.clickDynamicLoading();
        DynamicLoadingExample2Page page2=page1.openLinkInNewTab();
        getWindowManager().switchNewTab();
        page2.verifyStartButton();

    }
}

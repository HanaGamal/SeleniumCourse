package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;
import pages.LargeandDeepPage;

public class JavascriptTests extends BaseTests {
    @Test
    public void testScrollToTable(){
        LargeandDeepPage page=homePage.clickLargeandDeep();
        page.scrollToTable();

    }
    @Test
    public void testInfiniteScroll(){
        InfiniteScrollPage page=homePage.clickInfiniteScrollPage();
        page.scrollDown(5);
    }
}

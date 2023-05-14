package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends BaseTests {
    @Test
    public void contextmenuTest(){
        ContextMenuPage contextMenuPage=homePage.clickContextMenu();
        contextMenuPage.rightClickContextBox();
        String text=contextMenuPage.getalerttext();
        contextMenuPage.alert_accept();
        Assert.assertEquals(text,"You selected a context menu","not correct");
    }
}

package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoverPage;

public class HoverTest extends BaseTests {
    @Test
    public void testHoverUser1(){
        HoverPage hoverPage = homePage.clickHover();
       HoverPage.FigureCaption figureCaption=hoverPage.hoverOverFigure(1);
        Assert.assertTrue(figureCaption.isCaptionDisplayed(),"caption is not displayed");
        Assert.assertEquals(figureCaption.getTitle(),"name: user1","title is incorrect");
        Assert.assertEquals(figureCaption.getLinkText(),"View profile","link is incorrect");
        Assert.assertTrue(figureCaption.getLink().endsWith("/users/1"),"link is incorrect");

    }
}

package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;

public class NestedFrametest extends BaseTests {
    @Test
    public void testNestedFrames(){
        FramesPage framesPage=homePage.clickFrames();
        framesPage.clickNestedFrames();
        Assert.assertEquals(framesPage.getleftFrameText(),"LEFT");
        Assert.assertEquals(framesPage.getbottomFrameText(),"BOTTOM");
    }
}

package frames;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditorPage;

public class FrameTest extends BaseTests {
    @Test
    public void testwisywygEditor(){
        EditorPage editorPage=homePage.clickEditor();
        editorPage.clearTextArea();
        String text1="hello";
        String text2=" world";
        editorPage.setTextArea(text1);
        editorPage.clickIndentation();
        editorPage.setTextArea(text2);
        Assert.assertEquals(editorPage.getTextFromIframe(),text1+text2);


    }
}

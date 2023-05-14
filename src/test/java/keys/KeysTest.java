package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeysTest extends BaseTests {
    @Test
    public void testBackSpace(){
        KeyPressesPage keyPressesPage=homePage.clickKeyPresses();
        keyPressesPage.enterText("A"+ Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.getResultText(),"You entered: BACK_SPACE");
    }
    @Test
    public void testAtSymbol(){
        KeyPressesPage keyPressesPage=homePage.clickKeyPresses();
        keyPressesPage.enteratSymbol();
        Assert.assertEquals(keyPressesPage.getResultText(),"You entered: 2");
    }
}

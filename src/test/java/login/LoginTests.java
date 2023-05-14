package login;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

//no need to repeat code in basetests class so inherit instead
public class LoginTests extends BaseTests{
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage=homePage.clickFormAuthen();
        loginPage.setusername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage=loginPage.clickLogin();
        //Assert.assertEquals(secureAreaPage.getAlert()," You logged into a secure area!","alert text is incorrect");
        Assert.assertTrue(secureAreaPage.getAlert().contains("You logged into a secure area!"),"alert" +
                "text is incorrect");
    }
}

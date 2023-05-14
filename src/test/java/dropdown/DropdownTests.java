package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        DropdownPage dropdownPage= homePage.clickDropdown();
        dropdownPage.selectfromDropdown("Option 1");
        //to be sure which option was selected
        List <String> selectedOptions= dropdownPage.getselectedOptions();
        Assert.assertEquals(selectedOptions.size(),1,"incorrect number of selections");
        Assert.assertTrue(selectedOptions.contains("Option 1"), "option not selected");
    }
    @Test
    public void testMultipleSelector(){
        DropdownPage page=homePage.clickDropdown();
        page.changeToMulitpleSelector();
        page.selectfromDropdown("Option 1");
        page.selectfromDropdown("Option 2");
        List <String> selectedOptions= page.getselectedOptions();
        Assert.assertEquals(selectedOptions.size(),2,"incorrect number of selections");
    }
}

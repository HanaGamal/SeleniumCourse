package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown= By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver=driver;
    }
    public void selectfromDropdown(String option){

        findDropdownelement().selectByVisibleText(option);

    }
    public List<String> getselectedOptions(){
        List <WebElement> selectedElements=findDropdownelement().getAllSelectedOptions();
        //retrieves the text content of each selected element and stores it in a new list.
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownelement(){
        return new Select(driver.findElement(dropdown));
    }

    public void changeToMulitpleSelector(){
        WebElement dropdownelement=driver.findElement(dropdown);
        String script="arguments[0].setAttribute('multiple', '')";
        ((JavascriptExecutor)driver).executeScript(script,dropdownelement);
    }
}

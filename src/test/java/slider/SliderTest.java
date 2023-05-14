package slider;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class SliderTest extends BaseTests {
    @Test
    public void slidertest(){
        HorizontalSliderPage horizontalSliderPage=homePage.clickHorizontal();
        horizontalSliderPage.selectSlider();
        horizontalSliderPage.moveSlider(4);
        System.out.println(horizontalSliderPage.getSpan());
        Assert.assertEquals(horizontalSliderPage.getSpan(),"4");
    }
}

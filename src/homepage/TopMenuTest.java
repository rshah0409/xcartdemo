package homepage;

import browsertesting.BaseTest;
import org.junit.*;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    @Before
    public  void openBrowser() {
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }
    @Test
            public  void verifyUserShouldNavigateToShippingpageSuccessfully(){

        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[3]/a/span"));
        String expectedText = "Shipping";
        String actualText = getTextFromElement(By.xpath("//h1[text()='Shipping']"));
        Assert.assertEquals("User Is Not On Shipping page", expectedText, actualText);

    }@Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[4]/a/span"));
        String expectedNew = "New arrivals";
        String actualNew = getTextFromElement(By.xpath("//h1[text()='New arrivals']"));
        Assert.assertEquals("User Is Not On New Arrival Page",expectedNew,actualNew);
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){

        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[5]/a"));
        String expectedComingsoon = "Coming soon";
        String actualComingSoon = getTextFromElement(By.xpath("//h1[text()='Coming soon']"));
        Assert.assertEquals("User Is Not On CominSoon Page",expectedComingsoon,actualComingSoon);
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[6]/a"));
        String expectedContactUs = "Contact us";
        String actualContactUs = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User Is Not On Contact Us Page",expectedContactUs,actualContactUs);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }



}

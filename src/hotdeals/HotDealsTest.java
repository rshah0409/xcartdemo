package hotdeals;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotDealsTest extends BaseTest {
    @Before
    public void openUrl() {
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));
        // mouseHoverToElement(By.xpath("//span[text()='Hot deals']/parent::li/ancestor::ul/descendant::ul"));  //mouse hover to 'hot deals'
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));
        // clickOnElement(By.xpath("//a[text()='Sale']/parent::li"));  //click on sales
        String saleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a")); //click on 'A to Z'
        //  clickOnElement(By.xpath("//a[@data-sort-by='translations.name']/parent::li/ancestor::ul")); // click on 'a to z'
        String expectedFirstProduct = "Name A - Z";
        String actualFirstProduct = getTextFromElement(By.xpath("//span[text()='Name A - Z']"));
        Assert.assertEquals("products are Not In Alphabetical Order", expectedFirstProduct, actualFirstProduct);

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span")); //click on sale
        String saleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Sales Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[3]/a"));  //click on price'low to high'
        String expectedSortBy = "Price Low - High";
        String actualSortBy = getTextFromElement(By.xpath("//span[text()='Price Low - High']"));
        Assert.assertEquals("Products Are Not Sorted In price Low to High", expectedSortBy, actualSortBy);
    }

    @Test
    public void verifySaleProductsArrangeByRates() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span")); //click on sale
        String saleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Sales Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[7]/a"));  //click on Rates
        String expectedSortBy = "Rates";
        String actualSortBy = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Products Are Not Sorted In Rates", expectedSortBy, actualSortBy);
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[5]/a")); //click on'Z To A'
        // clickOnElement(By.xpath("//a[@data-sort-order='desc']/parent::li/ancestor::ul") ); //click on 'z to a'
        String expectedSortBy = "Name Z - A";
        String actualSortBy = getTextFromElement(By.xpath("//span[text()='Name Z - A']"));
        Assert.assertEquals("Products Are Not Sorted In Rates", expectedSortBy, actualSortBy);
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[3]/a")); //click on'Price High-Low''
        String expectedSortBy = "Price High - Low";
        String actualSortBy = getTextFromElement(By.xpath("//span[text()='Price High - Low']"));
        Assert.assertEquals("Products Are Not Sorted In Rates", expectedSortBy, actualSortBy);
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[6]/a")); //click on'Rates'
        String expectedSortBy = "Rates";
        String actualSortBy = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Products Are Not Sorted In Rates", expectedSortBy, actualSortBy);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

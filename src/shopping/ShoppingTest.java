package shopping;

import browsertesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class ShoppingTest extends BaseTest {
    @Before
    public void openBrowser() {
        String baseUrl = "https://mobile.x-cart.com/";
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengers() throws InterruptedException {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));   //mouse hover to 'hot deals'
        // mouseHoverToElement(By.xpath("//span[text()='Hot deals']/parent::li/ancestor::ul/descendant::ul"));  //mouse hover to 'hot deals'
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span"));//click on sales
        // clickOnElement(By.xpath("//a[text()='Sale']/parent::li"));  //click on sales
        String saleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a")); //click on 'A to Z'
        Thread.sleep(2000);
        clickOnElement(By.xpath("//img[@alt='Avengers: Fabrikations Plush [Related Products]']"));
        clickOnElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/div[4]/div[3]/ul/li[2]/label/div/input[2]")); //check box of product
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/form[2]/div[2]/div[1]/div[3]/button[1]"));
        Thread.sleep(3000);
        String expectedCartText = "Product has been added to your cart";   //assert for add to cart
        String actualCartText = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Product Has Not Been Added To The Cart", expectedCartText, actualCartText);
        clickOnElement(By.xpath("//a[@class='close']"));//click on close sign
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click on your cart
        clickOnElement(By.xpath("//a[@class='regular-button cart']")); //click on view cart
        String shopCarttext = "Your shopping cart - 1 item";
        String realShopCart = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User's Items Have Not Been Added To Cart", shopCarttext, realShopCart);
        driver.findElement(By.id("amount16")).clear();//clear qauntity '1'
        driver.findElement(By.id("amount16")).click(); //click on quantity field
        driver.findElement(By.id("amount16")).sendKeys("2");
        String shoppingCartText = "Your shopping cart - 2 items";    //verify 2 items in cart
        String shoppingcartReal = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Cart Does nOt Have 2 Items", shoppingCartText, shoppingcartReal);
        String subTotalText = "Subtotal: $59.98";                 //verify subtotal
        String subTotalTextReal = getTextFromElement(By.xpath("//span[@class='cart-subtotal']/parent::li/ancestor::ul"));
        Assert.assertEquals("SubTotal Is Wrong", subTotalText, subTotalTextReal);
        String totalText = "$66.53";                     //verify Total
        String totalTextActual = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total Is Incorrect", totalText, totalTextActual);
        clickOnElement(By.xpath("//span[text()='Go to checkout']")); //click on check out.
        String logText = "Log in to your account";                   //verify login account page
        String logTextReal = getTextFromElement(By.xpath("//h3[text()='Log in to your account']"));
        Assert.assertEquals("User Is Not On Login your Account Page", logText, logTextReal);
        sendTextToElement(By.id("email"), "primeb@gmail.com");  //enter email id(needs to be changed before running everytime)
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));  //click on continue
        String secureText = "Secure Checkout";                            //verify secure checkout text
        String secureTextReal = getTextFromElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("User Is Not On secureCheckout page", secureText, secureTextReal);
        sendTextToElement(By.id("shippingaddress-firstname"), "Sheldon");  //firstname
        sendTextToElement(By.id("shippingaddress-lastname"), "Cooper");  //lastname
        sendTextToElement(By.id("shippingaddress-street"), "42,Wallby street"); //address
        driver.findElement(By.id("shippingaddress-city")).clear();  //clear city
        sendTextToElement(By.id("shippingaddress-city"), "London");  //city
        selectByValueFromDropDown(By.id("shippingaddress-country-code"), "GB"); //country
        sendTextToElement(By.id("shippingaddress-custom-state"), "Watford"); //state
        driver.findElement(By.id("shippingaddress-zipcode")).clear();  //clear postcode
        sendTextToElement(By.id("shippingaddress-zipcode"), "wd24 3en");  //postcode
        clickOnElement(By.id("create_profile"));                  //tick on checkbox
        sendTextToElement(By.id("password"), "sheldonisgreat"); //password
        clickOnElement(By.id("method128"));             //local shipping delievery method
        Thread.sleep(1000);
        clickOnElement(By.id("pmethod6"));               //payment method COD
        String expectedTotal = "$66.53";                  //verify total
        String actualTotal = getTextFromElement(By.xpath("//div[@class='total clearfix']"));
        Assert.assertEquals("Total Is Wrong", expectedTotal, actualTotal);
        Thread.sleep(3000);
        clickOnElement(By.xpath("//span[text()='Place order: $67.59']/parent::button")); //click on place order button
        String thankyouText = "Thank you for your order";    //verifying thank you page
        String thankyouTextReal = getTextFromElement(By.xpath("//h1[text()='Thank you for your order']"));
        Assert.assertEquals("Order Has Not Been Placed ", thankyouText, thankyouTextReal);
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span")); //mouse hover to hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span")); //click on Best seller
        String saleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Is Not On Best Sellers Page", saleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']")); //move mouse to 'sort by'
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[4]/a")); //click on 'A to Z'
        mouseHoverToElement(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));    //mouse hover to ghostbuster
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']")); //click on add to cart button.
        String expectedCartText = "Product has been added to your cart";   //assert for add to cart
        String actualCartText = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Product Has Not Been Added To The Cart", expectedCartText, actualCartText);
        clickOnElement(By.xpath("//a[@class='close']"));//click on close sign
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//click on your cart
        clickOnElement(By.xpath("//a[@class='regular-button cart']")); //click on view cart
        String shopCarttext = "Your shopping cart - 1 item";
        String realShopCart = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User's Items Have Not Been Added To Cart", shopCarttext, realShopCart);
        clickOnElement(By.xpath("//a[text()='Empty your cart']"));  //click on empty your cart
        String emptyCartText = "Are you sure you want to clear your cart?";
        String emptyCartTextActual = driver.switchTo().alert().getText();  //to get text from element that cant be inspected with right click.
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartText, emptyCartTextActual);
        driver.switchTo().alert().accept();               //to click 'ok' on alert window when no right click available to inspect
        String empryCartText = "Item(s) deleted from your cart";            //verifying empty cart green bar
        String emptyCartTextActualIs = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Customer's Cart Is Not Empty", empryCartText, emptyCartTextActualIs);
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Your cart is empty message is wrong", lastEmptyCartMessage, actualLastEmptyCartMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}

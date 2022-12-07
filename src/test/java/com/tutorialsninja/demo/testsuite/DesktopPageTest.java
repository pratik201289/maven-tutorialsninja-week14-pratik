package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopPageTest extends BaseTest {

    DesktopPage desktopsPage =new DesktopPage();
    HomePage homePage =new HomePage();
    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException{
        homePage.hoverAndClickOnDesktop();
        desktopsPage.clickOnShowAllDesktops();
        desktopsPage.sortByNameAToZ();
        desktopsPage.clickOnHpLp3065();
        String expectedText = "HP LP3065";
        Assert.assertEquals(desktopsPage.getHpLaptopText(),expectedText,"HP LP3065 is not displayed");
        desktopsPage.clearQuantityField();
        desktopsPage.changeTheQuantity();
        desktopsPage.clickOnAddToCartButton();
        String expectedSuccessText = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(desktopsPage.getSuccessMessage(),expectedSuccessText,"Success message is not displayed");
        Thread.sleep(5000);
        desktopsPage.clickOnShoppingCartText();
        String expectedMessage = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(desktopsPage.getShoppingCartText(),expectedMessage,"Shopping cart is not displayed");
        String expectedProductName = "HP LP3065";
        Assert.assertEquals(desktopsPage.getProductName(),expectedProductName,"HP LP3065 is not displayed");
        String expectedModelName ="Product 21";
        Assert.assertEquals(desktopsPage.getProductModelName(),expectedModelName,"Product 21 is not displayed");
        desktopsPage.clickOnCurrency();
        desktopsPage.clickOnSterlingPound();
        String expectedTotal = "£74.73";
        Assert.assertEquals(desktopsPage.getTotal(),expectedTotal,"Total is not displayed");
    }

}

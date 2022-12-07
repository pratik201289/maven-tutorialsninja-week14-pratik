package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class laptopsAndNotebooksPage extends Utility {
    By showAllLaptops = By.xpath("//a[text()='Show All Laptops & Notebooks']");
    By priceHighToLow = By.id("input-sort");
    By selectMacbook = By.linkText("MacBook");
    By macbookText = By.xpath("//h1[text()='MacBook']");
    By addToCart = By.id("button-cart");
    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By clearQuantity = By.xpath("//input[@value='1']");
    By addQuantity = By.xpath("//input[@value='1']");
    By updateTab = By.xpath("//button[@data-original-title='Update']");
    By successModifiedMessage = By.xpath("//body/div[@id='checkout-cart']/div[1]");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By sterlingPound = By.xpath("//button[contains(text(),'£ Pound Sterling')]");
    By total = By.xpath("//tbody/tr[1]/td[6]");
    By checkOut = By.xpath("//a[text()='Checkout']");
    By checkOutText = By.xpath("//h1[text()='Checkout']");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutRadioButton = By.xpath("//input[@name='account' and @value='guest']");
    By continueTab = By.id("button-account");
    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By emailId = By.id("input-payment-email");
    By telephone = By.name("telephone");
    By address = By.name("address_1");
    By city = By.name("city");
    By postcode = By.name("postcode");
    By selectCountry = By.id("input-payment-country");
    By selectState = By.id("input-payment-zone");
    By continueButton = By.id("button-guest");
    By addComment = By.name("comment");
    By termsAndConditions = By.name("agree");
    By clickContinue = By.id("button-payment-method");
    By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(showAllLaptops);
    }

    public Map<String, ArrayList> selectSortByPriceHighToLow() {

        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();

//        selectByVisibleTextFromDropDown(priceHighToLow, "Price (High > Low)");
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);

        mapArrays.put("originalProductsPrice", (ArrayList) originalProductsPrice);
        mapArrays.put("afterSortByPrice", afterSortByPrice);
        return mapArrays;

    }

    public void selectProductMacbook() {
        clickOnElement(selectMacbook);
    }

    public String getMacbookText() {
        return getTextFromElement(macbookText);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
    }

    public String getSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartText() {
        clickOnElement(shoppingCartLink);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public void clearQuantityField() {
        driver.findElement(clearQuantity).clear();
    }

    public void addQuantityInField() {
        sendTextToElement(addQuantity, "2");
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String getSuccessModifiedMessage() {
        return getTextFromElement(successModifiedMessage);
    }

    public void clickOnCurrency() {
        clickOnElement(currency);
    }

    public void selectSterlingPound() {
        clickOnElement(sterlingPound);
    }

    public String getTotal() {
        return getTextFromElement(total);
    }

    public void clickOnCheckOut() {
        clickOnElement(checkOut);
    }

    public String getCheckOutText() {
        return getTextFromElement(checkOutText);
    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckOutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }

    public void fillAllMandatoryField() {
        sendTextToElement(firstName, "Tom");
        sendTextToElement(lastName, "Ford");
        sendTextToElement(emailId, "tom1234@gmail.com");
        sendTextToElement(telephone, "07070223345");
        sendTextToElement(address, "102, High road");
        sendTextToElement(city, "London");
        sendTextToElement(postcode, "CR76JG");
        selectByVisibleTextFromDropDown(selectCountry, "United Kingdom");
        selectByVisibleTextFromDropDown(selectState, "Greater London");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void addCommentInCommentBox() {
        sendTextToElement(addComment, "Order should be delivered on time");
    }

    public void clickOnTermsAndConditionsCheckBox() {
        clickOnElement(termsAndConditions);
    }

    public void clickOnContinue() {
        clickOnElement(clickContinue);
    }

    public String getWarningMessage() {
        return getTextFromElement(warningMessage);
    }


}

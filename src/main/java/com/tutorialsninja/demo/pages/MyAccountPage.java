package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountPage extends Utility {
    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");
    By selectMyAccount = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");
    By registerAccountText = By.xpath("//h1[text()='Register Account']");
    By returningCustomerText = By.xpath("//h2[text()='Returning Customer']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By emailId = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By yesRadioButton = By.xpath("//label[1]/input[@name='newsletter']");
    By privacyPolicy = By.name("agree");
    By continueButton = By.xpath("//input[@value='Continue']");
    By accountCreatedMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By clickOnContinue = By.xpath("//a[contains(text(),'Continue')]");
    By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By clickContinue = By.xpath("//a[contains(text(),'Continue')]");
    By loginButton = By.xpath("//input[@value='Login']");
    By myAccountText = By.xpath("//h2[contains(text(),'My Account')]");


    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(selectMyAccount);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(selectMyAccount);
        }
    }

    public String getRegisterAccountText() {
        return getTextFromElement(registerAccountText);
    }

    public String getReturningCustomerText() {
        return getTextFromElement(returningCustomerText);
    }

    public void enterFirstName() {
        sendTextToElement(firstName, "Bruce");
    }

    public void enterLastName() {
        sendTextToElement(lastName, "Tyson");
    }

    public void enterEmailId() {
        sendTextToElement(emailId, "bruce914@gmail.com");
    }

    public void enterTelephone() {
        sendTextToElement(telephone, "8866300550");
    }

    public void enterPassword() {
        sendTextToElement(password, "bruce@1234");
    }

    public void enterConfirmPassword() {
        sendTextToElement(confirmPassword, "bruce@1234");
    }

    public void clickOnYesRadioButton() {
        clickOnElement(yesRadioButton);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinue() {
        clickOnElement(continueButton);
    }

    public String getAccountCreatedMessage() {
        return getTextFromElement(accountCreatedMessage);
    }
    public void clickOnContinueButton() {
        clickOnElement(clickOnContinue);
    }

    public String getAccountLogoutText() {
        return getTextFromElement(accountLogoutText);
    }

    public void clickContinue() {
        clickOnElement(clickContinue);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
    public String getMyAccountText(){
        return getTextFromElement(myAccountText);
    }

}

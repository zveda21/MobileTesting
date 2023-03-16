package org.example.pages.loginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static org.example.factory.AppiumDriverFactory.getDriver;

public class LoginPage extends BasePage {
    @AndroidFindBy(id = "com.vivarobet.casino.light:id/signInButton")
    private MobileElement signInButtonElement;

    @AndroidFindBy(id = "com.vivarobet.casino.light:id/elementTextEditText")
    private MobileElement usernameField;

    @AndroidFindBy(id = "com.vivarobet.casino.light:id/passwordEditText")
    private MobileElement passwordField;

    @AndroidFindBy(id = "com.vivarobet.casino.light:id/primaryButton")
    private MobileElement signInButton;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickSignIn(String username,String password) {
        if (signInButtonElement != null && signInButtonElement.isDisplayed()) {
            signInButtonElement.click();
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
        } else {
            System.out.println("The element is not displayed or cannot be found.");
        }
    }

}

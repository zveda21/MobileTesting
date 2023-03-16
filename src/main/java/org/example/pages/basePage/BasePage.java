package org.example.pages.basePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.pages.loginPage.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public AppiumDriver<MobileElement> driver;
    protected WebDriverWait webDriverWait;
    public TouchAction<AndroidTouchAction> touchAction;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 23, 400);
        this.touchAction = new TouchAction<>(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
}

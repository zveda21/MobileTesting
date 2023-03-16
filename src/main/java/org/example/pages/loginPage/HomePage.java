package org.example.pages.loginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.basePage.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @AndroidFindBy(id = "com.vivarobet.casino.light:id/nav_graph_menu")
    private MobileElement menuButton;

    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<MobileElement> settingsButton;

    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<MobileElement> signOutButton;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement elementOK;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickOnMenuButton() {
        menuButton.click();
    }

    public void clickOnSettingsButton() {
        settingsButton.get(11).click();
    }

    public void clickOnSignOutButton() {
        signOutButton.get(3).click();
    }
    public void clickOnSignOutOkElement(){
        elementOK.click();
    }
}

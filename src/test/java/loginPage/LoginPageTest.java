package loginPage;

import org.example.pages.loginPage.HomePage;
import org.example.pages.loginPage.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import static org.example.utils.Constants.validPassword;
import static org.example.utils.Constants.validUsername;

public class LoginPageTest extends TestBase {
    private SoftAssert softAssert;
    private LoginPage loginPage;

    private HomePage homePage;


    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void verifySignInPageUI() {
        loginPage.clickSignIn(validUsername, validPassword);
        loginPage.clickSignInButton();
        homePage.clickOnMenuButton();
        homePage.clickOnSettingsButton();
        homePage.clickOnSignOutButton();
        homePage.clickOnSignOutOkElement();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

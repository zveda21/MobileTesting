import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.example.utils.FilePaths.CASINO_APP_MAIN_ACTIVITY;

public class MobileTest {
    private AppiumDriver driver;
    private RemoteWebDriver remoteWebDriver;
    private WebDriverWait webDriverWait ;

    @AndroidFindBy(id = "com.vivarobet.casino.light:id/signInButton")
    private MobileElement signInButton;

    @AndroidFindBy(className = "android.widget.Button")
    private List<MobileElement> buttons;


    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        capabilities.setCapability("platformVersion", "11");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("appPackage", "com.vivarobet.casino.light");
//        capabilities.setCapability("appActivity", CASINO_APP_MAIN_ACTIVITY);
        capabilities.setCapability("app", "/Users/zhayrapetyan/Desktop/MobileTesting/MibileTestingFramework/src/test/resources/casino.apk");


        System.out.println(capabilities);
        getDevices();
//        driver = new AppiumDriver(new URL("https://seatmap:4723/wd/hub"), capabilities);
        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//        remoteWebDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        this.webDriverWait = new WebDriverWait(driver, 25, 400);

    }

    private static Set<String> getDevices(){
        JadbConnection jadbConnection = new JadbConnection();
        List<JadbDevice> devices;
        try {
            devices =  jadbConnection.getDevices();
        } catch (IOException | JadbException e) {
            throw new RuntimeException(e);
        }
        assert devices != null;
        System.out.println("devices==>"+ devices.stream().map(JadbDevice::getSerial).collect(Collectors.toSet()));
        return devices.stream().map(JadbDevice::getSerial).collect(Collectors.toSet());
    }

    @Test
    public void testExample() throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/signInButton")));
        if(element.isDisplayed()) {
            element.click();
            WebElement elementUsername = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/elementTextEditText")));
            elementUsername.sendKeys("android@betconstruct.com");
            WebElement elementPassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/passwordEditText")));
            elementPassword.sendKeys("Test1234");
            WebElement elementSignIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/primaryButton")));
            elementSignIn.click();
            WebElement elementMenu = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/nav_graph_menu")));
            elementMenu.click();
            WebElement elementLogout = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/logoImageView")));
            elementLogout.click();
            WebElement elementOK = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
            elementOK.click();
            WebElement elementGoToLogin = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vivarobet.casino.light:id/loginIconImageView")));
            Thread.sleep(3);
            elementGoToLogin.click();





        } else {
            System.out.println("debil");
        }//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("SIGN IN"))).click();
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
}

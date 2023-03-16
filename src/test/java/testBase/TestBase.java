package testBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.factory.AppiumDriverFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.example.factory.AppiumDriverFactory.deviceQueue;

//@Listeners({AutomationListener.class})
public class TestBase {

    public AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void startServer(ITestContext context) {
        context.getSuite().getXmlSuite().setThreadCount(deviceQueue.size());
    }

    @BeforeMethod(alwaysRun = true)
    public void getDriver() {
        driver = AppiumDriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quiteDriver() {
//        AppiumDriverFactory.quitDriver();
    }

    @AfterSuite
    public void tearDownTest() {
    }


}

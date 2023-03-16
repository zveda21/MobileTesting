package org.example.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import se.vidstige.jadb.JadbConnection;
import se.vidstige.jadb.JadbDevice;
import se.vidstige.jadb.JadbException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static org.example.utils.FilePaths.APP_PACKAGE_NAME;
import static org.example.utils.FilePaths.CASINO_APP_MAIN_ACTIVITY;

public class AppiumDriverFactory {

    public static final ConcurrentLinkedQueue<String> deviceQueue = new ConcurrentLinkedQueue<>(getDevices());

    private static final ThreadLocal<AppiumDriver<MobileElement>> driverPool = new ThreadLocal<>();

    private static URL url;

    public static synchronized AppiumDriver<MobileElement> getDriver() {
        if (driverPool.get() == null){
            driverPool.set(new DriverSupplier().getDriver());
        }
        return driverPool.get();
    }

    static URL getUrl() {
        try {
            url = URI.create("http://localhost:4723/wd/hub/").toURL();
            out.println(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private static Set<String> getDevices() {
        JadbConnection jadbConnection = new JadbConnection();
        List<JadbDevice> devices;
        try {
            devices = jadbConnection.getDevices();
        } catch (IOException | JadbException e) {
            throw new RuntimeException(e);
        }
        assert devices != null;
        System.out.println("devices==>" + devices.stream().map(JadbDevice::getSerial).collect(Collectors.toSet()));
        return devices.stream().map(JadbDevice::getSerial).collect(Collectors.toSet());
    }

    public static void quitDriver() {
    }

    private static class DriverSupplier {
        private final AppiumDriver<MobileElement> driver;

        public AppiumDriver<MobileElement> getDriver() {
            return driver;
        }

        private DriverSupplier() {
//            System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
            String deviceId = deviceQueue.poll();
            out.println("Driver for " + deviceId);
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceId);
            desiredCapabilities.setCapability("appPackage", APP_PACKAGE_NAME);
//            desiredCapabilities.setCapability("appActivity", CASINO_APP_MAIN_ACTIVITY);
//            desiredCapabilities.setCapability(MobileCapabilityType.APP, getProperty("user.dir") + "src/test/resources/casino.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/zhayrapetyan/Desktop/MobileTesting/MibileTestingFramework/src/test/resources/casino.apk");
            driver = new AndroidDriver<>(getUrl(), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        }
    }
}

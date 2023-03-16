//package org.example.listeners;
//
//
//import ch.qos.logback.classic.Logger;
//import io.qameta.allure.Attachment;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.slf4j.LoggerFactory;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//
//import static org.example.factory.AppiumDriverFactory.getDriver;
//
//
//public class AutomationListener implements ITestListener {
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AutomationListener.class);
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult iTestResult) {
//        LOGGER.info("--------------------PASSED----------------------");
//        LOGGER.info(" " + iTestResult.getMethod().getMethodName() + " | " + (iTestResult.getEndMillis() - iTestResult.getStartMillis()) / 1000);
//    }
//
//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        LOGGER.info("--------------------FAILED----------------------");
//        LOGGER.info(" " + iTestResult.getMethod().getMethodName() + " | " + (iTestResult.getEndMillis() - iTestResult.getStartMillis()) / 1000);
//        takeScreenShot();
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult iTestResult) {
//        LOGGER.info("--------------------SKIPPED----------------------");
//        LOGGER.info(" " + iTestResult.getMethod().getMethodName() + " | " + (iTestResult.getEndMillis() - iTestResult.getStartMillis()) / 1000);
//        takeScreenShot();
//    }
//
//    @Attachment(value = "Failure screenshot", type = "image/png")
//    private byte[] takeScreenShot() {
//        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        LOGGER.info("Staring to run test suite with " + context.getAllTestMethods().length + " tests");
//    }
//}
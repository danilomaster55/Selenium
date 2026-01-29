package com.curso.selenium.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.extension.*;

public class TestListener implements TestWatcher, BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void beforeAll(ExtensionContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    // Crear el ExtentTest antes de cada test
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        ExtentTest t = extent.createTest(context.getDisplayName());
        test.set(t);
    }

    // Limpiar el ThreadLocal después de cada test
    @Override
    public void afterTestExecution(ExtensionContext context) {
        test.remove();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        getTest().pass("Test passed");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        getTest().fail(cause);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
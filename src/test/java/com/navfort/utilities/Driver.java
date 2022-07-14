package com.navfort.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {

    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browser = ConfigurationReader.getProperty("Browser");


            switch (browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver","res/chromedriver.exe");
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "Chrome-Remember":
                    System.setProperty("webdriver.chrome.driver","res/chromedriver.exe");
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("test-type");
                    options.addArguments("start-maximized");
                    options.addArguments("user-data-dir=D:/temp/");
                    capabilities.setCapability("chrome.binary","res/chromedriver.exe");
                    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
//                    WebDriver driver = new ChromeDriver(capabilities);

                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(capabilities));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }


        return driverPool.get();

    }

    public static void closeDriver() {

        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }

}

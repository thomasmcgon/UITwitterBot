package com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class UITestsBase {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    void setup(){
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterTest
    void cleanUp(){
        driver.close();
    }
}

package com.framework;

import com.testframework.TwitterAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class UITests extends UITestsBase {

    @Test
    void signIn() throws IOException {
        //Arrange
        TwitterAccount account = new TwitterAccount();
        String EMAIL = account.getEmail();
        String PASSWORD = account.getPassword();
        String USERNAME = account.getUsername();
        String emailInputBox = "//label[contains(@class, 'css-1dbjc4n r-1roi411 r-z2wwpe r-rs99b7 r-18u37iz')]";
        //TODO: Find a way to access password input box
        String passwordInputBox = "//div[contains(@class, 'css-1dbjc4n r-16y2uox r-1wbh5a2')]";
        driver.get("https://twitter.com/");

        //Act
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Log in']")));
        loginButton.click();
        WebElement emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailInputBox)));
        emailTextBox.click();
        emailTextBox.sendKeys(EMAIL);
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        if(!driver.findElements(By.xpath("//span[text()='Enter your phone number or username']")).isEmpty()){
            WebElement usernameBox = driver.findElement(By.xpath("//input[@data-testid='ocfEnterTextTextInput']"));
            usernameBox.click();
            usernameBox.sendKeys(USERNAME);
            WebElement nextButton2 = driver.findElement(By.xpath("//span[text()='Next']"));
            nextButton2.click();
        }
        WebElement passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")));
        passwordTextBox.click();
        passwordTextBox.sendKeys(PASSWORD);
        WebElement loginButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div/span/span")));
        loginButton2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Assert
        WebElement loggedInUsernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/span"))));
        String actualUsername = loggedInUsernameElement.getAttribute("innerHTML");
        String expectedUsername = "@" + USERNAME;
        Assert.assertEquals(actualUsername, expectedUsername);
    }

    @Test
    void createTweet(){
        //TODO: Fix this code
        WebElement tweetButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[3]/a/div"));
        tweetButton.click();
        WebElement tweetTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/label/div[1]/div/div/div/div/div/div[2]/div")));
        tweetTextBox.click();
        tweetTextBox.sendKeys("I AM ALIVE!");
        WebElement publishTweetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div[3]/div/div/div[2]/div[4]/div")));
        publishTweetButton.click();
        Assert.assertEquals(1, 1);
        //TODO: Validate new tweet exists
    }
}

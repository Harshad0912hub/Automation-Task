package com.test.tests;

import com.test.pages.LoginPage;
import com.test.pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RegistrationAndLoginTest {

    WebDriver driver;

  
    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][]{
            {"John Doe", "123456780", "john.doe@example.com"} 
        };
    }


    @BeforeMethod
    public void setUp() {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
    }


    public String enterOTPManually() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the OTP received on your email: ");
        String otp = scanner.nextLine();  
        scanner.close();  
        return otp;
    }

    @Test(dataProvider = "registrationData")
    public void testRegistrationAndLogin(String name, String mobile, String email) {
        driver.get("https://testffc.nimapinfotech.com/auth/register");

      
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerInitial(name, mobile, email); 

       
        String otp = enterOTPManually(); 

   
        registrationPage.registerFinal(otp, "password123", "password123");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, "password123");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

    
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed. URL does not contain 'dashboard'.");

        driver.quit();  
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

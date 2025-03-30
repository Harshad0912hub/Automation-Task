package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(id = "//*[@id=\"mat-input-252\"]") 
    WebElement nameField;

    @FindBy(id = "mat-input-4") 
    WebElement mobileField;

    @FindBy(id = "mat-input-5") 
    WebElement emailField;

    @FindBy(id = "kt_login_signin_submit") 
    WebElement submitButton;

    @FindBy(id = "mat-input-6")
    WebElement otpField;

    @FindBy(id = "mat-input-7")
    WebElement passwordField;

    @FindBy(id = "mat-input-8") 
    WebElement confirmPasswordField;

    @FindBy(id = "kt_login_signin_submit") 
    WebElement submitFinalButton;

   
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void registerInitial(String name, String mobile, String email) {
        nameField.sendKeys(name);
        mobileField.sendKeys(mobile);
        emailField.sendKeys(email);
        submitButton.click(); 
    }

  
    public void registerFinal(String otp, String password, String confirmPassword) {
        otpField.sendKeys(otp);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        submitFinalButton.click();  
    }
}

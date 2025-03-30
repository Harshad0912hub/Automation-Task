package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;

 
    @FindBy(id = "newCustomerButton") 
    WebElement newCustomerButton;

    @FindBy(id = "mat-input-176")  
    WebElement customerNameField;

    @FindBy(id = "saveCustomerButton")  
    WebElement saveCustomerButton;


    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
    }

   
    public void addCustomer(String customerName) {
       
        newCustomerButton.click();

       
        customerNameField.sendKeys(customerName);

       
        saveCustomerButton.click();
    }

   
}

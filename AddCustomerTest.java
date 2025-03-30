package com.test.tests;

import com.test.pages.AddCustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;  // Import WebDriverManager
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest {
    WebDriver driver;


    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][]{
            {"John Doe"},
            {"Jane Smith"}
        };
    }

    @Test(dataProvider = "customerData")
    public void testAddCustomer(String customerName, String customerEmail) {
      
        WebDriverManager.chromedriver().setup();  

        driver = new ChromeDriver();  
        driver.get("https://testffc.nimapinfotech.com/customers");  

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        
      
        addCustomerPage.addCustomer(customerName);

       

        driver.quit();  
    }
}

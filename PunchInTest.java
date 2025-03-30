package com.test.tests;

import com.test.pages.PunchInPage;
import io.github.bonigarcia.wdm.WebDriverManager;  // Import WebDriverManager
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PunchInTest {
    WebDriver driver;

    @Test
    public void testToastMessageAfterPunchIn() {
        
        WebDriverManager.chromedriver().setup();  

        driver = new ChromeDriver(); 
        driver.get("https://testffc.nimapinfotech.com/dashboard");

        PunchInPage punchInPage = new PunchInPage(driver);
        punchInPage.punchIn();

      
        String toastMessage = punchInPage.getToastMessage();
        assert toastMessage.equals("Successfully punched in!");  

        driver.quit();  
    }
}

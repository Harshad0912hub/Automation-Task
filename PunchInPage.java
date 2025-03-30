package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PunchInPage {
    WebDriver driver;

    @FindBy(id = "punchInButton")
    WebElement punchInButton;

    @FindBy(id = "toastMessage")
    WebElement toastMessage;

    public PunchInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void punchIn() {
        punchInButton.click();
    }

    public String getToastMessage() {
        return toastMessage.getText();
    }
}

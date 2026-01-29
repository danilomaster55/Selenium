package com.curso.selenium.pages;

import org.openqa.selenium.By;

public class AdminPage extends BasePage{
    private final By adminHeader = By.xpath("//h6[text()='Admin']");

    public boolean isAt(){
        return waitFor(adminHeader).isDisplayed();
    }
}

package com.curso.selenium.pages;

import org.openqa.selenium.By;

public class MyInfoPage extends BasePage{
    private final By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    public boolean isAt(){
        return waitFor(personalDetailsHeader).isDisplayed();
    }
}

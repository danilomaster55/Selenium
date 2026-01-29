package com.curso.selenium.pages;

import org.openqa.selenium.By;

public class LeavePage extends  BasePage{
    private final By leaveHeader = By.xpath("//h6[text()='Leave']");

    public boolean isAt(){
        return waitFor(leaveHeader).isDisplayed();
    }
}

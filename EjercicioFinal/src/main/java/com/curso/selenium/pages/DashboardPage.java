package com.curso.selenium.pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage{
    private final By adminMenu = By.xpath("//span[text()='Admin']");
    private final By myInfoMenu = By.xpath("//span[text()='My Info']");
    private final By leaveMenu = By.xpath("//span[text()='Leave']");

    public AdminPage goToAdmin(){
        waitFor(adminMenu).click();
        return new AdminPage();
    }

    public MyInfoPage goToMyInfo(){
        waitFor(myInfoMenu).click();
        return new MyInfoPage();
    }

    public LeavePage goToLeave(){
        waitFor(leaveMenu).click();
        return new LeavePage();
    }
}

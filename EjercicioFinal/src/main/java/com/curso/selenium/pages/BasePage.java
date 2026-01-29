package com.curso.selenium.pages;

import com.curso.selenium.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ¿Por qué BasePage es abstract?
 *    Porque NO representa una página real de la aplicación.
 *    No se debería crear una instancia de esta página
 *    BasePage solo existe para ser heredada, no para usarse directamente
 * Resumiendo:
 *    Esta clase define comportamiento común para todas las páginas,
 *    pero no es una página en sí
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //espera maxima de 10 sec
    }

    protected WebElement waitFor(By locator){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getTitle(){
        return driver.getTitle();
    }
}

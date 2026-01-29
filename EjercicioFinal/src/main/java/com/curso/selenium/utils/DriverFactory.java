package com.curso.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    /**
     * ThreadLocal es una variable especial que guarda un valor distinto por cada hilo (thread).
     * La idea es -> una variable global, pero privada para cada hilo
     * Esto significa:
     *    - Existe una sola DriverFactory
     *    - Pero cada hilo de ejecución tendrá su propio WebDriver
     *    - Los drivers no se pisan entre sí
     * Cada test (hilo):
     *    - Crea su propio navegador
     *    - Lo usa sin interferencias
     *    - Lo cierra al final
     */
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (driver.get()==null){
            WebDriver wd =new ChromeDriver();
            driver.set(wd);
        }
        return driver.get();
    }

    public static void quitDriver(){
        if (driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}

package org.curso;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Acesso {

    public WebDriver acesso(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        return driver;
    }
}

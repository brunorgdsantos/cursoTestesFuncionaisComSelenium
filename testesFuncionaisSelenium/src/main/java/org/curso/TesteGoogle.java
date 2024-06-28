package org.curso;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

    @Test
    public void testeTitulo() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().setPosition(new Point(100, 100));
        Assertions.assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}

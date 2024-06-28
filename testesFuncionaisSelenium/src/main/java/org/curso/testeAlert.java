package org.curso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeAlert {

    @Test
    public void deveInteragirComAlertSimples(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assertions.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assertions.assertEquals("Confirmado", alerta.getText());
        alerta.accept();

        driver.findElement(By.id("confirm")).click();
        Alert alerta2 = driver.switchTo().alert();
        Assertions.assertEquals("Confirm Simples", alerta2.getText());
        alerta2.dismiss();
        Assertions.assertEquals("Negado", alerta2.getText());
        alerta2.dismiss();
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertConfirm(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("alert")).click();
        Alert alerta = driver.switchTo().alert();
        String alertaTexto = alerta.getText();
        Assertions.assertEquals("Alert Simples", alertaTexto);
        alerta.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(alertaTexto);
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertaPrompt(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assertions.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("12");
        alerta.accept();
        Assertions.assertEquals("Era 12?", alerta.getText());
        alerta.accept();
        driver.quit();
    }

    @Test
    public void deveInteragirComFrame(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assertions.assertEquals("frame ok", msg);
        alerta.accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
        driver.quit();
    }
}

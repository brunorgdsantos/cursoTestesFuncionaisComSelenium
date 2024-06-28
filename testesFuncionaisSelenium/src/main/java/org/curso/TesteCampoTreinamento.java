package org.curso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v123.css.model.Value;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class TesteCampoTreinamento {

        @Test
    public void deveInteragirComTextArea(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Text Area\nTeste");
        Assertions.assertEquals("Text Area\nTeste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void camposCheck(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
        driver.quit();
    }

    @Test
    public void camposEscolaridade(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByValue("superior");
        combo.selectByIndex(2);
        combo.selectByVisibleText("2o grau completo");
        Assertions.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        driver.quit();
    }

    @Test
    public void deveVerificarValoresCombo(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assertions.assertEquals(8, options.size());
        driver.quit();
    }

    @Test
    public void deveSelecionarVariosValores(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        combo.selectByValue("natacao");
        combo.selectByValue("futebol");
        List<WebElement> getAll = combo.getAllSelectedOptions();
        Assertions.assertEquals(2, getAll.size());
        combo.deselectByVisibleText("futebol");
        driver.quit();
    }

    @Test
    public void deveInteragirComBotoes(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("buttonSimple"));
        element.click();
        Assertions.assertEquals("Obrigado!", element.getAttribute("value"));
        driver.quit();
    }

    @Test
    public void deveInteragirLinks(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.linkText("Voltar")).click();
        driver.quit();
    }

    @Test
    public void deveBuscarTextosNaPagina(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        Assertions.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assertions.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assertions.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
        driver.quit();
    }



}

package org.curso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Resumo {

    public void resumo(){
        //Verificar se o campo de texto está preenchido
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Text Area\nTeste");
        Assertions.assertEquals("Text Area\nTeste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

        //Verificar se os campos de check estão selecionados
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());

        //Selecionar opções de escolaridade
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByValue("superior");
        combo.selectByIndex(2);
        combo.selectByVisibleText("2o grau completo");
        Assertions.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());

        //Seleciona Varios valores
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        combo.selectByValue("natacao");
        combo.selectByValue("futebol");
        List<WebElement> getAll = combo.getAllSelectedOptions();
        Assertions.assertEquals(2, getAll.size());
        combo.deselectByVisibleText("futebol");

        //Clicando no botão
        WebElement element = driver.findElement(By.id("buttonSimple"));
        element.click();
        Assertions.assertEquals("Obrigado!", element.getAttribute("value"));

        //Pegando elemento pelo LINKTEXT
        driver.findElement(By.linkText("Voltar")).click();

        //Pegando elemento por TAGNAME
        Assertions.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assertions.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assertions.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());

        //Pegando texto de um Alert
        Alert alerta = driver.switchTo().alert();
        Assertions.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        alerta.dismiss();

        //Trabalahando com Alert Prompt
        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assertions.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("12");
        alerta.accept();

        //Trabalhando com Frames
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assertions.assertEquals("frame ok", msg);
        alerta.accept();
        driver.switchTo().defaultContent();
    }
}

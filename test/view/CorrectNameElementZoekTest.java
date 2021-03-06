package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class CorrectNameElementZoekTest {
    private WebDriver driver;
    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\piete_8alqa94\\OneDrive\\Documents\\school\\Toegepaste Informatica 20-21\\WEB2\\chromedriver.exe");
        driver = new ChromeDriver();
    }

 @Test
    public void Gevonden_formulier_getoond_indien_naam_veld_juist_ingevuld(){
     driver.get(url + "vindproduct.jsp");
     WebElement naamInput = driver.findElement(By.id("naam"));
     naamInput.clear();
     naamInput.sendKeys("rund");

     driver.findElement(By.id("zoek")).click();

     assertEquals("Gevonden", driver.getTitle());
     ArrayList<WebElement> ths = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));
     assertTrue(containsWebElementsWithText(ths, "rund"));
 }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    @After
    public void clean() {
        driver.quit();
    }
}

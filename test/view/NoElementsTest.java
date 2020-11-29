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

public class NoElementsTest {
    private WebDriver driver;
    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\piete_8alqa94\\OneDrive\\Documents\\school\\Toegepaste Informatica 20-21\\WEB2\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test_form_is_shown_when_no_fields_are_filled_in(){
        driver.get(url + "winkel.jsp");
        WebElement naamInput = driver.findElement(By.id("productnaam"));
        naamInput.clear();
        naamInput.sendKeys("");

        WebElement hoeveelheidInput = driver.findElement(By.id("hoeveelheid"));
        hoeveelheidInput.clear();
        hoeveelheidInput.sendKeys("");

        WebElement prijsaanbodInput = driver.findElement(By.id("prijsaanbod"));
        prijsaanbodInput.clear();
        prijsaanbodInput.sendKeys("");

        driver.findElement(By.id("plaatsBestelling")).click();

        assertEquals("Winkel", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "No valid name"));
        assertTrue(containsWebElementsWithText(lis, "Vul een geldig nummer in (boven 0)"));
        assertTrue(containsWebElementsWithText(lis, "Vul een geldig nummer in (boven 0)"));
    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
     /* @After
   public void clean() {
        driver.quit();
  */
}

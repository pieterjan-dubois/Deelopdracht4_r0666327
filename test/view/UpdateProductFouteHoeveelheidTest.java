package view;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateProductFouteHoeveelheidTest {
    private WebDriver driver;
    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\piete_8alqa94\\OneDrive\\Documents\\school\\Toegepaste Informatica 20-21\\WEB2\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test_update_form_shows_error_notification_When_Hoeveelheid_field_is_filled_in_Incorrectly(){
       driver.get(url + "update.jsp");
       WebElement naamInput = driver.findElement(By.id("naam"));
       naamInput.clear();
       naamInput.sendKeys("kip");

       WebElement hoeveelheidInput = driver.findElement(By.id("hoeveelheid"));
       hoeveelheidInput.clear();
       hoeveelheidInput.sendKeys("-1");

       WebElement prijsAanbodInput = driver.findElement(By.id("prijsaanbod"));
       prijsAanbodInput.clear();
       prijsAanbodInput.sendKeys("12");

       driver.findElement(By.id("update")).click();

        assertEquals("Mijn Bestelling", driver.getTitle());
        ArrayList<WebElement> ps = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(ps, "Hoeveelheid moet groter zijn dan nul."));
        assertEquals("kip",driver.findElement(By.id("naam")).getAttribute("value"));
        assertEquals("",driver.findElement(By.id("hoeveelheid")).getAttribute("value"));
        assertEquals("",driver.findElement(By.id("prijsaanbod")).getAttribute("value"));
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

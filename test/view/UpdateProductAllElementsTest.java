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

public class UpdateProductAllElementsTest {
    private WebDriver driver;
    String url = "http://localhost:8080/web_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\piete_8alqa94\\OneDrive\\Documents\\school\\Toegepaste Informatica 20-21\\WEB2\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void test_update_form_works_when_hoeveelheid_and_prijsaanbod_field_is_filled_in_correctly(){
        driver.get(url + "update.jsp");
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("kip");

        WebElement hoeveelheidInput = driver.findElement(By.id("hoeveelheid"));
        hoeveelheidInput.clear();
        hoeveelheidInput.sendKeys("12");

        WebElement prijsAanbodInput = driver.findElement(By.id("prijsaanbod"));
        prijsAanbodInput.clear();
        prijsAanbodInput.sendKeys("12");

        driver.findElement(By.id("update")).click();

        assertEquals("Mijn Bestelling", driver.getTitle());

        ArrayList<WebElement> ths = (ArrayList<WebElement>) driver.findElements(By.tagName("th"));
        assertTrue(containsWebElementsWithText(ths,"kip"));

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

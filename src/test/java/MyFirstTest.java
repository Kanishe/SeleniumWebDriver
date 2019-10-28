import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {
  private WebDriver driver;
  private WebDriverWait wait;

//test

  @Before
  public void start(){
    // Указываем путь к драйверу. Это необходимо для всех драйверов кроме Firefox до 46 версии.
    System.setProperty("webdriver.chrome.driver","/Users/alexandrkanishevskii/IdeaProjects/SeleniumWebDriver/src/test/resources/chromedriver");
    System.setProperty("webdriver.gecko.driver","/Users/alexandrkanishevskii/IdeaProjects/SeleniumWebDriver/src/test/resources/geckodriver");
    //driver = new ChromeDriver();
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver,16);

  }
  @Test
  public void myFirstTest(){
    driver.navigate().to("https://www.google.ru");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    wait.until(titleIs("webdriver - Поиск в Google"));
  }
  @After
  public void stop(){
    driver.quit();
    driver=null;
  }
}

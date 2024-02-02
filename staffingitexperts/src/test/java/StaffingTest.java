/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author erik_
 */
public class StaffingTest {
    private WebDriver driver;
    private String baseUrl;
    
    public StaffingTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }
    
     @Test
  public void testHomePage() throws Exception {
    driver.get("https://www.staffing.itexps.net/");
  }
  
  @Test
  public void testContactUSTalent() throws Exception {
    driver.get("https://www.staffing.itexps.net/");
    driver.findElement(By.id("comp-ksz4atem4label")).click();
    driver.get("https://www.staffing.itexps.net/contact-us");
    driver.findElement(By.id("input_comp-ksz2gtlo1")).click();
    driver.findElement(By.id("input_comp-ksz2gtlo1")).clear();
    driver.findElement(By.id("input_comp-ksz2gtlo1")).sendKeys("Test");
    driver.findElement(By.id("input_comp-ksz4wacx")).click();
    driver.findElement(By.id("input_comp-ksz4wacx")).clear();
    driver.findElement(By.id("input_comp-ksz4wacx")).sendKeys("2222222222");
    driver.findElement(By.id("input_comp-ksz4wg2e")).click();
    driver.findElement(By.id("input_comp-ksz4wg2e")).clear();
    driver.findElement(By.id("input_comp-ksz4wg2e")).sendKeys("test@test.com");
    driver.findElement(By.id("input_comp-kt4rl3rc")).click();
    driver.findElement(By.id("input_comp-kt4rl3rc")).clear();
    driver.findElement(By.id("input_comp-kt4rl3rc")).sendKeys("201 test st");
    driver.findElement(By.id("textarea_comp-ksz2gtlx2")).click();
    driver.findElement(By.id("textarea_comp-ksz2gtlx2")).clear();
    driver.findElement(By.id("textarea_comp-ksz2gtlx2")).sendKeys("testing");
    driver.findElement(By.xpath("//div[@id='comp-ksz2gtm12']/button/span")).click();
  }
  
   @Test
  public void testContactUSJob() throws Exception {
    driver.get("https://www.staffing.itexps.net/");
    driver.findElement(By.id("comp-ksz4atem4label")).click();
    driver.get("https://www.staffing.itexps.net/contact-us");
    //driver.findElement(By.id("comp-ksz4atemmoreContainer2label")).click();
    driver.findElement(By.id("input_comp-ktd614r51")).click();
    driver.findElement(By.id("input_comp-ktd614r51")).clear();
    driver.findElement(By.id("input_comp-ktd614r51")).sendKeys("test");
    driver.findElement(By.id("input_comp-ktd614r72")).click();
    driver.findElement(By.id("input_comp-ktd614r72")).clear();
    driver.findElement(By.id("input_comp-ktd614r72")).sendKeys("3333333333");
    driver.findElement(By.id("input_comp-ktd614r92")).click();
    driver.findElement(By.id("input_comp-ktd614r92")).clear();
    driver.findElement(By.id("input_comp-ktd614r92")).sendKeys("test@test.com");
    driver.findElement(By.id("input_comp-ktd614rb2")).click();
    driver.findElement(By.id("input_comp-ktd614rb2")).clear();
    driver.findElement(By.id("input_comp-ktd614rb2")).sendKeys("201 test");
    driver.findElement(By.id("textarea_comp-ktd614rd2")).click();
    driver.findElement(By.id("textarea_comp-ktd614rd2")).clear();
    driver.findElement(By.id("textarea_comp-ktd614rd2")).sendKeys("testing");
    driver.findElement(By.xpath("//div[@id='comp-ktd614rf3']/button/span")).click();
  }
  
  @Test
  public void testContactUS() throws Exception {
    driver.get("https://www.staffing.itexps.net/");
    driver.get("https://www.staffing.itexps.net/contact-us");
  }

//  @Test
//  public void testFindTalent() throws Exception {
//    driver.get("https://www.staffing.itexps.net/");
//    driver.get("https://www.staffing.itexps.net/findtalent");
//    WebDriverWait wait1=new WebDriverWait(driver, 30);  //30 sec
//    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='view_356']/div/h2")));  
//    //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=0 | ]]   
//    driver.findElement(By.xpath("//div[@id='view_356']/div/h2")).click();
//    assertEquals(driver.findElement(By.xpath("//div[@id='view_356']/div/h2")).getText(), "Candidates Available for Jobs");
//    //ERROR: Caught exception [unknown command []]
//  }

  @Test
    public void testFindTalent() throws Exception {
    driver.get("https://www.staffing.itexps.net/findtalent");
    
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='view_356']/div/h2")));  
    
    WebElement header = driver.findElement(By.xpath("//div[@id='view_356']/div/h2"));
    assertTrue(header.isDisplayed());
    assertEquals("Candidates Available for Jobs", header.getText());
}

}

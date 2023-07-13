package Letskode;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class Uploadfile {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	try {
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone 14");
		
		driver.findElement(By.id("nav-search-submit-button")).sendKeys(Keys.ENTER);
		//Actions act = new Actions(driver);
		//act.click(driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"))).perform();
		Assert.assertEquals(driver.getTitle(), "Amazon.in : iphone 14");
		
		//act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Wrong input given");
	}
	finally {
		System.out.println("Your code is execeuted successfully");
	}
	
	
	
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  driver.manage().window().maximize();
	  
  }

}

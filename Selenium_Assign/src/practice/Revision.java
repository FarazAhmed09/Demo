package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Revision {
  WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.linkText("Order Now")).click();
	  Set<String> str=driver.getWindowHandles();
	  for(String s:str) {
	  
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("http://10.82.181.42/Automation/PSRestuarant/pages/HomeDelivery.html")) {
			  break;
		  }
	
	  }
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[2]/form/div[1]/div/div[2]/div/label[1]/input")).click();
      Select drop = new Select(driver.findElement(By.id("mainDish")));
      drop.selectByVisibleText("Mushroom Pulao");
      Thread.sleep(1000);
      Select drop1 = new Select(driver.findElement(By.id("curry")));
      drop1.selectByVisibleText("Butter Paneer");
      Thread.sleep(1000);
      driver.findElement(By.id("name")).sendKeys("Faraz");
      driver.findElement(By.id("address")).sendKeys("Mumbai");
      driver.findElement(By.id("mobile")).sendKeys("989898989");
      Thread.sleep(1000);
      driver.findElement(By.id("email")).sendKeys("farazkdd@yahoo.com");
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"image\"]/div[2]/form/button")).click();
      driver.switchTo().alert().accept();
     
      
  }
  
  @Test(priority = 2)
  public void datatable() {
	  driver.findElement(By.linkText("Weekend Offers")).click();
	  WebElement table = driver.findElement(By.id("previousOffers"));
	  List<WebElement> rows = table.findElements(By.tagName("tr"));
	  for(WebElement r: rows) {
		  List<WebElement> cols = r.findElements(By.tagName("td"));
		  for(WebElement c:cols) {
			if(c.getText().equals("SUN5")){
				System.out.println(cols.get(2).getText());
			}
			  
		  }
		  
	  }
	  
  } 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\ChromeDriver111\\ChromeDriver111\\chromedriver.exe");
	   driver  = new ChromeDriver();
	   driver.get("http://10.82.181.42/Automation/PSRestuarant/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}




package Letskode;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Acceleratetask {
	WebDriver driver;
	Logger log = Logger.getLogger("Acceleratetask.class");
	/**
  
	 * @Test
  public void testing() throws InterruptedException {
	 
	 Thread.sleep(1000);
	 driver.findElement(By.id("benzradio")).click();
	 Thread.sleep(1000);
	 Select Drop = new Select(driver.findElement(By.id("carselect")));
	 Drop.selectByVisibleText("BMW");
	 
	 Select Drop1 = new Select(driver.findElement(By.id("multiple-select-example")));
	 Drop1.selectByVisibleText("Orange");
	 Drop1.selectByVisibleText("Peach");
	 
	 String currentwindow = driver.getWindowHandle();
     driver.findElement(By.id("openwindow")).click();
	 
	  Set<String> str2 = driver.getWindowHandles();
	  for(String s:str2) {
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("https://www.letskodeit.com/courses")) {
			  break;
		  }
	  }
	  
	  driver.close();
      driver.switchTo().window(currentwindow);
	 
	 
	 
	 String cw = driver.getWindowHandle();
	 
	 driver.findElement(By.id("opentab")).click();
	 
	  Set<String> str1 = driver.getWindowHandles();
	  for(String s:str1) {
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("https://www.letskodeit.com/courses")) {
			  break;
		  }
		 
	  }
	driver.close();
	driver.switchTo().window(cw);
	 
	 
	 
	 driver.findElement(By.id("name")).sendKeys("Faraz Ahmed");
	 driver.findElement(By.id("alertbtn")).click();
	 driver.switchTo().alert().accept();
	 Thread.sleep(1000);
	 driver.findElement(By.id("confirmbtn")).click();
	 driver.switchTo().alert().accept();
	 
	  }
 
  @Test(priority = 3)
  public void testing2() {
	  
	  WebElement table =driver.findElement(By.id("product"));
	  
	  List<WebElement> row = table.findElements(By.tagName("tr"));
	  for(WebElement r:row) {
		  
		  List<WebElement> col = r.findElements(By.tagName("td"));
		  for(WebElement c:col) {
			  if(col.get(2).getText().equals("30")) {
				  System.out.println("Autor:"+col.get(0).getText());
				  System.out.println("Cousre:"+col.get(1).getText());
				  break;
			  }
		  }
		  
	  }
	    
  }
  **/ 
	
@Test(priority = 4)
  public void testing3() throws InterruptedException {
	Actions act = new Actions(driver);
	WebElement hover = driver.findElement(By.id("mousehover"));
	act.moveToElement(hover).perform();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Top")).click();
	
	
	driver.switchTo().parentFrame();
	WebElement current = driver.findElement(By.id("courses-iframe"));
	Thread.sleep(1000);
	driver.switchTo().frame(current);
	
	Select drop = new Select(driver.findElement(By.xpath("//*[@id=\"zen_all_courses_dynamic\"]/div[2]/div[1]/select")));
	drop.selectByVisibleText("Test Automation");
//	WebDriverWait wait = new WebDriverWait(driver,40);
//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
//	element.sendKeys("Selenium");
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[2]/form/div/input")).sendKeys("Selenium");
	driver.findElement(By.xpath("//*[@id=\"search\"]/div/button")).click();
}

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://courses.letskodeit.com/practice");
	  driver.manage().window().maximize();
	  
	  
	  driver.findElement(By.linkText("PRACTICE")).click();
	  Set<String> str = driver.getWindowHandles();
	  for(String s:str) {
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("https://www.letskodeit.com/practice")) {
			  break;
		  }
	  }
  }

  @AfterClass
  public void afterClass() {
	  //driver.close();
  }

}

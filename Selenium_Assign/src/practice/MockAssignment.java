package practice;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class MockAssignment {
	WebDriver driver;
	
	
	
	
  @Test(priority = 0)
  public void TakeAway() throws IOException, InterruptedException {
	  driver.findElement(By.linkText("Order Now")).click();
	  Set<String> str =driver.getWindowHandles();
	  for(String s:str) {
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("http://10.82.181.42/Automation/PSRestuarant/pages/HomeDelivery.html")) {
			  break;
		  }
	  }  	  
	 driver.findElement(By.linkText("Take Away")).click();
	 driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/label[2]/input")).click();
	 Thread.sleep(1000);
	 
	 File f = new File("C:\\Users\\faraz.ahmed02\\Documents\\Mock_Assignment\\Mock_Assignment\\PS Restaurant.xlsx");
	 
	 FileInputStream fin = new FileInputStream(f);
	 
	 XSSFWorkbook book = new XSSFWorkbook(fin);
	 XSSFSheet sheet = book.getSheet("Sheet1");
	 System.out.println("first row "+sheet.getFirstRowNum());
	 System.out.println("Last row "+sheet.getLastRowNum());
	 Thread.sleep(1000);
	 
	 Select drop = new Select(driver.findElement(By.id("mainDish")));
	 String str1 = sheet.getRow(2).getCell(1).getStringCellValue();
	 drop.selectByVisibleText(str1);
	 
  @Test(priority=1)
  public void Delivery() throws IOException, InterruptedException {
	  driver.findElement(By.linkText("Home Delivery")).click();
	  Thread.sleep(1000);
	  
	  File f = new File("C:\\Users\\faraz.ahmed02\\Documents\\Mock_Assignment\\Mock_Assignment\\PS Restaurant.xlsx");
      FileInputStream fin = new FileInputStream(f);
      
      XSSFWorkbook book = new XSSFWorkbook(fin);
      XSSFSheet sheet = book.getSheet("Sheet1");
      
      for(int i = sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++) {
    	  String Type = sheet.getRow(i).getCell(0).getStringCellValue();
    	  String mainDish = sheet.getRow(i).getCell(1).getStringCellValue();
    	  String curry = sheet.getRow(i).getCell(2).getStringCellValue();
    	  String  Name = sheet.getRow(i).getCell(3).getStringCellValue();
    	  String Address = sheet.getRow(i).getCell(4).getStringCellValue();
    	  String contact = sheet.getRow(i).getCell(5).getRawValue();
    	  String email = sheet.getRow(i).getCell(6).getStringCellValue();
    	  String code = sheet.getRow(i).getCell(7).getRawValue();
    	  
    	  if(Type.equals("Vegetarian")) {
    		  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[2]/form/div[1]/div/div[2]/div/label[1]/input")).click();
    	      Thread.sleep(1000);
    	  }
    	  else if(Type.equals("Non-Vegetarian")){
    		  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[2]/form/div[1]/div/div[2]/div/label[2]/input")).click();
    		  Thread.sleep(1000);
    	  }
    	
    	  Select drop = new Select(driver.findElement(By.id("mainDish")));
    	  drop.selectByVisibleText(mainDish);
    	  Thread.sleep(1000);
    	  Select drop2 = new Select(driver.findElement(By.id("curry")));
    	  drop2.selectByVisibleText(curry);
    	  Thread.sleep(1000);
    	  driver.findElement(By.id("name")).sendKeys(Name);
    	  driver.findElement(By.id("address")).sendKeys(Address);
    	  driver.findElement(By.id("mobile")).sendKeys(contact);
    	  driver.findElement(By.id("email")).sendKeys(email);
    	  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[2]/form/div[8]/div/div[1]/div[2]/div/input")).sendKeys(code);
    	  driver.findElement(By.xpath("//*[@id=\"image\"]/div[2]/form/button")).click();	  
    	  driver.switchTo().alert().accept();
      }
      
  }
  
 
  @Test(priority = 2)
  public void Offers() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[3]/a")).click();
	  
	  WebElement Table = driver.findElement(By.id("upcomingOffers"));
	  List<WebElement> rows = Table.findElements(By.tagName("tr"));
	  for(WebElement r:rows) {
		  List<WebElement> cols = r.findElements(By.tagName("td"));
		  for(WebElement c:cols) {
			  if(c.getText().contains("Non Veg")) {
				  System.out.println(cols.get(1).getText());
			  }
		  }
		  
	  }
  }
	 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\ChromeDriver111\\ChromeDriver111\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://10.82.181.42/Automation/PSRestuarant/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	  }
  
  
  

  @AfterClass
  public void afterClass() {
  }

}

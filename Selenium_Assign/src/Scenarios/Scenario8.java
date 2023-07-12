package Scenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Scenario8 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException{
	 
	  driver.findElement(By.linkText("Sign Up")).click();
	  File f = new File("C:\\Users\\faraz.ahmed02\\Documents\\Sel_Practice Scenarios\\Sel_Practice Scenarios\\Sel_Practice Scenarios\\Details.xlsx");
	  FileInputStream fin = new FileInputStream(f);
	  XSSFWorkbook book = new XSSFWorkbook(fin); 	
	  XSSFSheet sheet= book.getSheet("Sheet1");
	 // System.out.println(sheet.getLastRowNum());
	  
	  
	  for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++) {
		  driver.findElement(By.id("usernameSignUp")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		  Thread.sleep(1000);

		  driver.findElement(By.id("emailSignUp")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
		  Thread.sleep(1000);

		  driver.findElement(By.id("passwordSignUp")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		  Thread.sleep(1000);

		  driver.findElement(By.id("signUp")).click();
		  Thread.sleep(3000);
		  
		  XSSFRow r1=sheet.getRow(i);
	      XSSFCell c1 = r1.createCell(3);
	      
		  if(driver.findElement(By.xpath("//*[@id=\"successS\"]")).getText().endsWith("successfully.")) {
			  c1.setCellValue("Sign up successfull");
			  
		  }
		  else {
			  c1.setCellValue("Unable to sign up ");
		  }
	  }
	  driver.findElement(By.id("closeSignUp")).click();
	  FileOutputStream fout = new FileOutputStream(f);
	  book.write(fout);
	  book.close();
	  
	  
	  driver.findElement(By.linkText("Login")).click();
	  driver.findElement(By.id("usernameLogin")).sendKeys("pgGru");
	  driver.findElement(By.id("passwordLogin")).sendKeys("freezeray");
	  driver.findElement(By.id("login")).click();
	  String exp = "New Booking";
	  String actual= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]")).getText();
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(exp, actual);
	  sa.assertAll();
		Select drop = new Select(driver.findElement(By.id("fromDD")));
		drop.selectByVisibleText("Bengaluru");
		Select drop1 = new Select(driver.findElement(By.id("toDD")));
		drop1.selectByVisibleText("Hyderabad");
		driver.findElement(By.id("searchBus")).click();
		
		WebElement table = driver.findElement(By.id("myTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement r:rows) {
			List<WebElement> cols = r.findElements(By.tagName("td"));
			for(WebElement c:cols) {
				if(cols.get(0).getText().equals("BNGHYD2200")) {
					driver.findElement(By.id("radio3")).click();
				}
				}
		}
		driver.findElement(By.id("book")).click();
		driver.findElement(By.id("counter")).clear();
		driver.findElement(By.id("counter")).sendKeys("5");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[6]/td/p/input")).click();
		String str=driver.findElement(By.id("tFare")).getText();
		System.out.println("The total fare is"+str);
		/**
		WebElement Table2 = driver.findElement(By.id("tableBooking"));
		List<WebElement> rows2 = Table2.findElements(By.tagName("tr"));
		
		for(WebElement r:rows2) {
			List<WebElement> cols = r.findElements(By.tagName("td"));
			
			for(WebElement c:cols) {
				if(cols.get(0).getText().equals("Total fare")) {
					System.out.println("The total fare is "+cols.get(1).getText());
				}
			}
		
			}
			**/
		driver.findElement(By.id("confirmBooking")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();

  }
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.181.42/Automation/PackAndGo_v2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}

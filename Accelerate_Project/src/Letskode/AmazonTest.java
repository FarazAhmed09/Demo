package Letskode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class AmazonTest extends Pomexample {
	public  AmazonTest(WebDriver driver) {
		this.driver= driver;
	}
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = getDriver();
	}
	
	
  @Test
  public void f()  {
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Naruto Tshirt");
	  driver.findElement(By.id("nav-search-submit-button")).click();
  }


  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}

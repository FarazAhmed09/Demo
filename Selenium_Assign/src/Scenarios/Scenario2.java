package Scenarios;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario2 {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
	    driver= new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div/ul/li[2]/a/span")).click();
		Select drop = new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanType")));
		drop.selectByVisibleText("Personal");
		Thread.sleep(1000);
		Select drop1= new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanName")));
		
		drop1.selectByVisibleText("EducationLoan");
		driver.findElement(By.id("body_cph_Loans_txtReqLoanAmount")).sendKeys("50000");
		driver.findElement(By.id("body_cph_Loans_txtNoOfEMI")).sendKeys("12");
		driver.findElement(By.id("body_cph_Loans_btnViewEMI")).click();
		String value= driver.findElement(By.id("body_cph_Loans_lblEMIAmountText")).getText();
		float val=Float.parseFloat(value);
		if(val>4000) {
			System.out.println("Above 4000");
		}
		else if(val<4000) {
			System.out.println("below 4000");
		}
	
	}

}

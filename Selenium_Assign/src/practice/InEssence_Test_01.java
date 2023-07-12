package practice;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
public class InEssence_Test_01 {
	static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36:81/Automation/PackandGo/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void SignIn() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/header/div/div/a[4]")).click();
		driver.findElement(By.id("userName")).sendKeys("p&gGru");
		driver.findElement(By.id("password")).sendKeys("freezeray");
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[1]/form/button[1]")).click();
		Thread.sleep(1500);
		Select drop = new Select(driver.findElement(By.id("from")));
		Thread.sleep(1500);
		drop.selectByValue("Mysore");
		Select dropto = new Select(driver.findElement(By.xpath("//*[@id=\"to\"]")));
		dropto.selectByValue("Hyderabad");
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[3]/div/table/tr[4]/input")).click();
		Thread.sleep(1500);
		
		
		
	}

}

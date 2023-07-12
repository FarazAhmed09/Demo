package practice;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InEssence_Test_02 {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.181.42/Automation/PSRestuarant/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Test() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"download\"]/a")).click();
		Set<String> str = driver.getWindowHandles();
		for(String s:str) {
			driver.switchTo().window(s);
			if(driver.getCurrentUrl().equals("http://10.82.180.255:81/Automation/PSRestuarant/pages/HomeDelivery.html")){
				break;
				
			}
			
		}
		driver.findElement(By.xpath("//*[@id=\"image\"]/div[2]/form/div[1]/div/div[2]/div/label[2]/input")).click();
		Thread.sleep(1000);
		Select drop = new Select(driver.findElement(By.id("mainDish")));
		drop.selectByVisibleText("Chicken Biryani");
		Select drop1 = new Select(driver.findElement(By.id("curry")));
		drop1.selectByVisibleText("Chicken Chettinad");
		driver.findElement(By.id("name")).sendKeys("Arun");
		driver.findElement(By.id("address")).sendKeys("Chennai");
		driver.findElement(By.id("mobile")).sendKeys("8923103423");
		driver.findElement(By.id("email")).sendKeys("arun@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"image\"]/div[2]/form/div[8]/div/div[2]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"image\"]/div[2]/form/button")).click();
		Thread.sleep(1000);
		
		
		
	}

}

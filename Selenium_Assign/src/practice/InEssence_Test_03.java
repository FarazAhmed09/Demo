package practice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InEssence_Test_03 {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Status_Request() throws InterruptedException {
		driver.findElement(By.id("body_txtUserID")).sendKeys("Donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		Thread.sleep(3000);
		driver.findElement(By.id("body_btnLogin")).click();
		String str= "Welcome Donhere";
		assertTrue(driver.findElement(By.id("divWelcome")).getText().equals(str));
		driver.findElement(By.linkText("Account Request Status")).click();
		Select drop = new Select(driver.findElement(By.id("body_cph_MyAccount_ddlStatusType")));
		drop.selectByVisibleText("Pending");
		WebElement table = driver.findElement(By.id("body_cph_MyAccount_gvViewAccountRequestStatus"));
		List<WebElement> rows =table.findElements(By.tagName("tr"));
		for(WebElement r:rows) {
			System.out.println(r.getText());
		}
		
	}

}

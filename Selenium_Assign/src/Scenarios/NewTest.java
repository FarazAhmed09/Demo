package Scenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div/ul/li[2]/a/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("New Loan Request")).click();
		Select drop1 = new Select(driver.findElement(By.id("body_cph_Loans_ddlState")));
		drop1.selectByVisibleText("Karnataka");
		Thread.sleep(1000);
		Select drop2 = new Select(driver.findElement(By.id("body_cph_Loans_ddlCity")));
		drop2.selectByVisibleText("Mysore");
		Thread.sleep(2000);
		Select drop3 = new Select(driver.findElement(By.id("body_cph_Loans_ddlBranch")));
		drop3.selectByVisibleText("IEBI - KUVEMPUNAGAR");
		Thread.sleep(2000);
		Select drop4 = new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanType")));
		drop4.selectByVisibleText("Personal");
		
        WebElement table = driver.findElement(By.id("body_cph_Loans_gvLoanDetails"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println(rows.size());
        for(WebElement r:rows) {
        	List<WebElement> cols= r.findElements(By.tagName("td"));
        	for(WebElement c:cols)

        		if(cols.get(1).getText().equals("EducationLoan")) {
        			System.out.println("The max loan amount is "+cols.get(5).getText());
        			break;
        		}
        	
        }
	
		
		
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://10.82.180.36/Common/Login.aspx");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

  }

  @AfterClass
  public void afterClass() {
  }

}

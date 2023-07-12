package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class InEssence_Test_05 {
	static WebDriver driver;
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver_108\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//driver.close();
	}

	@Test
	void test() throws InterruptedException {
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
	    driver.findElement(By.id("body_btnLogin")).click();
	    driver.findElement(By.xpath("//*[@id=\"GeneralTabMenu_Deposit_li_Cust\"]/span")).click();
	    driver.findElement(By.linkText("Maturity Amount Calculator")).click();
	    driver.findElement(By.id("body_cph_Deposit_rbtnDepositType_0")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("body_cph_Deposit_txtDepositAmount")).sendKeys("50000");
	    driver.findElement(By.id("body_cph_Deposit_txtTerms")).sendKeys("14");
	    driver.findElement(By.id("body_cph_Deposit_btnCalculate")).click();
	    Thread.sleep(3000);
	    boolean t=driver.findElement(By.id("body_cph_Deposit_lblMaturityAmountValue")).isDisplayed();
	    
	    String str =driver.findElement(By.id("body_cph_Deposit_lblMaturityAmountValue")).getText();
	    float x =Float.parseFloat(str);
	    if(t) {
		    if(x>60000) {
		    	System.out.println("This is profitable");
		    	
		    }
		    else if(x<60000)
		    {
		    	System.out.println("This is not profitable");
		    }
		
	    }
	    else {
	    	System.out.println("Some error occured");
	    }
	    
	    driver.findElement(By.id("lbLoginOut")).click();
	    



	    
	}

}

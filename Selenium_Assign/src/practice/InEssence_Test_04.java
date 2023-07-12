package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class InEssence_Test_04 {
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
	void test() {
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
	    driver.findElement(By.id("body_btnLogin")).click();
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    for(WebElement c:links) {
	    	System.out.println(c.getText());
	    }
	    driver.findElement(By.xpath("//*[@id=\"GeneralTabMenu_Cards_li_Cust\"]/span")).click();
	    WebElement table =driver.findElement(By.id("body_cph_Cards_gvCreditCard"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    for(WebElement r:rows) {
	    	List<WebElement> cols =  r.findElements(By.tagName("td"));
	    	for(WebElement c:cols) {
	    		if(cols.get(1).getText().equals(cols.get(2).getText())) {
	    			System.out.println(cols.get(0).getText());
	    			break;
	    			
	    		}
	    	}
	
	    	
	    }
	    
	
	}

}

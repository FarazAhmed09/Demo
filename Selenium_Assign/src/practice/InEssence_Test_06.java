package practice;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import com.sun.jna.platform.RasterRangesUtils;

public class InEssence_Test_06 {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver_108\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws InterruptedException, IOException {
		driver.findElement(By.name("ctl00$body$txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
	    driver.findElement(By.id("body_btnLogin")).click();
	    driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div/ul/li[2]/a/span")).click();
	    //File f = new File("C:\\Users\\faraz.ahmed02\\Documents\\Excel\\Excel\\EMI Calculator.xlsx");
	    driver.findElement(By.linkText("New Loan Request")).click();
	    Select drop = new Select(driver.findElement(By.id("body_cph_Loans_ddlState")));
	    drop.selectByVisibleText("Karnataka");
	    Thread.sleep(1000);
	    Select drop1 = new Select(driver.findElement(By.id("body_cph_Loans_ddlCity")));
	    drop1.selectByIndex(2);
	    Thread.sleep(1000);
	    Select drop2 = new Select(driver.findElement(By.id("body_cph_Loans_ddlBranch")));
	    drop2.selectByVisibleText("IEBI - KUVEMPUNAGAR");
	    Thread.sleep(1000);
	    Select drop3 = new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanType")));
	    drop3.selectByVisibleText("Personal");
	    Thread.sleep(1000);
	    WebElement table = driver.findElement(By.id("body_cph_Loans_gvLoanDetails"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    for(WebElement r:rows) {
	    	List<WebElement> cols = r.findElements(By.tagName("td"));
	    	for(WebElement c:cols) {
	    		if(cols.get(1).getText().equals("EducationLoan")) {
	    			System.out.println("The max loan amount is "+cols.get(5).getText());
	    			break;
	    		}
	    		
	    	}
	   
	    }
	    Thread.sleep(1000);
		driver.findElement(By.linkText("EMI Calculator")).click();
		
		File f = new File("C:\\Users\\faraz.ahmed02\\Documents\\Excel\\Excel\\EMI Calculator.xlsx");
		FileInputStream fin = new FileInputStream(f);
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet = book.getSheet("Sheet1");
		//System.out.println(sheet.getFirstRowNum());
		//System.out.println(sheet.getLastRowNum());
		
		for (int i =sheet.getFirstRowNum();i<sheet.getLastRowNum();i++) {
	    	String LoanType=sheet.getRow(i).getCell(0).getStringCellValue();
	        String LoanName=sheet.getRow(i).getCell(1).getStringCellValue();
	        String LoanAmt= sheet.getRow(i).getCell(2).getRawValue();
	        String Emi=sheet.getRow(i).getCell(3).getRawValue();
	        System.out.println(LoanType+LoanName+LoanAmt+Emi);
	        Thread.sleep(1000);
	        
	        Select droper= new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanType")));
	        droper.selectByVisibleText(LoanType);
	        Thread.sleep(1000);
	        Select droper1= new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanName")));
	        droper1.selectByVisibleText(LoanName);
	        Thread.sleep(1000);
	        driver.findElement(By.id("body_cph_Loans_txtReqLoanAmount")).sendKeys(LoanAmt);
	        driver.findElement(By.id("body_cph_Loans_txtNoOfEMI")).sendKeys(Emi);
	       
		}
		
		driver.findElement(By.linkText("View Loan Transactions")).click();
		File Screenshoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshoot, new File ("C:\\Users\\faraz.ahmed02\\Pictures\\Saved Pictures\\LoanTransactions.png"));
		Thread.sleep(1000);
		driver.findElement(By.id("lbLoginOut"));
		
	}

}

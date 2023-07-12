package TEstNgDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class InEssenceTest07 {
  WebDriver driver;
  @Test(dataProvider = "dp")
  public void Test(String user, String pass) throws InterruptedException {
	  driver.findElement(By.id("body_txtUserID")).sendKeys(user);
	  driver.findElement(By.id("body_txtPassword")).sendKeys(pass);
	  Thread.sleep(1000);
	  driver.findElement(By.id("body_btnLogin")).click();
	  
  }
  @DataProvider
  public Object[][] dp() {
	   Object[][] d = new Object[1][2]; 
	   d[0][0]="donhere";
	   d[0][1]="don@123";
	   return d;
  }
  @Test
  public void loanDetails() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"GeneralTabMenu_Loans_li_Cust\"]/span")).click();
	  driver.findElement(By.linkText("New Loan Request")).click();
	  Select drop = new Select(driver.findElement(By.id("body_cph_Loans_ddlState")));
	  drop.selectByVisibleText("Karnataka");
	  Thread.sleep(1000);
	  Select drop1 = new Select(driver.findElement(By.id("body_cph_Loans_ddlCity")));
	  drop1.selectByVisibleText("Mysore");
	  Thread.sleep(1000);
	  Select drop2 = new Select(driver.findElement(By.id("body_cph_Loans_ddlBranch")));
	  drop2.selectByVisibleText("IEBI - KUVEMPUNAGAR");
	  Thread.sleep(1000);
	  Select drop3 = new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanType")));
	  drop3.selectByVisibleText("Personal");
	  Thread.sleep(2000);
  }
  
  @Test(priority = 2,dataProvider = "getData",dependsOnMethods ="Test")
  public void emiCalculator(String LoanType,String LoanName,String LoanAmt,String Emi) throws IOException, InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"body_pnlCustomer_SubMenu\"]/div/div/ul/li[1]/a")).click(); 
	  Thread.sleep(1000);
	  Select drop= new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanType")));
	  drop.selectByVisibleText(LoanType);
	  Thread.sleep(1000);
	  Select drop1= new Select(driver.findElement(By.id("body_cph_Loans_ddlLoanName")));
	  drop1.selectByVisibleText(LoanName);
	  Thread.sleep(1000);
	  driver.findElement(By.id("body_cph_Loans_txtReqLoanAmount")).sendKeys(LoanAmt);
	  driver.findElement(By.id("body_cph_Loans_txtNoOfEMI")).sendKeys(Emi);
	  Thread.sleep(1000);
	  driver.findElement(By.id("body_cph_Loans_btnViewEMI")).click();
	  Thread.sleep(1000);
	  System.out.println("The EMI amount is :"+driver.findElement(By.id("body_cph_Loans_lblEMIAmountText")).getText());
	  driver.findElement(By.id("body_cph_Loans_btnReset")).click();
	  
	  
  }
  

  
  @DataProvider
  public Object[][] getData(){
	  Object[][] d = new Object[4][4];
	  
	  d[0][0]="Personal";
	  d[0][1]="EducationLoan";
	  d[0][2]="10000";
	  d[0][3]="12";
	  
	  d[1][0]="Personal";
	  d[1][1]="HousingLoan";
	  d[1][2]="50000";
	  d[1][3]="10";
	  
	  d[2][0]="Property";
	  d[2][1]="ResidentialProperty";
	  d[2][2]="350000";
	  d[2][3]="24";
	  
	  d[3][0]="Property";
	  d[3][1]="CommercialProperty";
	  d[3][2]="460000";
	  d[3][3]="36";
	  
	  return d;	 
  }
  @BeforeClass
  public void beforeClass() {
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver109\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
  }
  @AfterClass
  public void afterClass() {
	  driver.findElement(By.id("lbLoginOut")).click();
	  
  }

}

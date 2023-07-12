package Letskode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Pomexample {
	
	WebDriver driver;
  @Parameters({"browsername","url"})
  @Test
  public void initialize(String browsername, String url) {
	// TODO Auto-generated method stub
	
	switch(browsername) {
	
	case "Chrome":
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\faraz.ahmed02\\Music\\IVS_FILES\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 
		 break;
		 
	case "FF":
		driver= new FirefoxDriver();
		driver.get(url);
	    driver.manage().window().maximize();
	}
	
	
}
}

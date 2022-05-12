package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadDataFromProperties {

	public static void main(String[] args) throws Throwable {
		
		/*step1 : get the Java  representation Object of the Physical file*/
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		
		/*step-2 : load the key:values from Property class*/
		Properties pObj = new Properties();
		           pObj.load(fis);
		
		/*step-3 : read the value using key*/
	     String URL = pObj.getProperty("url");
	     String USERNAME = pObj.getProperty("username");
	     String PASSWORD = pObj.getProperty("password");
	     String BROWSER = pObj.getProperty("browser");
      
		                                        
		WebDriver driver = null;    
		if(BROWSER.equals("firefox")) {
		   driver = new FirefoxDriver(); 
		}else if(BROWSER.equals("chrome")) {
		   driver = new ChromeDriver();
		}else if(BROWSER.equals("ie")) {
	       driver = new InternetExplorerDriver();
		}
		
		
		
		 driver.get(URL);
		          
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

}
}
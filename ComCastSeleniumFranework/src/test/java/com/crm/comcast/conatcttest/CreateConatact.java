package com.crm.comcast.conatcttest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtlity;
import com.crm.comcast.pomrepositoryutility.CampaignsPage;
import com.crm.comcast.pomrepositoryutility.ContactInfomation;
import com.crm.comcast.pomrepositoryutility.Contacts;
import com.crm.comcast.pomrepositoryutility.CreateNewCampaignPage;
import com.crm.comcast.pomrepositoryutility.CreateNewConatcts;
import com.crm.comcast.pomrepositoryutility.Home;

public class CreateConatact extends BaseAnnoationClass{

		
	@Test(groups = "smokeTest")
	public void createrConatctTest() throws Throwable{

			/*get ranDomNum*/
			int intRanNum = jLib.getRanDomNumber();
			
			/*read test data from Excel*/
			   String contactName = eLib.getExcelData("contact", 1, 2)+intRanNum;
	
				/*step 2 : Navigate to Contact Page*/
			     Home hp = new Home(driver);
			     hp.getContactLnk().click();
				
				/*step 3 : Navigate create new Contact Page */
			     Contacts cp = new Contacts(driver);
			     cp.getCreateContactImg().click();
		       
				/*step 4 : Create Contact */
		        CreateNewConatcts cnp = new CreateNewConatcts(driver);
		        cnp.createConatct(contactName);
				
				/*step 5 : Verify the Contact details*/
		        ContactInfomation ci = new ContactInfomation(driver);
		        String actLstName = ci.getOrgHeaderSucMsg().getText();
			
			  /*verify*/
			Assert.assertEquals(actLstName.contains(contactName), true);
	
		}
	
	@Test(groups = "regressionTest")
	public void CreateContactWithOutMandateTest() throws Throwable {
		
		/*read test data from Excel*/	
		   String expectedAlertMsg = eLib.getExcelData("contact", 7, 2);

		   /*step 2 : navigate to Create Campaign page*/
           Home hp = new Home(driver);
                hp.navigateToCampaginPage();
	
      /*step 3 : navigate to Create Campaign page*/
          CampaignsPage cp = new CampaignsPage(driver);
          cp.getCreatenewCamapaignBtn().click();
		
	   /*step 4 : create a new Campaign */
          CreateNewCampaignPage cnp = new CreateNewCampaignPage(driver);
          cnp.getSaveBtn().click();
		  /*verify*/
	       assertTrue(wLib.swithToAlertWindowAndAccpect(driver, expectedAlertMsg));
	       

	}
          
	}







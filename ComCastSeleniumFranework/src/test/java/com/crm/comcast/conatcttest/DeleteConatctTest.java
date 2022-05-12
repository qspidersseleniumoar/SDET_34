package com.crm.comcast.conatcttest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.pomrepositoryutility.Contacts;
import com.crm.comcast.pomrepositoryutility.CreateNewConatcts;
import com.crm.comcast.pomrepositoryutility.Home;

public class DeleteConatctTest extends BaseAnnoationClass{
	
@Test(groups = "smokeTest")
public void deleteConatctTest() throws Throwable
{
	
		/*get ranDomNum*/
		int intRanNum = jLib.getRanDomNumber();
		
		/*read test data from Excel*/
		   String contactName = eLib.getExcelData("contact", 4, 2)+intRanNum;
		   String serfachFor = eLib.getExcelData("contact", 4, 3);
		   String expectedAlertMeg = eLib.getExcelData("contact", 4, 4);
		

			/*step 2 : Navigate to Contact Page*/
		     Home hp = new Home(driver);
		     hp.getContactLnk().click();
			
			/*step 3 : Navigate create new Contact Page */
		     Contacts cp = new Contacts(driver);
		     cp.getCreateContactImg().click();
	       
			/*step 4 : Create Contact */
	        CreateNewConatcts cnp = new CreateNewConatcts(driver);
	        cnp.createConatct(contactName);
	        wLib.waitForPage(driver, "DetailView&module=Contacts");
	        
		/*step 5 : navigate to  contact  list page*/
	        hp.getContactLnk().click();
	        wLib.waitForPage(driver, "module=Contacts");
         
		/*step 6 : search the created conatct & delete*/
        Contacts csp = new Contacts(driver);
        csp.searcContact(contactName, serfachFor);
		driver.findElement(By.xpath("//a[text()='"+contactName+"']/../../td[1]/input")).click();
	    csp.getDeleteBtn().click();
		
		  /*verify*/
	       assertTrue(wLib.swithToAlertWindowAndAccpect(driver, expectedAlertMeg));
 
	
	}

}

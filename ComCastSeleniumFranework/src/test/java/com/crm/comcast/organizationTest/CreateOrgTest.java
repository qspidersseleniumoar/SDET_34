package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtlity;
import com.crm.comcast.pomrepositoryutility.CreatingNewOrganization;
import com.crm.comcast.pomrepositoryutility.Home;
import com.crm.comcast.pomrepositoryutility.OrganizationInformation;
import com.crm.comcast.pomrepositoryutility.Organizations;

public class CreateOrgTest extends BaseAnnoationClass{
	
	@Test(groups = "smokeTest")
	public  void createOrgTest() throws Throwable {

		/*get ranDomNum*/
		int intRanNum = jLib.getRanDomNumber();
		
		/*read test data from Excel*/
		   String orgName = eLib.getExcelData("org", 1, 2)+intRanNum; 
		
		/*step 2 : navigate to Organization page*/
		     Home hp = new Home(driver);
		     hp.getOrgLink().click();
		     
		/*step 3 : navigate to Create Organization page*/
		     Organizations op = new Organizations(driver);
		     op.getCreatenewOrgImg().click();

		/*step 4 : create a new Org*/
           CreatingNewOrganization cnop = new CreatingNewOrganization(driver);
           cnop.createOrg(orgName);

		   /*verify*/
           OrganizationInformation oip = new OrganizationInformation(driver);
           Assert.assertEquals(oip.getOrgHeaderSucMsg().getText().contains(orgName), true);


	}

}

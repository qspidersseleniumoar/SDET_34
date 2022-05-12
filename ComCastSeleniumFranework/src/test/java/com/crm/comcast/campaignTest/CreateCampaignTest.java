package com.crm.comcast.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnoationClass;
import com.crm.comcast.pomrepositoryutility.CampaignInformationPage;
import com.crm.comcast.pomrepositoryutility.CampaignsPage;
import com.crm.comcast.pomrepositoryutility.CreateNewCampaignPage;
import com.crm.comcast.pomrepositoryutility.CreateNewProductPage;
import com.crm.comcast.pomrepositoryutility.Home;
import com.crm.comcast.pomrepositoryutility.Products;

public class CreateCampaignTest extends BaseAnnoationClass{
	@Test(groups = "smokeTest")
	public void createCampaginTest() throws Throwable {


		/*get ranDomNum*/
		int intRanNum = jLib.getRanDomNumber();
		
		/*read test data from Excel*/
	   String campaignName = eLib.getExcelData("campaign", 1, 2)+intRanNum;

			
	    /*step 2 : navigate to Create Campaign page*/
            Home hp = new Home(driver);
                 hp.navigateToCampaginPage();
	
       /*step 3 : navigate to Create Campaign page*/
           CampaignsPage cp = new CampaignsPage(driver);
           cp.getCreatenewCamapaignBtn().click();
		
	   /*step 4 : create a new Campaign */
           CreateNewCampaignPage cnp = new CreateNewCampaignPage(driver);
           cnp.createNewCampaign(campaignName);
		  /*verify*/
		  CampaignInformationPage cip = new CampaignInformationPage(driver);
		  String actinfo = cip.getCampaginHeraderInfo().getText();
		  
		  Assert.assertEquals(actinfo.contains(campaignName), true);

	}
	
	  @Test(groups = "regressionTest")
      public void creatreCampaginWithProductTest() throws Throwable{
		
		/*get ranDomNum*/
		int intRanNum = jLib.getRanDomNumber();
		
		/*read test data from Excel*
		/*read test data from Excel*/
		   String campaignName = eLib.getExcelData("campaign", 4, 2)+intRanNum;
		   String productName = eLib.getExcelData("campaign", 4, 3)+intRanNum;


	   /*step 2 : navigate to Products page*/	
           Home hp = new Home(driver);
                hp.getProductLnk().click();
		     
	   /*step 3 : navigate to Create Product page*/
                Products pp=new  Products(driver);
                pp.getcreateProductImg().click();
		     
	  /*step 4 : create a new product*/    
                CreateNewProductPage cnp = new CreateNewProductPage(driver);
                cnp.createNewProduct(productName);
	  /*verify*/
		    wLib.waitForPage(driver, "DetailView&module=Products"); 
					     
      /*step 5 : navigate to Campaign page*/	     
		    hp.navigateToCampaginPage();
		
     /*step 6 : navigate to Create Campaign page*/
	           CampaignsPage cp = new CampaignsPage(driver);
	           cp.getCreatenewCamapaignBtn().click();
		
	/*step 7 : create a new Campaign with product*/
	           CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
	           cncp.createNewCampaign(campaignName, productName);
	 /*Verify */          
	 		  CampaignInformationPage cip = new CampaignInformationPage(driver);
			  String actinfo = cip.getCampaginHeraderInfo().getText();

			  Assert.assertEquals(actinfo, true);


	}

}

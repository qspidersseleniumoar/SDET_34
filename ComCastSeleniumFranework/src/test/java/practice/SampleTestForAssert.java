package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseAnnoationClass;

@Listeners(com.crm.comcast.genericutility.ListnerImgClass.class)
public class SampleTestForAssert extends  BaseAnnoationClass{

	
	@Test
	public void verifyHomePage() throws IOException {
		System.out.println("=====START==========");
         
       Assert.assertEquals("A", "B");
		
		System.out.println("=====END==========");
	}
	
	
	@Test
	public void verifyLogoInhomePage() {
		System.out.println("=====START==========");

	  
		System.out.println("=====END==========");

	}
}

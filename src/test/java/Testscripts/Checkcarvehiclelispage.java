package Testscripts;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

import Libraryfiles.Testbase;
	
	//@Listeners(listener.Checkcarvehiclelispage.class)

	public class Checkcarvehiclelispage extends Testbase{
		
		public static Checkcarvehiclelispage list;
		public static Logintest login1;
		
		@BeforeMethod
		public void setup()
		{
			initialization();
		}
		@Test(priority=1,description="Enter venue and navigating to vehicle list page")
		public void venueclick() throws InterruptedException 
		{
			
			driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
			findelementandclick(venueclick);
			//Thread.sleep(3000);
		    Actions actions = new Actions(driver);
		    actions.sendKeys(pop.getProperty("venue")).perform();
		   // Thread.sleep(2000);
		    findelementandclickcss(venuevaluecss);
		    //Thread.sleep(8000);
		    AssertJUnit.assertEquals(findelementreturn(withfuelbutton), "With Fuel");
		   // Thread.sleep(2000);
		    
		}
		@Test(priority=2)
		public void selectcalender() throws InterruptedException {
			venueclick();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Thread.sleep(2000);
			findelementandclick(startdateclick);
			//Thread.sleep(3000);
			findelementdate(pop.getProperty("date1"));
			findelementandclick(enddateclick);
			findelementdate(pop.getProperty("date1"));
			findelementandclicktext(pop.getProperty("searchtext"));
		    Thread.sleep(3000);
		}
		@Test(priority=3)
		public void flexipackagecheck() throws InterruptedException {
			
			selectcalender();
			 Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String str=findelementandreturntext(pop.getProperty("buildpackagetext"));
			AssertJUnit.assertEquals(str, "Build your own package");
			 Thread.sleep(3000);
			findelementandclick(togglebuttonclick);
			String str1=findelementandreturntext(pop.getProperty("buildpackagetoggleon"));
			AssertJUnit.assertEquals(str1, "Build your package");
			findelementandclickcss(Enterkm);
			Actions actions = new Actions(driver);
			actions.sendKeys(pop.getProperty("enterkms")).perform();
			 Thread.sleep(3000);
			findelementandclick(flexibutton);
			 Thread.sleep(4000);
			 findelementandclick(flexieditbutton);
			Thread.sleep(2000);
			 findelementandclear(Enterkm);
			Thread.sleep(2000);
			findelementandclickcss(Enterkm);
			actions.sendKeys(pop.getProperty("enterkms")).perform();
			 Thread.sleep(3000);
			 findelementandclick(flexibutton);
		 Thread.sleep(3000);
		}
		@Test(priority=4)
		public void Withfuelpackagecheck() throws InterruptedException {
			
			selectcalender();
			 Thread.sleep(3000);
			 findelementandclickkms(pop.getProperty("20kms"));
			 Thread.sleep(3000);
			 String str=findelementandkmreturntext(pop.getProperty("20kmss"));
			 AssertJUnit.assertEquals(str, "20 kms");
			 System.out.println(str);
			 Thread.sleep(3000);
			 findelementandclickkms(pop.getProperty("10kms"));
			 Thread.sleep(3000);
			 String str1=findelementandkmreturntext(pop.getProperty("10kmss"));
			 AssertJUnit.assertEquals(str1, "10 kms");
			 System.out.println(str1);
			 findelementandclickkms(pop.getProperty("30kms"));
			 Thread.sleep(3000);
			 String str2=findelementandkmreturntext(pop.getProperty("30kmss"));
			 AssertJUnit.assertEquals(str2, "30 kms");
			 System.out.println(str2);
			 Thread.sleep(3000); 
		}
		
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}

}

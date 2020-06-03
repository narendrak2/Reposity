package Testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Libraryfiles.Testbase;

public class Bikecheckoutpage extends Testbase{

	public static Checkcarvehiclelispage list;
	@BeforeMethod
	public void setup()
	{
		initialization();
		list =new Checkcarvehiclelispage();
	}
	@Test
	public void Gotocheckoutpage() throws InterruptedException {
		list.venueclick();
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findelementandclick(clickonbike);
		//Thread.sleep(4000);
    Assert.assertEquals(findelementreturn(Nofueltext), "No-fuel");
    //Thread.sleep(3000);
    //car.selectcalender();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Thread.sleep(2000);
	findelementandclick(startdateclick);
	//Thread.sleep(3000);
	findelementdate(pop.getProperty("date1"));
	findelementandclick(enddateclick);
	findelementdate(pop.getProperty("date2"));
	findelementandclicktext(pop.getProperty("searchtext"));
    //Thread.sleep(3000);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

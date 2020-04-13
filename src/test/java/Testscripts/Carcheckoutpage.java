package Testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Libraryfiles.Testbase;

public class Carcheckoutpage extends Testbase{

	public static Checkcarvehiclelispage car;
	@BeforeMethod
	public void setup()
	{
		initialization();
		car=new Checkcarvehiclelispage();
	}
	
	@Test(priority=1)
	public void checkoutpage() throws InterruptedException {
	
		car.venueclick();
		Thread.sleep(5000);
		findelementandclick(clickonbikesorcar);
		Thread.sleep(5000);
		
	
}
}

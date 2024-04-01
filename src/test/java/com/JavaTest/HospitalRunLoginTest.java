package com.JavaTest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.Utilities.HospitalRunBaseclass;
public class HospitalRunLoginTest extends HospitalRunBaseclass
{
	@Test(priority = 1)
	public static void login() throws IOException, Exception
	{
		intialisation();
		browserintilisation();
		launchUrl();
		pageIntialization(); 
		HospitalRunBaseclass.loginfun();
		Thread.sleep(3000);
	}
}

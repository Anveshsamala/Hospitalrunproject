package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HospitalRunLoginPage 
{
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/a")
	public static WebElement login_Go_to_the_Demo;

	@FindBy(xpath="//*[@id=\"identification\"]")
	public static WebElement login_username;

	@FindBy(xpath="//*[@id=\"password\"]")
	public static WebElement login_password;

	@FindBy(xpath="//*[@id=\"ember433\"]/div/form/div[2]/button")
	public static WebElement login_btn;
}

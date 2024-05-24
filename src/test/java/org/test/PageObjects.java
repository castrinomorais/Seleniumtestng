package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {

	public WebDriver driver;

	@FindBy(xpath="(//span[@class=\'ui-button-text ui-c\'])[1]")
	public static WebElement simplealertButton;
	
	@FindBy(id="j_idt88:j_idt106")
	public static WebElement  confirmButton;
	
	@FindBy(id="j_idt88:j_idt104")
	public static WebElement promptalertButton;
	
	@FindBy(linkText="Broken?")
	public static WebElement AmIBroken;

	@FindBy(xpath="//select[@class=\'ui-selectonemenu\']")
	public static WebElement favoriteautomationtool;
	
	@FindBy(id="j_idt88:new")
	public static WebElement openbutton;
	
	@FindBy(xpath="//i[@class='pi pi-globe layout-menuitem-icon']")
	public static WebElement browser;
	
	@FindBy(xpath="(//button[@id=\'Click\'])[1]")
	public static WebElement clickMebutton;
	
	@FindBy(xpath="(//div[@class=\'ui-chkbox-box ui-widget ui-corner-all ui-state-default\'])[1]")
	public static WebElement basicCheckbox;
	
	@FindBy(xpath="(//div[@class=\'ui-chkbox-box ui-widget ui-corner-all ui-state-default\'])[3]")
	public static WebElement javaCheckbox;
	
	@FindBy(xpath="(//div[@class=\'ui-chkbox-box ui-widget ui-corner-all ui-state-default\'])[4]")
	public static WebElement pythonCheckbox;
	
	
	@FindBy(xpath="//*[@class=\'ui-toggleswitch-slider\']")
	public static WebElement	toogleSwitch ;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[2]/div/div/div")
	public static WebElement disabledCheckbox;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[1]/div/div/table/tbody/tr/td[3]/div/div[2]")
	public static WebElement  Safari;
	
	@FindBy(id="j_idt88:name")
	public static WebElement typeYourName;
	
	@FindBy(id="j_idt88:j_idt91")
	public static WebElement appendCountryToThisCity;
	
	
	@FindBy(id="j_idt88:j_idt93")
	public static WebElement txtbox;
	
	@FindBy(id="j_idt88:j_idt95")
	public static WebElement clearText;
	
	
	@FindBy(id="j_idt88:j_idt97")
	public static WebElement retrieveText;
	
	@FindBy(id="j_idt88:j_idt89_input")
	public static WebElement uploadButton;
	
	@FindBy(id="j_idt87:j_idt90")
	public static WebElement Iamhere;
	
	@FindBy(id="j_idt93:j_idt95")
	public static WebElement downloadButton;
	
	@FindBy(linkText="Go to Dashboard")
	public static WebElement gotoDashboard;
	
	@FindBy(linkText="Find the URL without clicking me.")
	public static WebElement findmyDestination;
	
	@FindBy(linkText="Broken?")
	public static WebElement Broken;
}

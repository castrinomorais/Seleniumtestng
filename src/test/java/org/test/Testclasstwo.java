package org.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Testclasstwo {
	
	@Test
	public void windowHandlesExercise() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Click  openbutton  a new window opens and we click the browser icon in the child window.
				String parentwindow = driver.getWindowHandle();
				PageFactory.initElements(driver, PageObjects.class);
				PageObjects.openbutton.click();
				Set<String> allwindowhandles = driver.getWindowHandles();
				for (String wh : allwindowhandles) {
					if(!wh.equals(parentwindow)) {
						driver.switchTo().window(wh);
						
					}
					PageFactory.initElements(driver, PageObjects.class);
					PageObjects.browser.click();
					driver.close();
					
	}
	}
	@Test
	public void windowHandlesExercisetwo() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// parent window contains window handle value of the parent
		String parentwindow = driver.getWindowHandle();
		WebElement openmultipleButton = driver.findElement(By.id("j_idt88:j_idt91"));
		openmultipleButton.click();
		//allwindowhandles set contain the window handle values of all the windows opened 
		Set<String> allwindowhandles = driver.getWindowHandles();
		// we use size method over the set to count the number of window handles values of the windows opened stored in the set
		int numberofwindows = allwindowhandles.size();
	//	The value returned by the set method stored in a variable is printed
		System.out.println(numberofwindows);
		System.out.println(allwindowhandles);
		driver.quit();
	}
	
	@Test
	public void seleniumIframes() {
		//To click a button inside an iframe and get the text 
				WebDriver driver;
				driver =new ChromeDriver();
				driver.get("https://www.leafground.com/frame.xhtml");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.switchTo().frame(0);
				WebElement clickMebutton = driver.findElement(By.xpath("(//button[@id=\'Click\'])[1]"));
				clickMebutton.click();
				String textvalue = clickMebutton.getText();
				System.out.println(textvalue);
				driver.quit();
	}
	@Test
	public void numberOfFramesInWebpage() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	System.out.println(frames);
	int totalframes = frames.size();
		System.out.println("The total number of frames in webpage "+     +totalframes);
		driver.close();
	}
	
	@Test
	public void checkBox() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.leafground.com/checkbox.xhtml");
		//Select a basic checkbox
		PageFactory.initElements(driver,PageObjects.class);
		//WebElement basicCheckbox = driver.findElement(By.xpath("(//div[@class=\'ui-chkbox-box ui-widget ui-corner-all ui-state-default\'])[1]"));
		PageObjects.basicCheckbox.click();
		
		//Selecting multiple checkboxes
		
		//WebElement javaCheckbox = driver.findElement(By.xpath("(//div[@class=\'ui-chkbox-box ui-widget ui-corner-all ui-state-default\'])[3]"));
		PageObjects.javaCheckbox.click();
		
		//WebElement pythonCheckbox = driver.findElement(By.xpath("(//div[@class=\'ui-chkbox-box ui-widget ui-corner-all ui-state-default\'])[4]"));
		PageObjects.pythonCheckbox.click();
		 
		 //To Select a toggle switch slider
		// WebElement toogleSwitch = driver.findElement(By.xpath("//*[@class=\'ui-toggleswitch-slider\']"));
		PageObjects.toogleSwitch.click();
		 
		 //To verify if the check box is disabled 
		 //WebElement disabledCheckbox = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[2]/div/div/div"));
		PageObjects.disabledCheckbox.click();
		boolean enabledStatusOfCheckbox= PageObjects.disabledCheckbox.isEnabled();
		 System.out.println(enabledStatusOfCheckbox);
		 
	driver.close();
		 
	}
	
	@Test
	public void seleniumRadioButtons() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Selecting a radio button
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/div/div/table/tbody/tr/td[1]/div/div[2]")).click();
		
		
		//Status of the radio button safari0 in the Find default selection radio button
		PageFactory.initElements(driver,PageObjects.class);
		boolean selectioStatusOfSafari = PageObjects.Safari.isSelected();	
		boolean displayStatusOfSafari = PageObjects.Safari.isDisplayed();
		boolean enabledStatusOfSafari = PageObjects.Safari.isEnabled();

System.out.println(selectioStatusOfSafari);
System.out.println(displayStatusOfSafari);
System.out.println(enabledStatusOfSafari);
driver.close();
	}

}

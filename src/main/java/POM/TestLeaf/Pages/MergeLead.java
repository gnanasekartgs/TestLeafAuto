package POM.TestLeaf.Pages;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeLead
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("http://leaftaps.com/opentaps/control/main");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.findElementById("username").sendKeys("demosalesmanager");
		d.findElementById("password").sendKeys("crmsfa");
		d.findElementByClassName("decorativeSubmit").click();
		
		d.findElementByXPath("//div[@for='crmsfa']//a").click();
		d.findElementByXPath("//a[text()='Leads']").click();
		d.findElementByXPath("//a[text()='Merge Leads']").click();
		
		String phandle = d.getWindowHandle();
		d.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following::a[1]").click();
		//String windowHandle = d.getWindowHandle();
		//d.switchTo().window(windowHandle);
		for (String string : d.getWindowHandles()) 
		{
			d.switchTo().window(string);
		}
		
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys("10064");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		d.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a").click();
		Thread.sleep(5000);
	
		d.switchTo().window(phandle);
		d.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
		
		String windowHandle1 = d.getWindowHandle();
		d.switchTo().window(windowHandle1);
		
		for (String strings : d.getWindowHandles()) 
		{
			d.switchTo().window(strings);
		}
	
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys("10065");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		d.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a").click();
		Thread.sleep(5000);
		d.switchTo().window(windowHandle1);
		d.findElementByClassName("buttonDangerous").click();
		//d.findElementByXPath("//a[text()='Merge']").click();
		
		d.switchTo().alert().accept();
		
		if(d.getTitle().equals("View Lead | opentaps CRM"))
		{
			d.findElementByXPath("//a[text()='Find Leads']").click();
		}
		else
		{
			WebDriverWait wait = new WebDriverWait(d, 10);
			WebElement until = wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Find Leads']"))));
			until.click();
			
		}
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys("10064");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		
		WebElement errormsg = d.findElementByXPath("//div[@class='x-paging-info']");
		String msg = errormsg.getText();
		System.out.println(msg);
		
		if(msg.equalsIgnoreCase("No records to display"))
		{
			System.out.println("error msg");
		}else
		{
			System.out.println("wrong err msg");
		}
		d.close();
	}

}

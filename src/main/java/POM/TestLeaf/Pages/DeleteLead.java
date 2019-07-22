package POM.TestLeaf.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteLead {

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
		d.findElementByLinkText("Find Leads").click();
		d.findElementByXPath("//span[text()='Phone']").click();
		d.findElementByXPath("//input[@name='phoneAreaCode']").sendKeys("044");
		d.findElementByXPath("//input[@name='phoneNumber']").sendKeys("99999999");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebElement id = d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String idno = id.getText();
		Thread.sleep(2000);
		d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		d.findElementByClassName("subMenuButtonDangerous").click();
		d.findElementByXPath("//a[text()='Find Leads']").click();
		d.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys("10045");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		WebElement errormsg = d.findElementByXPath("//div[@class='x-paging-info']");
		String text = errormsg.getText().toString();
		System.out.println(text);
		
		if(text.equalsIgnoreCase("No records to display"))
		{
			System.out.println("No data found");
		}
		else
		{
			System.out.println("data present");
		}
		d.close();
	}
}

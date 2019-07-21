package POM.TestLeaf.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
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
		d.findElementByXPath("//span[text()='Email']").click();
		d.findElementByXPath("//input[@name='emailAddress']").sendKeys("gnana@gmsil.com");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		WebElement firstname = d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]");
		String fname = firstname.getText();
		System.out.println(fname);
		
		d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		d.findElementByXPath("(//div[@class='frameSectionExtra']//a)[1]").click();
		String title = d.getTitle();
		
		if(title.equals("Duplicate Lead | opentaps CRM"))
		{
			System.out.println("correct title");
		}
		else
		{
			System.out.println("wrong title");
		}
		
		d.findElementByXPath("//input[@value='Create Lead']").click();
		String dname = d.findElementById("viewLead_firstName_sp").getText();
		System.out.println(dname);
		
		if(fname.equalsIgnoreCase(dname))
		{
			System.out.println("duplicate name");
		}
		else
		{
			System.out.println("not duplicate name");
		}
		d.close();
	}

}

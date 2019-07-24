package POM.TestLeaf.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

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
		d.findElementByXPath("//div[@class='x-tab-panel-bwrap']//div[2]//input").sendKeys("gnana");
		d.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		d.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		
		String title = d.getTitle();
		if(title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("correct title");
		}
		else
		{
			System.out.println("wrong title");
		}
		
		d.findElementByXPath("(//div[@class='frameSectionExtra'])[2]//a[3]").click();
		d.findElementById("updateLeadForm_companyName").clear();
		d.findElementById("updateLeadForm_companyName").sendKeys("allusa");
		//d.findElementById("(//input[@name='submitButton'])[1]").click();
		d.findElementByXPath("(//span[text()='Important Note']/following::input)[1]").click();
		
		String text = d.findElementById("viewLead_companyName_sp").getText();
		
		System.out.println(text.replaceAll("[^a-zA-Z]", ""));
		
		d.close();
	}

}

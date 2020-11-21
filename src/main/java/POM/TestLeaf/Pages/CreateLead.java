package POM.TestLeaf.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args)
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
		d.findElementByLinkText("Create Lead").click();
		
		d.findElementById("createLeadForm_companyName").sendKeys("all");
	    d.findElementById("createLeadForm_firstName").sendKeys("gnana");
		d.findElementById("createLeadForm_lastName").sendKeys("sekar");
		d.findElementById("createLeadForm_firstNameLocal").sendKeys("gnanasekar");
		d.findElementById("createLeadForm_lastNameLocal").sendKeys("t");
		d.findElementById("createLeadForm_personalTitle").sendKeys("GNANASEKAR");
		
		WebElement source = d.findElementById("createLeadForm_dataSourceId");
		Select sselect = new Select(source);
		sselect.selectByValue("LEAD_CONFERENCE");
		
		d.findElementById("createLeadForm_generalProfTitle").sendKeys("Tester");
		d.findElementById("createLeadForm_annualRevenue").sendKeys("100000");
		
		Select iselect = new Select(d.findElementById("createLeadForm_industryEnumId"));
		iselect.selectByVisibleText("Computer Software");
		
		Select oselect = new Select(d.findElementById("createLeadForm_ownershipEnumId"));
		oselect.selectByVisibleText("Sole Proprietorship");
		
		d.findElementById("createLeadForm_sicCode").sendKeys("001");
		d.findElementById("createLeadForm_description").sendKeys("hi");
		d.findElementById("createLeadForm_importantNote").sendKeys("nothing");
		d.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("+91");
		d.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("044");
		d.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("4334143");
		d.findElementById("createLeadForm_departmentName").sendKeys("computer");
		
		Select currency = new Select(d.findElementById("createLeadForm_currencyUomId"));
		currency.selectByVisibleText("INR - Indian Rupee");
		
		d.findElementById("createLeadForm_numberEmployees").sendKeys("1000");
		d.findElementById("createLeadForm_tickerSymbol").sendKeys("ind");
		d.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("0444334111");
		d.findElementById("createLeadForm_primaryWebUrl").sendKeys("https://www.seleniumhq.org");
		d.findElementById("createLeadForm_generalToName").sendKeys("tgs");
		d.findElementById("createLeadForm_generalAddress1").sendKeys("tirupur");
		d.findElementById("createLeadForm_generalAddress2").sendKeys("chennai");
		d.findElementById("createLeadForm_generalCity").sendKeys("chennai");
		
		Select state = new Select(d.findElementById("createLeadForm_generalStateProvinceGeoId"));
		state.selectByVisibleText("California");
		
		Select country = new Select(d.findElementById("createLeadForm_generalCountryGeoId"));
		country.selectByVisibleText("American Samoa");
		
		d.findElementById("createLeadForm_generalPostalCode").sendKeys("60001");
		d.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("60002");
		
		Select campaign = new Select(d.findElementById("createLeadForm_marketingCampaignId"));
		campaign.selectByValue("DEMO_MKTG_CAMP");
		
		d.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("99999999");
		d.findElementById("createLeadForm_primaryEmail").sendKeys("gnana@gmail.com");
		d.findElementByClassName("smallSubmit").click();	
		
		String fname = d.findElementByXPath("//span[text()='First name']/following::span[1]").getText();
		System.out.println(fname);
		
		//String firstname1 = fname.toString();
		if(fname.equalsIgnoreCase("gnana"))
		{
			System.out.println("first name is verified");	
		}
		else
		{
			System.out.println("first name verification failed");
		}
		d.close();
		
	}

}

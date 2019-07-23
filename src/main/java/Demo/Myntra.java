package Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://www.myntra.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		d.findElementByXPath("(//div[@class='desktop-navLink']/a)[1]").click();
		d.findElementByXPath("(//a[@class='navi-link  navi-underline'])[1]").click();
		
		
		WebElement driver = d.findElementByXPath("//img[@alt='Moda Rapido Men Maroon Printed Round Neck T-shirt']");
		//WebElement driver = d.findElementByXPath("(//picture[@class='img-responsive'])[1]");
//		Actions action = new Actions(d);
//		action.moveByOffset(210, 280).perform();
		driver.click();
		

		Set<String> allwindow = d.getWindowHandles();
		List<String> all =new ArrayList();
		all.addAll(allwindow);
		d.switchTo().window(all.get(1));
		d.findElementByXPath("//p[text()='L']").click();
		d.findElementByClassName("myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center").click();
		d.findElementByXPath("//span[text()='GO TO BAG']").click();
		
		
		
	}

}

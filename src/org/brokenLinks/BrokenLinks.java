package org.brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		 
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse 2023 workspace\\IPT\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.deadlinkchecker.com/");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		
		for (int i = 0; i < allLinks.size(); i++) {
			
		String individualLink = allLinks.get(i).getAttribute("href");
			
			URL url = new URL(individualLink);
			
			URLConnection openConnection = url.openConnection();
			
			HttpURLConnection connection = (HttpURLConnection) openConnection;
			
			int responseCode = connection.getResponseCode();
			
			if (responseCode>=200 && responseCode<=299) {
				System.out.println("Valid Link \t");
			}else {
				System.out.println("Broken Link \t"+responseCode);
				System.out.println(individualLink);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}

}

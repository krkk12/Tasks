package org.pnr;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PNR_Check {

	public static void main(String[] args) {

		BaseClass b = new BaseClass();

		b.getDriver("Chrome");
		b.maximize();
		b.getUrl("https://www.confirmtkt.com/pnr-status");
		b.waits(10);

		b.findElement("id", "pnr-text").sendKeys("4613134497");
		b.findElement("xpath", "//button[@type='submit']").click();

		List<WebElement> currentStatus = b.driver.findElements(
				By.xpath("//table[@class='table']//tbody//td[2]//span[@data-bind='text: CurrentStatus']"));

		for (WebElement c : currentStatus) {

			String cstatus = c.getText();

			System.out.println(cstatus);

		}

		System.out.println(b.findElement("xpath", "//div[@class='pas-chart']").getText());

		System.out.println();

		List<WebElement> CNFs = b.driver.findElements(By.xpath("//table[@class='table']//tbody//td[4]"));
		for (WebElement CNF : CNFs) {
			System.out.println(CNF.getText());
		}

		b.driver.close();

	}

}

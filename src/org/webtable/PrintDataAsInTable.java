package org.webtable;

import java.util.Iterator;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrintDataAsInTable extends BaseClass {

	
	
	public static void main(String[] args) {
		
		BaseClass b = new BaseClass();
		
		b.getDriver("Chrome");
		b.getUrl("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		b.maximize();
		b.waits(10);
		
		
		WebElement entireTable = driver.findElement(By.id("customers"));
		
		List<WebElement> allRows = entireTable.findElements(By.tagName("tr"));
		
		WebElement headingRow = allRows.get(0);
		
		List<WebElement> headingColumns = headingRow.findElements(By.tagName("th"));
		for (WebElement headingColumn : headingColumns) {
			System.out.print(headingColumn.getText()+"\t"+"\t");
		}
		System.out.println();
		
		for (int i = 1; i < allRows.size(); i++) {
			
			WebElement row = allRows.get(i);
			
			List<WebElement> columns = row.findElements(By.tagName("td"));
			
			for (int j = 0; j < columns.size(); j++) {
				
				WebElement column = columns.get(j);
				System.out.print(column.getText()+"\t"+"\t");

			}
			
			System.out.println();
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}

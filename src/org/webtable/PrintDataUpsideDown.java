package org.webtable;

import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrintDataUpsideDown extends BaseClass {

	public static void main(String[] args) {

		BaseClass b = new BaseClass();

		b.getDriver("Chrome");
		b.getUrl("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		b.maximize();
		b.waits(10);

		WebElement table = driver.findElement(By.id("customers"));

		List<WebElement> Rows = table.findElements(By.tagName("tr"));

		for (int i = Rows.size() - 1; i >= 0; i--) {

			WebElement Row = Rows.get(i);

			List<WebElement> columns = Row.findElements(By.tagName("td"));

			for (int j = columns.size() - 1; j >= 0; j--) {

				WebElement column = columns.get(j);

				System.out.print(column.getText() + "\t" + "\t");

			}

			System.out.println();
		}

		WebElement headerRow = Rows.get(0);

		List<WebElement> headerColumns = headerRow.findElements(By.tagName("th"));

		for (int i = headerColumns.size() - 1; i >= 0; i--) {

			String header = headerColumns.get(i).getText();

			System.out.print(header + "\t" + "\t");
		}

/***********************************************************************************************/
		//Alternate approach--adding webelement datas in List and iterating it
		WebElement table = driver.findElement(By.id("customers"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		List<String> tabledata = new ArrayList<String>();

		for (WebElement row : rows) {

			List<WebElement> columns = row.findElements(By.tagName("td"));
			List<WebElement> headers = row.findElements(By.tagName("th"));

			for (WebElement column : columns) {

				tabledata.add(column.getText());
			}
				
				for (WebElement header : headers) {
					
				 	tabledata.add(header.getText());

			}

		}

		for (int i = tabledata.size() - 1; i >= 0; i--) {

			System.out.print(tabledata.get(i) + "\t" + "\t");
			if (i % 3 == 0) {
				System.out.println();
			} else {

			}
		}
		
		
		
		
		
		

		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

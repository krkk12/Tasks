package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public WebElement element;
	public List<WebElement> elements;

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse 2023 workspace\\IPT\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "Edge":
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Invalid Browser Type");
			break;
		}
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void inputText(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void inputTextJS(WebElement element, String keysToSend) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
	}

	public void screenShot(String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("D:\\SCREENSHOTS\\" + name + ".jpeg");
		FileUtils.copyFile(source, target);
	}

	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);

	}

	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public String readExcell(int rowNum, int cellNum) throws IOException {

		// To locate the Excell
		File file = new File("C:\\Users\\Raja\\Desktop\\sauceDemo.xlsx");

		// To get File as a Input
		FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

		Workbook book = new XSSFWorkbook(stream);// throws IOException

		// to get sheet from workbook
		Sheet sheet = book.getSheet("Sheet1");

		// To get Row from Sheet
		Row row = sheet.getRow(rowNum);

		// to get Cell from Row
		Cell cell = row.getCell(cellNum);

		// To find Cell is STRING || NUMERIC
		CellType cellType = cell.getCellType();
		String value = null;

		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;

		case NUMERIC:

			// To Find Cell is Date format or Not
			if (DateUtil.isCellDateFormatted(cell)) {
				// To get Date format cell
				Date dateCellValue = cell.getDateCellValue();
				// To Define Date Format
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {

				// To get Numeric Cell value from Numeric Cell
				double numericCellValue = cell.getNumericCellValue();
				// double to BigDecimal
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				// BigDecimal to String
				value = valueOf.toString();

			}

			break;

		default:
			System.err.println("InValid_Cell_Type");
			break;
		}

		return value;
	}

	public void doubleClick(WebElement element) {

		Actions actions = new Actions(driver);

		actions.doubleClick(element).perform();

	}

	public void clearField(WebElement element) {

		element.clear();

	}

	public String getAttributeValue(WebElement element, String value) {

		element.getAttribute(value);

		return value;
	}

	public void alertAccept() {

		driver.switchTo().alert().accept();

	}

	public void explicitWait(Duration secs) {

		WebDriverWait wait = new WebDriverWait(driver, secs);

	}

	public WebElement findElement(String locatorType, String locatorPath) {

		switch (locatorType) {
		case "xpath":
			element = driver.findElement(By.xpath(locatorPath));
			break;
		case "id":
			element = driver.findElement(By.id(locatorPath));

			break;
		case "classname":
			element = driver.findElement(By.className(locatorPath));

			break;
		case "tagname":
			element = driver.findElement(By.tagName(locatorPath));

			break;

		default:
			break;
		}
		return element;

	}

	public void findElementsByXpath(String locatorPath) {

		elements = driver.findElements(By.xpath(locatorPath));

	}

	public void click() {

		element.click();

	}

	public void waits(int timeInSecs) {

		driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);

	}

	public void enterValue(String value) {

		element.sendKeys(value);

	}

	public void isPresent() {

		element.isDisplayed();

	}
	
	public WebElement xp(String locatorPath) {

		 element = driver.findElement(By.xpath(locatorPath));
		return element;

	}
	
	

}

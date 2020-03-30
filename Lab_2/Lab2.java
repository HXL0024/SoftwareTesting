package cn.tjuscs.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lab2 {
	public static void main(String[] args) {

		//从excel表中读取用户名和密码
		Sheet sheet;
		Workbook book = null;
		String[] userName1 = new String[20];
		String[] passName1 = new String[20];
		Cell cell1,cell2;
		Row row;
		String filePath = "D:\\ThreeDo\\Selenium+Lab2020.xlsx";
		File file = new File(filePath);
		try {

			FileInputStream in = new FileInputStream(file); 		
			XSSFWorkbook wb = new XSSFWorkbook(in); 
			sheet=wb.getSheetAt(0);
			int i = 0;
			while(true){
				row = sheet.getRow(i);
				cell1 = row.getCell(0);
				cell2 = row.getCell(1);
				if("".equals(cell1.getStringCellValue().trim()) == true)
					break;
				userName1[i] = cell1.getStringCellValue().trim();
				passName1[i] = cell2.getStringCellValue().trim();
				i++;
			}
			
		}
		catch(Exception e) {
			 e.printStackTrace(); 
		}
		
		String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
			
//		String driverPath = System.getProperty("user.dir") + "/src/driverchrome/chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", driverPath);
//		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
		driver.get(baseUrl);
//		WebElement userName = driver.findElement(By.id("account_name"));		
//		userName.sendKeys("wangzan@tju.edu.cn");
		
		
		for(int i = 0;i<20;i++) {
			
			WebElement userName = driver.findElement(By.name("user_number"));
			userName.sendKeys(userName1[i]);
			WebElement passName = driver.findElement(By.name("password"));
			passName.sendKeys(passName1[i]);
			//
			WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
			submitName.click();
			
//			WebElement submitName = driver.findElement(By.xpath("//*[@id='loginForm']/tbody/tr[6]/td/input[1]"));
		
			WebElement textShow = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
			WebElement textShow1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[4]/code"));
			if(textShow.getText().equals(passName1[i])) {
				System.out.println(userName1[i]+" Success!");
			}
			else {
				System.out.println(userName1[i]+" Failed!");
				System.out.println(textShow1.getText());
				
			}
		
		}
		
		driver.close();
	}
	
	

}

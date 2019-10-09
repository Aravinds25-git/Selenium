package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleCalendar {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ADMIN\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("aravinds25");
		driver.findElement(By.name("password")).sendKeys("aravind@1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		
		Select select=new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText("August");
		
		
		Select select1=new Select(driver.findElement(By.name("slctYear")));
		select1.selectByVisibleText("2019");
		
		String date="16-August-2019";
		
		String datearray[]=date.split("-");
		
		String day=datearray[0];
		String month=datearray[1];
		String year=datearray[2];
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]
		
		String before_xpath="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath="]/td[";
		
		//row-6
		//col-7
		boolean flag=false;
		String daytext=null;
		for (int row=2;row<=6;row++)
		{
			
			for (int col=1;col<=9;col++)
			{
				try {
				daytext=driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).getText();
				}catch(Exception e) {
					System.out.println("no clumns found");
					flag=false;
					break;
				}
				System.out.println(daytext);
				if (daytext.equals(day)) {
					driver.findElement(By.xpath(before_xpath+row+after_xpath+col+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}
		

	}

}

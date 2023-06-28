package doctors;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
public class SerchDoctors {
	public  static URL url;
	public static WebDriver driver;
	@Test
	public void validateApp() {
		DesiredCapabilities dc =  new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Udid");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
		dc.setCapability("appPackage","com.apollo.patientapp");
		dc.setCapability("appActivity","com.apollopatient.MainActivity");
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		WebElement tef =driver.findElement(By.className("android.widget.EditText"));
		tef.click();
        tef.sendKeys("9535174989");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.findElement(By.className("android.view.ViewGroup")).click();
        WebElement ef =driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"button-CONTINUE\"]"));
		ef.click();
		WebElement f =driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
		f.click();
		WebElement gnma = driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"button-image\"])[18]"));
		Actions act=new Actions(driver);	
		act.moveToElement(gnma).click().perform();
		WebElement af =driver.findElement(By.className("android.widget.EditText"));
		af.click();
		af.sendKeys("Dr.Subramanyam Kolanukuduru");
		driver.findElements(By.className("android.widget.ScrollView")).get(1).click();
		WebElement a4f =driver.findElement(By.xpath("//div[@class='_highlighter-box_c3e46 _hovered-element-box_c3e46 _inspected-element-box_c3e46']//div"));
		Actions act1=new Actions(driver);
		act1.moveToElement(a4f).click().perform();
		//AndroidElement list =(AndroidElement)driver.findElement(By.className("android.widget.TextView"));
		//MobileElement listitem = (MobileElement) driver.findElement(
			//	MobileBy.AndroidUIAutomator(
				//		"new UiScrollable(new UiSelector()).scrollIntoView("
				//+ "new UiSelector().text(\"Dr.Subramanyam Kolanukuduru\")"));
		//System.out.println(listitem.getLocation());
		//listitem.click();
		driver.quit();
	}
}

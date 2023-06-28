package doctors;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
public class AppLogin {
	public  static URL url;
	public static WebDriver driver;
	@Test
	public void launchApp() {
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
		driver.quit();
	}
}



	
	
	


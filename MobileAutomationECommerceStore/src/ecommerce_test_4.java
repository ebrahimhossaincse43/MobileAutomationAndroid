import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;

public class ecommerce_test_4 extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = Capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();

		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(4000);

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();

		double sum = 0;

		for (int i = 0; i < count; i++)

		{

			String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			amount1 = amount1.substring(1);
			double amount = Double.parseDouble(amount1);

			sum = sum + amount;// 280.97+116.97

		}

		System.out.println(sum + "sum of products");

		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();

		total = total.substring(1);

		double totalValue = Double.parseDouble(total);

		System.out.println(totalValue + "Total value of products");

		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));

		TouchAction t = new TouchAction(driver);

		t.tap(tapOptions().withElement(element(checkbox))).perform();

		WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));

		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		
		
		
		
		
		
		
		
		
		
//		String amount1 = driver.findElements(By.className("android.widget.LinearLayout")).get(0).getText();
//		amount1 = amount1.substring(1);
//		double amount1Value = Double.parseDouble(amount1);
//		
//		String amount2 = driver.findElements(By.className("android.widget.LinearLayout")).get(1).getText();
//		amount2 = amount2.substring(1);
//		double amount2Value = Double.parseDouble(amount1);
//		
//		double sumOfProducts = amount1Value+amount2Value;
//		System.out.println("Total sumOfProducts= "+sumOfProducts);

//		String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//		total = total.substring(1);
//		double totalValue = Double.parseDouble(total);
//		System.out.println("Total value= "+totalValue);
//		
//		if (sumOfProducts == totalValue) {
//			System.out.println("Equals");
//		} else {
//			System.out.println("Not Equal");
//		}

	}
}

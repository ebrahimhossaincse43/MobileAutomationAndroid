import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridBase {

	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {

		File f = new File("src");
		File fs = new File(f, "ApiDemos-debug2.apk");

		DesiredCapabilities cap = new DesiredCapabilities();

		if (device.equals("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Md.EbrahimHossain");
		} else if (device.equals("real")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}

		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
	}
}

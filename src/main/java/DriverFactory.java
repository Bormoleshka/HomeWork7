import io.appium.java_client.AppiumDriver;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;

public class DriverFactory {
    AppiumDriver<?> driver;

    public AppiumDriver<?> setUp(Platform platform) throws MalformedURLException {
        switch (platform) {
            case ANDROID:
                return createAndroidDriver();
            case IOS:
                return createIosDriver();
            default:
                throw new IllegalArgumentException("No such homework.Platform");
        }
    }

    private IOSDriver<?> createIosDriver(){
        return (IOSDriver<?>) driver;
    }

    private AndroidDriver<?> createAndroidDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ANDROID" );
        desiredCapabilities.setCapability(APP, "C:\\Users\\bormo\\Downloads");
        desiredCapabilities.setCapability(NO_RESET, true);
        URL remouteUrl = new URL("http://localhost:4723");
        driver = new AndroidDriver<>(remouteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return (AndroidDriver<?>) driver;

    }
}

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;


import java.net.MalformedURLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private final DriverFactory driverFactory = new DriverFactory();
    AppiumDriver<?> driver;

    @BeforeAll
    public void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
    }



    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}


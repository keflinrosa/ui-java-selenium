package Support;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;
    private static final long DEFAULT_WAIT_TIMEOUT = 20;
    private static final long IMPLICITY_WAIT_TIMEOUT = 10;

    public void startWebDriver(String parBrowser) {

        String title;

        try {
            title = driver.getTitle();
        } catch (Exception e) {
            title = "ERROR";
        }

        if (title.equals("ERROR")) {
            switch (parBrowser) {
                case "chrome":
                    ChromeDriverManager.getInstance().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(Arrays.asList(
                            "disable-infobars",
                            "ignore-certificate-errors",
                            "start-maximized"
                    ));
                    driver = new ChromeDriver(chromeOptions);
            }
        }

        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    private String getAttributeType(String... parType) {
        String type;
        if(parType.length == 0) {
            type = "id";
        } else {
            type = parType[0];
        }
        return type;
    }

    private By getLocatorBy(String parValue, String... parType) {
        final String selector = getAttributeType(parType);
            switch (selector) {
                case "id":
                    return By.id(parValue);
                case "name":
                    return By.name(parValue);
                case "css":
                    return By.cssSelector(parValue);
                case "xpath":
                    return By.xpath(parValue);
                case "link":
                    return By.linkText(parValue);
                default:
                    return By.id(parValue);
            }
    }

    private WebElement findElem(String parValue, String... parType) {
        final By locator = getLocatorBy(parValue, parType);
            WebElement element;
            try {
                element = driver.findElement(locator);
            } catch (NoSuchElementException e) {
                element = null;
            }
            return element;
    }

    public void openURL(String parUrl) {
        driver.get(parUrl);
    }

    public void quit() {
        driver.quit();
    }
}

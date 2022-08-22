package Support;

public class BasePage {

    protected static DriverManager driver = new DriverManager();

    public BasePage() {
        driver.startWebDriver("chrome");
    }
}

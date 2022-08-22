package Pages;

import Support.BasePage;
import Support.DriverManager;

public class NewAccount extends BasePage {

    public DriverManager driver;
    private static final String imdbURL = "https://www.imdb.com/";

    public NewAccount(DriverManager stepDriver) {
        driver = stepDriver;
    }

    public void openPage() {
        driver.openURL(imdbURL);
    }
}

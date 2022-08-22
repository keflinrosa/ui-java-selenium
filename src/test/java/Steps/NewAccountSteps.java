package Steps;

import Pages.NewAccount;
import Support.BasePage;
import io.cucumber.java.en.Given;

public class NewAccountSteps extends BasePage {

    public static NewAccount newAccount = new NewAccount(driver);

    @Given("I access the IMDb website")
    public void iAccessTheIMDbWebsite() {
        newAccount.openPage();
    }
}

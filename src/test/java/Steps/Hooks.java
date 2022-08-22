package Steps;

import Support.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("---- Starting scenario " + scenario.getName() + " execution ----");
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if(scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        else {
            System.out.println("---- Scenario " + scenario.getName() + " executed successfully ----");
        }
        System.out.println("Closing the browser");
        driver.quit();
    }
}

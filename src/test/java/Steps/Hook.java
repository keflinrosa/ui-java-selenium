package Steps;

import Support.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends Utils {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("---- Starting scenario " + scenario.getName() + "execution ----");
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if(scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser");
        //driver.quit();
    }
}

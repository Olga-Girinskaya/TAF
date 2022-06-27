package steps.defs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.en.Given;

public class MainStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public MainStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("chrome is started")
    public void chromeIsStarted() {
        baseCucumberTest.driver.get("http://onliner.by");
    }
}

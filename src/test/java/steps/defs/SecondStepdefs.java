package steps.defs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.When;

public class SecondStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("loginpage is opened")
    public void loginpageIsOpened() {
        baseCucumberTest.driver.get(ReadProperties.getUrl());
    }
}

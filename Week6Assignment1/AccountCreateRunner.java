package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.ProjectSpecificMethod;

@CucumberOptions(features="src/test/java/feature/CreateAccount.feature", glue="steps")
public class AccountCreateRunner extends ProjectSpecificMethod{

}

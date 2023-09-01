package utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //path of feature package folder
        features = {"src/test/resources/specs"},
        //path of step definition package folder
        glue = {"stepimplementation"}
)
public class TestRunner {
}

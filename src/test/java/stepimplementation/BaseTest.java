package stepimplementation;

import com.pg.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.io.IOException;

public class BaseTest {

    @Before
    public void setUp() throws IOException {
        Driver.initDriver();
    }

    @After
    public void tearDown(){
        Driver.quitDriver();
    }
}

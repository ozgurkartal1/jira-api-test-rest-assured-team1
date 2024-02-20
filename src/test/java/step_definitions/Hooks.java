package step_definitions;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;



public class Hooks {

    Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setUpEnvironment(Scenario scenario){
        logger.info("Scenerio " + scenario.getName() + "STARTED!");
    }

    @After
    public void tearDownTestEnvironment(Scenario scenario){
        if(scenario.isFailed()){
            logger.error("Scenario " + scenario.getName() + " is failed!");
        }else{
            logger.info("Scenario " + scenario.getName() + " is passed!");
        }
    }
}

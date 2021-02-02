package pt.sample.service;

import org.flowable.dmn.engine.DmnEngine;
import org.flowable.dmn.engine.DmnEngines;

public class DmnEngineSetup {

    private DmnEngine engine;

    public DmnEngine setup() {
        engine = DmnEngines.getDefaultDmnEngine();
        deploy();
        return engine;
    }

    public void deploy() {
        engine.getDmnRepositoryService()
                .createDeployment()
                .name("test")
                .addClasspathResource("dmn/test.dmn")
                .enableDuplicateFiltering()
                .deploy();

        engine.getDmnDecisionService()
                .createExecuteDecisionBuilder()
                .decisionKey("test")
                .variable("varInput", 10)
                .executeDecision();
    }

}

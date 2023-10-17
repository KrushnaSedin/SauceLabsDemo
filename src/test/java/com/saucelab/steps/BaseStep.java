package com.saucelab.steps;

import com.saucelab.test.TestContext;

public class BaseStep {
    public TestContext testContext;

    public BaseStep(TestContext testContext) {
        this.testContext = testContext;
    }
}

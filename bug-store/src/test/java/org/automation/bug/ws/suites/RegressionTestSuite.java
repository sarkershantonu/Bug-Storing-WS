package org.automation.bug.ws.suites;

import org.automation.bug.ws.tests.services.BugServiceTests;
import org.automation.bug.ws.tests.apis.BugControllerTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


/**
 * Created by SSarker on 7/1/2018.
 */
@Suite
@SuiteDisplayName("Regression Test")
@SelectClasses({BugControllerTests.class, BugServiceTests.class})
public class RegressionTestSuite {
}

package org.automation.bug.ws.suites;

import org.automation.bug.ws.tests.services.BugServiceTests;
import org.automation.bug.ws.tests.apis.BugControllerTests;
import org.junit.jupiter.api.Disabled;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * Created by SSarker on 7/1/2018.
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({BugControllerTests.class, BugServiceTests.class})
//@Disabled
public class RegressionTestSuite {
}

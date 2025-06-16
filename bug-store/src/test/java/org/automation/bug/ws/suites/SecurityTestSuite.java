package org.automation.bug.ws.suites;

import org.automation.bug.ws.tests.apis.BugControllerTests;
import org.automation.bug.ws.tests.services.BugServiceTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Regression Test")
@SelectClasses({BugControllerTests.class, BugServiceTests.class})
public class SecurityTestSuite {
}

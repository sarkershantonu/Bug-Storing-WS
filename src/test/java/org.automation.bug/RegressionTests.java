package org.automation.bug;

import org.automation.bug.service.BugServiceTests;
import org.automation.bug.web.api.BugControllerTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by SSarker on 7/1/2018.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BugControllerTests.class, BugServiceTests.class})
public class RegressionTests {
}

package org.automation.bug;

import org.automation.bug.service.BugServiceTests;
import org.automation.bug.web.api.BugControllerTests;
import org.junit.jupiter.api.Disabled;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * Created by SSarker on 7/1/2018.
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({BugControllerTests.class, BugServiceTests.class})
@Disabled
public class RegressionTests {
}

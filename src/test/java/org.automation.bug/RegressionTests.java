package org.automation.bug;

import org.automation.bug.service.BugServiceTests;
import org.automation.bug.web.api.BugControllerTests;

/**
 * Created by SSarker on 7/1/2018.
 */
@RunWith(JUnitPlatform.class)
@Suite.SuiteClasses({BugControllerTests.class, BugServiceTests.class})
@SelectPackages("org.automation.junit5.tests")
public class RegressionTests {
}

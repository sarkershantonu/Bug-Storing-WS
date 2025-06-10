package org.automation.bug.ws.core;

import org.automation.bug.ws.ws.model.Bug;
import org.mockito.ArgumentCaptor;

/**
 * Created by SSarker on 7/6/2018.
 */
public abstract class ServiceTestBase extends BugWsTestBase {

    protected ArgumentCaptor<Bug> argumentCaptorForBug = ArgumentCaptor.forClass(Bug.class);
}

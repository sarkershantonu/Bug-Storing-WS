package org.automation.bug.core;

import org.automation.bug.ws.model.Bug;
import org.mockito.ArgumentCaptor;

/**
 * Created by SSarker on 7/6/2018.
 */
public class ServiceTestBase extends SpringTestBase {

    protected ArgumentCaptor<Bug> argumentCaptorForBug = ArgumentCaptor.forClass(Bug.class);
}

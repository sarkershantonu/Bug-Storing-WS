package org.automation.bug.ws.tests.apis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

public class BugWsErrorTests extends BugControllerTests{
    private int expectedNotImplemented = HttpStatus.NOT_IMPLEMENTED.value();
    @Test public void testMethodTraceDisabled(){}
    @Test public void testMethodHeadDisabled(){}
    @Test public void testMethodOptionsDisabled(){}
    @Test public void testMethodPatchDisabled(){}
    @Test public void testMethodConnectDisabled(){}

    public void testMethodDisabled(final RequestMethod methodName, final String url){
        Assertions.assertEquals(expectedNotImplemented,0);
    }
}

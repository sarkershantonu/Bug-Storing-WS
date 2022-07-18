package org.automation.bug.ws.ws.exception;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by SSarker on 7/1/2018.
 */
public interface ExceptionsAttributes {
    Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpRequest, HttpStatus httpstatus);
}

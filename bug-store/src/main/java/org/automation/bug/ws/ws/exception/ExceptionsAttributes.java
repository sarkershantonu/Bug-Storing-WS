package org.automation.bug.ws.ws.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * Created by SSarker on 7/1/2018.
 */
public interface ExceptionsAttributes {
    Map<String, Object> getExceptionAttributes(Exception exception, HttpServletRequest httpRequest, HttpStatus httpstatus);
}

package org.automation.bug.ws.ws.exception;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by SSarker on 7/1/2018.
 */
public class DefaultExceptionAttributes implements ExceptionsAttributes {
    public static final String TIMESTAMP="timestamp";
    public static final String STATUS="status";
    public static final String ERROR="error";
    public static final String EXCEPTION="exception";
    public static final String MESSAGE="message";
    public static final String PATH="path";

    @Override
    public Map<String, Object> getExceptionAttributes(Exception exception,
                                                      HttpServletRequest httpRequest,
                                                      HttpStatus httpstatus) {
        Map<String, Object> attributes = new LinkedHashMap();
        attributes.put(TIMESTAMP, new Date());
        addHttpStatus(attributes, httpstatus);
        addExceptionDetails(attributes, exception);
        addPath(attributes, httpRequest);

        return attributes;
    }

    private void addHttpStatus( Map<String, Object> exceptionAttributes, HttpStatus httpstatus){
        exceptionAttributes.put(STATUS, httpstatus.value());
        exceptionAttributes.put(ERROR,httpstatus.getReasonPhrase());

    }
    private void addExceptionDetails(Map<String, Object> exceptionAttributes, Exception ex){
        exceptionAttributes.put(EXCEPTION, ex);
        exceptionAttributes.put(MESSAGE,ex.getMessage());
    }
    private void addPath(Map<String, Object> exceptionAttributes, HttpServletRequest httpRequest){
        exceptionAttributes.put(PATH, httpRequest.getServletPath());
    }
}

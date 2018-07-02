package org.automation.bug.ws.web.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by shantonu on 12/18/16.
 */

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manageException(Exception e, HttpServletRequest request){
        logger.error("Handling exception.... \nException",e);
        ExceptionsAttributes attributes = new DefaultExceptionAttributes();
        Map<String, Object> response = attributes.getExceptionAttributes(e, request,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> managetNullResults(Exception e, HttpServletRequest request){
        logger.error("Handling Null response.... \nException",e);
        Map<String,Object> response = new DefaultExceptionAttributes().getExceptionAttributes(e, request,HttpStatus.NOT_FOUND);
        return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }
}

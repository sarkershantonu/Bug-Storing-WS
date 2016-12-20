package org.automation.bug.ws.web.api;

import org.automation.bug.ws.model.Bug;
import org.automation.bug.ws.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by shantonu on 12/18/16.
 */
@Controller
public class BugController extends BaseController {
    @Autowired
    private BugService bugService;

    @RequestMapping(value = "/table/bugs",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Bug>> getAllBugs(){
        return new ResponseEntity<Collection<Bug>>(bugService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/table/bugs",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bug> create(@RequestBody Bug b){

        return new ResponseEntity<Bug>(bugService.create(b), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/table/bugs/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bug> findone(@PathVariable("id") Long id){
        if(id==null){
            return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
        }
        else{
            Bug found = bugService.findOne(id);
             if(found!=null){
                 return new ResponseEntity<Bug>(found, HttpStatus.OK);
             }else
             {
                 return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
             }
        }
    }
    @RequestMapping(value = "/table/bugs/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bug> update(@RequestBody Bug b, @PathVariable("id") Long id){
        if(id==null){
            return new ResponseEntity<Bug>(HttpStatus.NOT_FOUND);
        }
        if (id!=b.getId()){
            return new ResponseEntity<Bug>(HttpStatus.BAD_REQUEST);
        }
        Bug found = bugService.findOne(b.getId());
        if(found!=null){

            return new ResponseEntity<Bug>(bugService.update(b),HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<Bug>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

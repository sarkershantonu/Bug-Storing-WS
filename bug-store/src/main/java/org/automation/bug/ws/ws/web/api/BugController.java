package org.automation.bug.ws.ws.web.api;

import org.automation.bug.ws.ws.model.Bug;
import org.automation.bug.ws.ws.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by shantonu on 12/18/16.
 */
@Controller
public class BugController extends BaseController {
    @Autowired
    private BugService bugService;

    @GetMapping(value = "/table/bugs",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Bug>> findall(){
        return new ResponseEntity<Collection<Bug>>(bugService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/table/bugs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bug> create(@RequestBody Bug b){

        if (null==b.getId()){
            System.out.printf("NULL ID");
        }
        return new ResponseEntity<Bug>(bugService.create(b), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/table/bugs/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bug> find(@PathVariable("id") Long id){
        if(id==null){
            return new ResponseEntity<Bug>(HttpStatus.BAD_REQUEST);
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
        if(id==null ){
            return new ResponseEntity<Bug>(HttpStatus.BAD_REQUEST);
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

    @RequestMapping(value = "/table/bugs/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Bug> del(@PathVariable("id") Long id){

        if(id==null ){
            return new ResponseEntity<Bug>(HttpStatus.BAD_REQUEST);
        }
        Bug found  = bugService.findOne(id);
        if(found==null){
            return new ResponseEntity<Bug>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bugService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

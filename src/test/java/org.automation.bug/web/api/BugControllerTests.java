package org.automation.bug.web.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.automation.bug.core.ControllerTestBase;
import org.automation.bug.ws.model.Bug;
import org.automation.bug.ws.service.BugService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

/**
 * Created by SSarker on 7/1/2018.
 */
@Transactional
public class BugControllerTests extends ControllerTestBase {

    @Autowired
    private BugService service;

    @BeforeEach
    public void initForTest(){
        super.init();
        service.evictCache();
    }

    @Test
    public void testFindAll() throws Exception {
        final String url = "/table/bugs";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url)
        .accept(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();
        Assertions.assertEquals("Code MissMatchd", Integer.valueOf(HttpStatus.OK.toString()).intValue(),result.getResponse().getStatus());
        Assertions.assertTrue("NO Content", content.trim().length()>0);//telling some data is there
        //todo to have many test data there validae each one
    }


    @Test
    public void testFind() throws Exception {
        String url = "/table/bugs/{id}";
        Long id = new Long(Long.MAX_VALUE);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url,id).
                accept(MediaType.APPLICATION_JSON)).andReturn();
        Assertions.assertEquals("Error Missmatched",Integer.valueOf(HttpStatus.NOT_FOUND.toString()).intValue(),result.getResponse().getStatus());
        String content = result.getResponse().getContentAsString();
        Assertions.assertTrue( content.trim().length()==0);//telling some data is there
    }

    @Test
    public void testCreate() throws Exception {
        String url = "/table/bugs";
        Bug aBug = getADummyBug();
        String inputJson = super.toJson(aBug);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Assertions.assertEquals("Code MissMatchd", Integer.valueOf(HttpStatus.CREATED.toString()).intValue(),result.getResponse().getStatus());
        Assertions.assertTrue("NO Content", content.trim().length()>0);
        Bug bugFromResponse = super.parse(content,Bug.class);
        Assertions.AssertionsNotNull(bugFromResponse);
        Bug bugFromDB = service.findOne(bugFromResponse.getId());
        Assertions.assertTrue("NOT Present as DB",bugFromDB.equalsByData(bugFromResponse));
    }

    @Test
    public void testUpdate() throws Exception {
        String url = "/table/bugs/{id}";
        Bug aBug = getADummyBug();
        service.create(aBug);//newly created bug, so id will be 1

        Bug aBugToUpdate = getADummyBug();
        aBugToUpdate.setId(new Long(1));
        aBugToUpdate.setTitle("Updated bug");
        String input = super.toJson(aBugToUpdate);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.put(url,aBugToUpdate.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(input)).andReturn();
        Assertions.assertEquals("invalid status code",Integer.valueOf(HttpStatus.ACCEPTED.toString()).intValue(),result.getResponse().getStatus());
        Bug resultBug = super.parse(result.getResponse().getContentAsString(),Bug.class);
        Assertions.assertEquals("Not matched data",aBugToUpdate,resultBug);
        Assertions.assertTrue("Not matched data",aBugToUpdate.equalsByData(resultBug));
    }

    @Test
    public void testDelete() throws Exception {
        String url = "/table/bugs/{id}";
        Bug aBug = getADummyBug();
        Bug createdBug = service.create(aBug);
        Bug bugToDelete = getADummyBug();
        bugToDelete.setId(createdBug.getId());
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .delete(url,bugToDelete.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals("Statis invalid",Integer.valueOf(HttpStatus.NO_CONTENT.toString()).intValue(),result.getResponse().getStatus());
        Assertions.assertTrue("Content Present!!!",result.getResponse().getContentAsString().trim().length()==0);

        Bug aBugFromDB = service.findOne(bugToDelete.getId());
        Assertions.AssertionsNull("NOT NULL",aBugFromDB);
    }
    @Test//(expected = JpaObjectRetrievalFailureException.class)//spring layer exception , not DAL layer
    public void testDeleteException() throws Exception {
        String url = "/table/bugs/{id}";
        //MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(url,new Long(null)).contentType(MediaType.APPLICATION_JSON)).andReturn();
        //int status_code = result.getResponse().getStatus();
        //Assertions.assertEquals("INVALID CODE",Integer.valueOf(HttpStatus.BAD_REQUEST.toString()).intValue(),status_code );


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(url,new Long(-1)).contentType(MediaType.APPLICATION_JSON)).andReturn();
       int  status_code = result.getResponse().getStatus();
        Assertions.assertEquals(Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.toString()).intValue(),status_code );
        Assertions.assertTrue(result.getResponse().getContentAsString().trim().length()==0);

    }
}

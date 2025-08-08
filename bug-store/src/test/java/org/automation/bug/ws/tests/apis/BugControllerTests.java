package org.automation.bug.ws.tests.apis;


import org.automation.bug.ws.core.ControllerTestBase;
import org.automation.bug.ws.ws.model.Bug;
import org.automation.bug.ws.ws.service.BugService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.automation.bug.ws.core.testdata.BugData.getADummyBug;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by SSarker on 7/1/2018.
 */
@Disabled
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
        Assertions.assertEquals( Integer.valueOf(HttpStatus.OK.value()).intValue(),result.getResponse().getStatus());
        Assertions.assertTrue(content.trim().length()>0);//telling some data is there
        //todo to have many test data there validae each one
    }


    @Test
    public void testFind() throws Exception {
        String url = "/table/bugs/{id}";
        Long id = Long.MAX_VALUE;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url,id).
                accept(MediaType.APPLICATION_JSON)).andReturn();
        Assertions.assertEquals(Integer.valueOf(HttpStatus.NOT_FOUND.value()).intValue(),result.getResponse().getStatus());
        String content = result.getResponse().getContentAsString();
        Assertions.assertTrue( content.trim().length()==0);//telling some data is there
    }

    @Test
    public void testCreate() throws Exception {
        String url = "/table/bugs";
        Bug aBug = getADummyBug();
        String inputJson = super.toJson(aBug);

        MvcResult result =
                mockMvc.perform(post(url)
                        .with(httpBasic("user","password")))
                        //.contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                .content(inputJson);               ;
        String content = result.getResponse().getContentAsString();
        Assertions.assertEquals( Integer.valueOf(HttpStatus.CREATED.value()).intValue(),result.getResponse().getStatus());
        Assertions.assertTrue( content.trim().length()>0);
        Bug bugFromResponse = super.parse(content,Bug.class);
        Assertions.assertNotNull(bugFromResponse);
        Bug bugFromDB = service.findOne(bugFromResponse.getId());
        Assertions.assertTrue(bugFromDB.equalsByData(bugFromResponse));
    }

    @Test
    public void testUpdate() throws Exception {
        String url = "/table/bugs/{id}";
        Bug aBug = getADummyBug();
        service.create(aBug);//newly created bug, so id will be 1

        Bug aBugToUpdate = getADummyBug();
        aBugToUpdate.setId(1L);
        aBugToUpdate.setTitle("Updated bug");
        String input = super.toJson(aBugToUpdate);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.put(url,aBugToUpdate.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(input)).andReturn();
        Assertions.assertEquals(Integer.valueOf(HttpStatus.ACCEPTED.value()).intValue(),result.getResponse().getStatus());
        Bug resultBug = super.parse(result.getResponse().getContentAsString(),Bug.class);
        Assertions.assertEquals(aBugToUpdate,resultBug);
        Assertions.assertTrue(aBugToUpdate.equalsByData(resultBug));
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

        Assertions.assertEquals(Integer.valueOf(HttpStatus.NO_CONTENT.value()).intValue(),result.getResponse().getStatus());
        Assertions.assertTrue(result.getResponse().getContentAsString().trim().length()==0);

        Bug aBugFromDB = service.findOne(bugToDelete.getId());
        Assertions.assertNull(aBugFromDB);
    }
    @Test//(expected = JpaObjectRetrievalFailureException.class)//spring layer exception , not DAL layer
    public void testDeleteException() throws Exception {
        String url = "/table/bugs/{id}";
        //MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(url,new Long(null)).contentType(MediaType.APPLICATION_JSON)).andReturn();
        //int status_code = result.getResponse().getStatus();
        //Assertions.assertEquals("INVALID CODE",Integer.valueOf(HttpStatus.BAD_REQUEST.value()).intValue(),status_code );


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete(url,-1L).contentType(MediaType.APPLICATION_JSON)).andReturn();
       int  status_code = result.getResponse().getStatus();
        Assertions.assertEquals(Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()).intValue(),status_code );
        Assertions.assertTrue(result.getResponse().getContentAsString().trim().length()==0);

    }
}

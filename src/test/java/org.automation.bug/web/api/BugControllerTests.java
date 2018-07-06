package org.automation.bug.web.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.automation.bug.core.ControllerTestBase;
import org.automation.bug.ws.model.Bug;
import org.automation.bug.ws.service.BugService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

/**
 * Created by SSarker on 7/1/2018.
 */
@Transactional
public class BugControllerTests extends ControllerTestBase {

    @Autowired
    private BugService service;

    @Before
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
        Assert.assertEquals("Code MissMatchd", Integer.valueOf(HttpStatus.OK.toString()).intValue(),result.getResponse().getStatus());
        Assert.assertTrue("NO Content", content.trim().length()>0);//telling some data is there
        //todo to have many test data there validae each one
    }


    @Test
    public void testFind() throws Exception {
        String url = "/table/bugs/{id}";
        Long id = new Long(Long.MAX_VALUE);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url,id).
                accept(MediaType.APPLICATION_JSON)).andReturn();
        Assert.assertEquals("Error Missmatched",Integer.valueOf(HttpStatus.NOT_FOUND.toString()).intValue(),result.getResponse().getStatus());
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("NO Content", content.trim().length()==0);//telling some data is there
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
        Assert.assertEquals("Code MissMatchd", Integer.valueOf(HttpStatus.CREATED.toString()).intValue(),result.getResponse().getStatus());
        Assert.assertTrue("NO Content", content.trim().length()>0);
        Bug bugFromResponse = super.parsefrom(content,Bug.class);
        Assert.assertNotNull(bugFromResponse);


        Bug bugFromDB = service.findOne(bugFromResponse.getId());
        Assert.assertTrue("NOT Present as DB",bugFromDB.equalsByData(bugFromResponse));

    }

    @Test
    public void testUpdate() throws JsonProcessingException {
        String url = "/table/bugs/{id}";
        Bug aBug = getADummyBug();
        service.create(aBug);//newly created bug, so id will be 1

        Bug aBugToUpdate = getADummyBug();
        aBugToUpdate.setId(new Long(1));
        aBugToUpdate.setTitle("Updated bug");
        String input = super.toJson(aBugToUpdate);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post()
    }

}

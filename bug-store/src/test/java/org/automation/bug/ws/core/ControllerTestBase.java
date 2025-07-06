package org.automation.bug.ws.core;

import jakarta.servlet.Filter;
import org.automation.bug.ws.ws.web.api.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by SSarker on 7/1/2018.
 */
@WebAppConfiguration
public abstract class ControllerTestBase extends BugWsTestBase {
    protected MockMvc mockMvc;


    @Autowired
    protected WebApplicationContext context;

    protected void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    protected void init(BaseController controller){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
   /* protected <T extends BaseController> void init(T controller){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }*/
   //utils for JSON parsing

}

package org.automation.bug.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.automation.bug.ws.web.api.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

/**
 * Created by SSarker on 7/1/2018.
 */
@WebAppConfiguration
public abstract class ControllerTestBase extends SpringTestBase {
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
   protected String toJson(Object object) throws JsonProcessingException {
       ObjectMapper mapper = new ObjectMapper();
       return mapper.writeValueAsString(object);
   }
    //utils for JSON parsing 
  protected <T> T parsefrom(String jsonData, Class<T> klass) throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       return mapper.readValue(jsonData,klass);
  }
}

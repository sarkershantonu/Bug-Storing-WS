package org.automation.bug.ws.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Filter;
import org.automation.bug.ws.ws.BugWsApp;
import org.automation.bug.ws.ws.model.Bug;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

/**
 * Created by SSarker on 7/1/2018.
 */
@SpringBootTest(classes = BugWsApp.class)
public abstract class BugWsTestBase {

    protected RequestPostProcessor anUser(){
        return user("shantonu").password("123456");
    }
    protected RequestPostProcessor testUser(){
        return user("shantonu").password("123456").roles("USER");
    }
    protected RequestPostProcessor testAdmin(){
        return user("shantonu").password("123456").roles("ADMIN");
    }
    protected String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
    protected String toJson(Bug object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
    //utils for JSON parsing
    protected <T> T parse(String jsonData, Class<T> klass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonData,klass);
    }
    protected <T> List<T> parseArray(String json_as_string, Class<T> klass) throws IOException {
        List<T> items;
        ObjectMapper mapper = new ObjectMapper();
        items = mapper.readValue(json_as_string, new TypeReference<List<T>>() {
        });
        return items;
    }
}

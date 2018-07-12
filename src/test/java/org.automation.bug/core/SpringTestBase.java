package org.automation.bug.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.automation.bug.ws.App;
import org.automation.bug.ws.model.Bug;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created by SSarker on 7/1/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
//@SpringBootContextLoader(classes = App.class)
public abstract class SpringTestBase {


    protected Bug getADummyBug(){
        Bug aBug = new Bug();
        aBug.setId(null);
        aBug.setTitle("Title");
        aBug.setSummary("summary");
        aBug.setDescription("Description");
        aBug.setAttachmentPath("AttachmentPath");
        aBug.setExceptions("exceptions");
        aBug.setComments("comments");
        aBug.setFoundDateTime("foundDateTime");
        aBug.setTags("TAG1,TAG2");
        aBug.setPriority("5");
        aBug.setServility("CRITICAL");
        return aBug;
    }
    protected String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
    //utils for JSON parsing
    protected <T> T parsefrom(String jsonData, Class<T> klass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonData,klass);
    }
    protected <T> List<T> parseArray(String json_ass_string, Class<T> klass) throws IOException {
        List<T> items;
        ObjectMapper mapper = new ObjectMapper();
        items = mapper.readValue(json_ass_string, new TypeReference<List<T>>() {
        });
        return items;
    }
}

package org.automation.bug.ws.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.automation.bug.ws.ws.BugWsApp;
import org.automation.bug.ws.ws.model.Bug;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.util.List;

/**
 * Created by SSarker on 7/1/2018.
 */
@SpringBootTest(classes = BugWsApp.class)
public abstract class BugWsTestBase {


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

package org.automation.bug.core;

import org.automation.bug.ws.App;
import org.automation.bug.ws.model.Bug;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}

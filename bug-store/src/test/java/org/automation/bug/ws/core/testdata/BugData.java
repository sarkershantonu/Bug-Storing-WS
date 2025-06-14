package org.automation.bug.ws.core.testdata;

import org.automation.bug.ws.ws.model.Bug;

public class BugData {
    public static Bug getADummyBug(){
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

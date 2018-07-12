package org.automation.bug.service;

import org.automation.bug.core.ServiceTestBase;
import org.automation.bug.ws.model.Bug;
import org.automation.bug.ws.service.BugService;
import org.automation.bug.ws.service.BugServiceBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by SSarker on 7/1/2018.
 */
@Transactional
public class BugServiceBeanTest extends ServiceTestBase {

    @Autowired
    private BugService service;

    @Before
    public void initForTest(){

        service.evictCache();
    }

    @Test// need old data
    public void TestFindAll(){
        Collection<Bug> allBugs = service.findAll();
        Assert.assertNotNull(allBugs);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindNull(){
        Bug aBug = service.findOne(Long.MAX_VALUE);
        Assert.assertNull("failure - expected null", aBug);

    }
    @Test
    public void testCreate(){
        Bug aBug = getADummyBug();
        service.create(aBug);
        Bug foundFromDB = service.findOne(aBug.getId());
        Assert.assertNotNull(foundFromDB);
        Assert.assertTrue("Not Same Data", aBug.equals(foundFromDB));
    }
}

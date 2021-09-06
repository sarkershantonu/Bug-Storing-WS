package org.automation.bug.service;

import org.automation.bug.core.ServiceTestBase;
import org.automation.bug.ws.model.Bug;
import org.automation.bug.ws.service.BugService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by SSarker on 7/1/2018.
 */
@Transactional
public class BugServiceTests extends ServiceTestBase {

    @Autowired
    private BugService service;

    @BeforeAll
    public void initForTest(){

        service.evictCache();
    }

    @Test// need old data
    public void TestFindAll(){
        Collection<Bug> allBugs = service.findAll();
        Assertions.assertNotNull(allBugs);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindNull(){
        Bug aBug = service.findOne(Long.MAX_VALUE);

        Assertions.assertNotNull(aBug);



    }
    @Test
    public void testCreate(){
        Bug aBug = getADummyBug();
        service.create(aBug);
        Bug foundFromDB = service.findOne(aBug.getId());
        Assertions.assertNotNull(foundFromDB);
        Assertions.assertTrue(aBug.equals(foundFromDB));
    }

    @Test
    public void testDeleteByID(){

    }

    @Test
    public void testDelete(){

    }
    @Test
    //todo
    public void testDeleteWithException(){

        Assertions.assertThrows(JpaObjectRetrievalFailureException.class ,()->{

        });
    }
}

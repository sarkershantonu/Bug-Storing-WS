package org.automation.bug.ws.ws.service;

import jakarta.persistence.NoResultException;
import org.automation.bug.ws.ws.model.Bug;
import org.automation.bug.ws.ws.repo.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by shantonu on 12/18/16.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BugServiceBean implements BugService{

    @Autowired
    private BugRepository bugs;


    @Override
    public Collection<Bug> findAll() {
        return bugs.findAll();
    }

    @Override
    @Cacheable(value = "bugs", key = "#id")
    public Bug findOne(Long id) {
        return bugs.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "bugs", key = "#g.id")
    public Bug create(Bug g) {

        return bugs.save(g);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "bugs", key = "#g.id")
    public Bug update(Bug g) {
        Bug got = findOne(g.getId());
        if(got.getId()==null){
            throw new NoResultException("ID is NULL/No Record found");
        }
        return bugs.save(g);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CacheEvict(value = "bugs", key = "#id")
    public void delete(Long id) {

        bugs.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CacheEvict(value = "bugs", key = "#g.id")
    public void delete(Bug aBug) {

        bugs.delete(aBug);
    }
    @Override
    @CacheEvict(value = "bugs", allEntries = true)
    public void evictCache() {
    }


}

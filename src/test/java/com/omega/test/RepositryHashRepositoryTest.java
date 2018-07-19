package com.omega.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestEntityManager
public class RepositryHashRepositoryTest {
    @Autowired
    private RegistryHashRepository registryHashRepository;


    @Test
    public void findAll() throws Exception {

        List<RegistryHash> results = registryHashRepository.findAll();
        assertEquals(2, results.size());
    }


    @Test
    public void findByMapkey() throws Exception {
        RegistryHash registryHash = registryHashRepository.findByMapkey("isShutdownMode");
        assertEquals("true",  registryHash.getValue());

    }

}

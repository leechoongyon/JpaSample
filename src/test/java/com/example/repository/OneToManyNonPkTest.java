package com.example.repository;


import com.example.domain.ADomain;
import com.example.domain.BDomain;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyNonPkTest {

    @Autowired
    private ADomainRepository aDomainRepository;

    @Autowired
    private BDomainRepository bDomainRepository;

    @Before
    public void setUp() throws Exception {
        String testKey = "test";
        BDomain bDomain = new BDomain();
        bDomain.setTestKey(testKey);
        bDomainRepository.save(bDomain);

        BDomain bDomain1 = new BDomain();
        bDomain.setTestKey(testKey);
        bDomainRepository.save(bDomain1);

        ADomain aDomain = new ADomain();
        aDomain.setTestKey(testKey);

        aDomainRepository.save(aDomain);
    }

    @Test
    @Transactional
    public void OneToMany_NON_PK_조회_테스트() throws Exception {
        List<ADomain> aDomains = aDomainRepository.findAll();
        List<BDomain> bDomains = aDomains.get(0).getB();
        bDomains.forEach(domain -> {
            System.out.println(domain);
        });
    }
}

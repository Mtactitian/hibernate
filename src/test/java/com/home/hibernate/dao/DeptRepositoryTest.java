package com.home.hibernate.dao;

import com.home.hibernate.DatasourceProxyBeanPostProcessor;
import com.home.hibernate.repository.employes.DeptRepository;
import com.home.hibernate.service.DeptService;
import net.ttddyy.dsproxy.asserts.ProxyTestDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static net.ttddyy.dsproxy.asserts.assertj.DataSourceAssertAssertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableTransactionManagement
@EnableCaching
@Import(DatasourceProxyBeanPostProcessor.class)
@Profile(value = "test")
public class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private ProxyTestDataSource proxyTestDataSource;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DeptService deptService;

    @Test
    public void contextLoads() {
        System.out.println(deptService.getByName("ACCOUNTING"));
        entityManager.clear();
        System.out.println(deptService.getByName("ACCOUNTING"));
        assertThat(proxyTestDataSource).hasSelectCount(1);

    }
}

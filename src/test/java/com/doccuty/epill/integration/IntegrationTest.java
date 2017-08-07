package com.doccuty.epill.integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.doccuty.epill.drug.Drug;
import com.doccuty.epill.user.User;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Create a test which starts a real application container listening on a given port.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    private static final Logger LOG = LoggerFactory.getLogger(IntegrationTest.class);

    @LocalServerPort
    int port;


    /**
     * Test that adding drugs as frequently taking works.
     */
    @Test
    public void testPostList() {


    }
    
    /**
     * Create a HTTP entity to be used in authenticated requests. The default user is kai.
     *
     * @param entity object
     * @param <T>    Object's type
     * @return an entity with authentication header.
     */
    private <T> HttpEntity<T> getEntity(T entity) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYWkiLCJqdGkiOiIyIn0.h3ezvhsje3tpvHbXxz7TUmy7KhT5yjtljXKvDeo8MM2RTAEIP6l2vdRHw2KKg0-HgK-8CsMY5im3kp6zIogUTQ");
        return new HttpEntity<>(entity, headers);
    }


    private String getPostURL() {
        return "http://localhost:" + port + "/drug";
    }

    private String fixResponseURL(String url) {
        return url.replaceAll(":8080/", ":" + port + "/");
    }
}

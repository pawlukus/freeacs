package com.github.freeacs.tr069;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application-h2.properties")
public class StatusPageIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testStatusPage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("xAPS TR-069 Server Monitoring Page");
    }
}

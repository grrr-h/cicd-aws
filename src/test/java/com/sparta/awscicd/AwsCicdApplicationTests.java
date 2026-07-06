package com.sparta.awscicd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AwsCicdApplicationTests {


    @Autowired
    private TestRestTemplate template;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("/healthz 테스트")
    void testHomeControllerHealthz() {

        ResponseEntity<String> response =
                template.getForEntity("/healthz", String.class);

        // 실패하는 경우
        // assertThat(response.getBody()).isEqualTo("on failed");

        // 성공하는 경우
        assertThat(response.getBody()).isEqualTo("healthz-aws");

    }
}
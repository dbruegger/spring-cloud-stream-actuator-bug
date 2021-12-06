package org.springframework.cloud.stream.actuator.bug;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
@Import(TestChannelBinderConfiguration.class)
public class ActuatorBindingsTest {

    @Autowired
    WebTestClient webClient;

    @Test
    void actuatorBindings() {
        webClient.get().uri("/actuator/bindings")
            .accept(APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk();
    }

}

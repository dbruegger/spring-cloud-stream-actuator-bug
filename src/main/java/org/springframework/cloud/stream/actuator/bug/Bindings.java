package org.springframework.cloud.stream.actuator.bug;

import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bindings {

    @Bean
    public Consumer<String> consume() {
        return message -> System.out.println("Received message " + message);
    }

}

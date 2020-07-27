package com.skt.twd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TwdApplication {
    private static final String PROPERTIES =
            "spring.config.location="
                    + "classpath:/config/application/";

    public static void main(String[] args) {
        new SpringApplicationBuilder(TwdApplication.class)
                .properties(PROPERTIES)
                .run(args);
    }
}
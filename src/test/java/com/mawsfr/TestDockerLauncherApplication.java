package com.mawsfr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDockerLauncherApplication {

    public static void main(String[] args) {
        SpringApplication.from(DockerLauncherApplication::main).with(TestDockerLauncherApplication.class).run(args);
    }

}

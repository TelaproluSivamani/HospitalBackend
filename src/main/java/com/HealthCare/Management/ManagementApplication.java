package com.HealthCare.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Make the application extend SpringBootServletInitializer so it can be deployed
 * as a WAR to an external servlet container (Tomcat).
 */
@SpringBootApplication
public class ManagementApplication extends SpringBootServletInitializer {

    // Used when the application is launched by the servlet container (WAR)
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagementApplication.class);
    }

    // Used when you run the application standalone via `java -jar`
    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }
}

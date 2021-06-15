package com.xf.project.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.xf.project.db", "com.xf.project.framework",
        "com.xf.project.admin"})
@MapperScan("com.xf.project.db.dao")
@EnableTransactionManagement
@EnableScheduling
@EnableSwagger2
public class ProjectAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectAdminApplication.class, args);
    }

}

package com.xf.project.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.xf.project.db", "com.xf.project.framework",
        "com.xf.project.admin"})
@MapperScan("com.xf.project.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class ProjectAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectAdminApplication.class, args);
    }

}

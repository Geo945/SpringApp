package com.spring.practice.courseproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//to generate .jar file -> maven -> clean and then install(Lifecycle)
//cd target from terminal
//jar -jar CourseProject-0.0.1-SNAPSHOT.jar
//to specify port: jar -jar CourseProject-0.0.1-SNAPSHOT.jar --server.port=8081 (example)=> localhost:8081/api/v1/student/get
@SpringBootTest
class CourseProjectApplicationTests {

    @Test
    void contextLoads() {
    }

}

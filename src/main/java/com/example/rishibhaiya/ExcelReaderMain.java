package com.example.rishibhaiya;

import com.example.rishibhaiya.pojo.User;
import com.example.rishibhaiya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ExcelReaderMain implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ExcelReaderMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

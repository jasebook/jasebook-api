package com.jasebook.app;

import db.Post;
import db.PostRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.stream.Stream;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ApplicationRunner init(PostRepository repository) {
        String[][] data = {
                {"sea", "Andrew"},
                {"creek", "Andrew"},
                {"loaner", "Andrew"}
        };

        return args -> {
            Stream.of(data).forEach(array -> {
                try {
                    Post post = new Post(
                            array[0],
                            array[1]
                    );
                    repository.save(post);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            repository.findAll().forEach(System.out::println);
        };

    }

}


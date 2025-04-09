package com.luecardoso.springboot_mongodb.config;

import com.luecardoso.springboot_mongodb.domain.User;
import com.luecardoso.springboot_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        userReposiroty.deleteAll();

        User user1 = new User(null, "lucas", "lucas@gmail.com");
        User user2 = new User(null, "felipe", "felipe@gmail.com");
        User user3 = new User(null, "daniela", "daniela@gmail.com");

        userReposiroty.saveAll(Arrays.asList(user1, user2, user3));
    }
}

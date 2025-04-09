package com.luecardoso.springboot_mongodb.config;

import com.luecardoso.springboot_mongodb.domain.Post;
import com.luecardoso.springboot_mongodb.domain.User;
import com.luecardoso.springboot_mongodb.dto.AuthorDTO;
import com.luecardoso.springboot_mongodb.repositories.PostRepository;
import com.luecardoso.springboot_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "lucas", "lucas@gmail.com");
        User user2 = new User(null, "felipe", "felipe@gmail.com");
        User user3 = new User(null, "daniela", "daniela@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user1));

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
    }
}

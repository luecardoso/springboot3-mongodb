package com.luecardoso.springboot_mongodb.services;

import com.luecardoso.springboot_mongodb.domain.Post;
import com.luecardoso.springboot_mongodb.domain.User;
import com.luecardoso.springboot_mongodb.repositories.PostRepository;
import com.luecardoso.springboot_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}

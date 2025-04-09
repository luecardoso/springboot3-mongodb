package com.luecardoso.springboot_mongodb.resources;


import com.luecardoso.springboot_mongodb.domain.Post;
import com.luecardoso.springboot_mongodb.domain.User;
import com.luecardoso.springboot_mongodb.dto.AuthorDTO;
import com.luecardoso.springboot_mongodb.dto.UserDTO;
import com.luecardoso.springboot_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

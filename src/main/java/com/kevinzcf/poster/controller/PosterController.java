package com.kevinzcf.poster.controller;

import com.kevinzcf.poster.dto.UserPostsDTO;
import com.kevinzcf.poster.service.UserPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevinzcf
 * @version 2019
 */
@RestController
public class PosterController {

    @Autowired
    UserPostsService userPostsService;

    @GetMapping(value = "/poster/{id}")
    public UserPostsDTO showPoster(@PathVariable("id") String id) {
        return userPostsService.getUserPosts(id);
    }
}

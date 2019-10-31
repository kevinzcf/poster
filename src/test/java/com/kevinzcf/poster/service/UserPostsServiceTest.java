package com.kevinzcf.poster.service;

import com.kevinzcf.poster.dto.UserPostsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author kevinzcf
 * @version 2019
 */
@SpringBootTest
class UserPostsServiceTest {
    @Autowired
    private UserPostsService userPostsService;

    @Test
    void getUserPosts() {
        UserPostsDTO userPosts = userPostsService.getUserPosts("1");
        assertNotNull(userPosts);
        assertNotNull(userPosts.getUser());
        assertEquals("1", userPosts.getUser().getId());
        assertEquals(10, userPosts.getPosts().size());
    }
}
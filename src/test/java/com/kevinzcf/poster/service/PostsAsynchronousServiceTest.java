package com.kevinzcf.poster.service;

import com.kevinzcf.poster.dto.PostListDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author kevinzcf
 * @version 2019
 */
@SpringBootTest
@Slf4j
class PostsAsynchronousServiceTest {

    @Autowired
    private PostsAsynchronousService postsAsynchronousService;

    @Test
    void fetchPosts() {
        PostListDTO postDTOS = null;
        try {
            final Future<PostListDTO> future = postsAsynchronousService.fetchPosts("1");
            log.info("i hate waiting!");
            postDTOS = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(postDTOS);
        assertEquals(10, postDTOS.size());
    }
}
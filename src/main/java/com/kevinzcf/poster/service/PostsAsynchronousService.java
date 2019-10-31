package com.kevinzcf.poster.service;

import com.kevinzcf.poster.constant.UrlConstant;
import com.kevinzcf.poster.dto.PostListDTO;
import com.kevinzcf.poster.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

/**
 * @author kevinzcf
 * @version 2019
 */
@Service
@EnableAsync
@Slf4j
public class PostsAsynchronousService {
    @Async
    public Future<PostListDTO> fetchPosts(String userId) {
        log.info("start fetching posts data");
        PostListDTO out = JsonUtil.fromJson(UrlConstant.POSTS_ENDPOINT + userId, PostListDTO.class);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("stop fetching posts data");
        return new AsyncResult<PostListDTO>(out);
    }
}

package com.kevinzcf.poster.service;

import com.kevinzcf.poster.constant.UrlConstant;
import com.kevinzcf.poster.dto.UserDTO;
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
public class UserAsynchronousService {
    @Async
    public Future<UserDTO> fetchUser(String userId) {
        log.info("start fetching user data");
        UserDTO out = JsonUtil.fromJson(UrlConstant.USER_ENDPOINT + userId, UserDTO.class);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("stop fetching user data");
        return new AsyncResult<UserDTO>(out);
    }
}

package com.kevinzcf.poster.service;

import com.kevinzcf.poster.dto.UserDTO;
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
class UserAsynchronousServiceTest {

    @Autowired
    private UserAsynchronousService userAsynchronousService;

    @Test
    void fetchUser() {
        UserDTO userDTO = null;
        try {
            final Future<UserDTO> future = userAsynchronousService.fetchUser("1");
            log.info("i hate waiting!");
            userDTO = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(userDTO);
        assertEquals("Bret", userDTO.getUsername());
    }
}
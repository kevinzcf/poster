package com.kevinzcf.poster.utils;

import com.kevinzcf.poster.constant.UrlConstant;
import com.kevinzcf.poster.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author kevinzcf
 * @version 2019
 */
class JsonUtilTest {

    @Test
    void fromJson() {
        String userID = "1";
        UserDTO userDTO = JsonUtil.fromJson(UrlConstant.USER_ENDPOINT + userID, UserDTO.class);
        assertNotNull(userDTO);
        assertEquals(userID, userDTO.getId());
    }
}
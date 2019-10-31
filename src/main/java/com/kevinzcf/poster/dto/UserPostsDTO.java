package com.kevinzcf.poster.dto;

import lombok.Data;

/**
 * @author kevinzcf
 * @version 2019
 */

@Data
public class UserPostsDTO {
    private UserDTO user;
    private PostListDTO posts;
}

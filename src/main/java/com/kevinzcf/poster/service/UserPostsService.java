package com.kevinzcf.poster.service;

import com.kevinzcf.poster.dto.PostListDTO;
import com.kevinzcf.poster.dto.UserDTO;
import com.kevinzcf.poster.dto.UserPostsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author kevinzcf
 * @version 2019
 */
@Service
public class UserPostsService {
    @Autowired
    private UserAsynchronousService userAsynchronousService;
    @Autowired
    private PostsAsynchronousService postsAsynchronousService;

    public UserPostsDTO getUserPosts(String userId) {
        UserPostsDTO out = new UserPostsDTO();
        try {
            Future<UserDTO> userDTOFuture = userAsynchronousService.fetchUser(userId);
            Future<PostListDTO> postListDTOFuture = postsAsynchronousService.fetchPosts(userId);
            out.setUser(userDTOFuture.get());
            out.setPosts(postListDTOFuture.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return out;
    }
}

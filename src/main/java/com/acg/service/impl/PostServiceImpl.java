package com.acg.service.impl;

import com.acg.entity.Post;
import com.acg.mapper.PostMapper;
import com.acg.mapper.UserMapper;
import com.acg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired(required = false)
    private PostMapper postMapper;

    @Override
    public boolean sendPost(Post post) {
        return postMapper.sendPost(post);
    }

    @Override
    public List<Post> getPost(Post post) {
        return postMapper.getPost(post);
    }

    @Override
    public List<Post> getWeekPost() {
        return postMapper.getWeekPost();
    }

    @Override
    public Post getPostById(Post post) {
        return postMapper.getPostById(post);
    }

    @Override
    public List getPostByUserId(Post post) {
        return postMapper.getPostByUserId(post);
    }
}

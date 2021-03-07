package com.acg.mapper;

import com.acg.entity.Post;

import java.util.List;

public interface PostMapper {
    public boolean sendPost(Post post);

    public List<Post> getPost(Post post);

    public List<Post> getWeekPost();

    public Post getPostById(Post post);

    public List getPostByUserId(Post post);
}

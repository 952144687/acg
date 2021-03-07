package com.acg.controller;

import com.acg.entity.Post;
import com.acg.entity.User;
import com.acg.service.impl.PostServiceImpl;
import com.acg.service.impl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    private static String imgaddress = "http://localhost:8888/ACG__war_exploded/postImg/";

    @RequestMapping("/getPostImage/{u_id}")
    @ResponseBody
    public Map getPostImage(@RequestBody MultipartFile file, @PathVariable String u_id) throws IOException {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");//
        String format = fmt.format(new Date());
        String imgName = u_id + format + ".jpg";
        String a_image = imgaddress + imgName;
        InputStream inputStream = file.getInputStream();

        String PostImagePosition = "D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\post_img\\" + imgName;
        OutputStream outputStream = new FileOutputStream(PostImagePosition);
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bs)) != -1) {
            outputStream.write(bs, 0, len);
        }
        Map map = new HashMap();
        map.put("code", 200);
        map.put("info", a_image);
        return map;
    }

    @RequestMapping("/sendPost")
    @ResponseBody
    public Map sendPost(@RequestBody Post post) {
        boolean b = postService.sendPost(post);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("flag", b);
        return map;
    }

    @RequestMapping("/getPost/{currentPage}/{pageSize}")
    @ResponseBody
    public Map getPost(@PathVariable int currentPage, @PathVariable int pageSize, @RequestBody Post post) throws ParseException {
        List<Post> get_post = postService.getPost(post);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd ");//
        for (Post p : get_post) {

            String format = fmt.format(fmt.parse(p.getP_time()));
            p.setP_time(format);
        }
        int total = get_post.size();
        List<Post> selectPost = null;
        if (((currentPage - 1) * pageSize + pageSize) < total) {
            selectPost = get_post.subList((currentPage - 1) * pageSize, (currentPage - 1) * pageSize + pageSize);
        } else {
            selectPost = get_post.subList((currentPage - 1) * pageSize, total);
        }

        Map map = new HashMap();
        map.put("code", 200);
        map.put("total", total);
        map.put("data", selectPost);
        return map;
    }

    @RequestMapping("/getWeekPost")
    @ResponseBody
    public Map getWeekPost() throws ParseException {
        List<Post> weekPost = postService.getWeekPost();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd ");//
        for (Post p : weekPost) {

            String format = fmt.format(fmt.parse(p.getP_time()));
            p.setP_time(format);
        }
        Map map = new HashMap();
        map.put("code", 200);
        map.put("data", weekPost);
        return map;
    }

    @RequestMapping("/getPostById")
    @ResponseBody
    public Map getPostById(@RequestBody Post post) throws ParseException {
        Post postById = postService.getPostById(post);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd ");//


        String format = fmt.format(fmt.parse(postById.getP_time()));
        postById.setP_time(format);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("data", postById);
        return map;
    }

    @RequestMapping("/getPostByUserId")
    @ResponseBody
    public Map getPostByUserId(@RequestBody Post post) throws ParseException {
        List<Post> postById = postService.getPostByUserId(post);

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd ");//
        for (Post p : postById) {

            String format = fmt.format(fmt.parse(p.getP_time()));
            p.setP_time(format);
        }
        Map map = new HashMap();
        map.put("code", 200);
        map.put("data", postById);
        return map;
    }
}
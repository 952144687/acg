package com.acg.controller;

import com.acg.entity.User;

import com.acg.service.impl.UserServiceImpl;
import com.acg.utils.AnimeJavaMail;
import com.acg.utils.VerificationCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    private static String imgaddress = "http://localhost:8888/ACG__war_exploded/userAvatar/";


    @RequestMapping("/sendMail/{userMail}")
    @ResponseBody
    public  Map testMail(@PathVariable String userMail){
        userMail= userMail+".com";
        Map map = new HashMap();
        System.out.println(userMail+"===");
        VerificationCode verificationCode = new VerificationCode();
        String code = verificationCode.Code();
        String toMail = "您的验证码为： "+code;
        AnimeJavaMail animeJavaMail = new AnimeJavaMail();
        try {
            animeJavaMail.sendEmail(userMail,toMail);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
        map.put("code",20000);
        map.put("flag","true");
        map.put("data",code);
        return map;
    }

    @RequestMapping("/Regist")
    @ResponseBody
    public Map Regist(@RequestBody User user){
        String u_password = user.getU_password();
        String md5_password = DigestUtils.md5Hex(u_password);
        user.setU_password(md5_password);
        boolean b = userService.addUser(user);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("flag",b);
        return map;
    }

    @RequestMapping("/Login")
    @ResponseBody
    public Map Login(@RequestBody User user){
        Map map = new HashMap();
        User result = userService.queryUserByMail(user);
        String password = result.getU_password();
        System.out.println(password);
        String u_password = user.getU_password();
        String s = DigestUtils.md5Hex(u_password);

        if (s.equals(password)){
            map.put("code",20000);
            map.put("user",result);
            map.put("flag","true");
            return map;
        }

        map.put("code",20000);
        map.put("flag","false");
        return map;
    }


    @RequestMapping("/getUserAvatar/{u_id}")
    @ResponseBody
    public Map getUserAvatar(@RequestBody MultipartFile file, @PathVariable String u_id) throws IOException {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");//
        String format = fmt.format(new Date());
        String imgName = u_id + format + ".jpg";
        String a_image = imgaddress + imgName;
        InputStream inputStream = file.getInputStream();
        String PostImagePosition = "D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\user_avatar\\" + imgName;
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
}

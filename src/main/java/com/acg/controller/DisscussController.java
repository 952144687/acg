package com.acg.controller;

import com.acg.entity.Disscuss;
import com.acg.entity.PostDisscuss;
import com.acg.entity.User;
import com.acg.service.impl.AnimeServiceImpl;
import com.acg.service.impl.DisscussServiceImpl;
import com.acg.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DisscussController {
    @Autowired
    private DisscussServiceImpl disscussService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getDisscuss/{a_id}")
    @ResponseBody
    public Map getDisscuss(@PathVariable int a_id) throws Exception {
        List<Disscuss> list = disscussService.selectByAnimeID(a_id);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
        int length = list.size();
        Map data = new HashMap();
        List commentList = new ArrayList();
        for (Disscuss disscuss :list){

            int flag = disscuss.getD_to_d_id();
            if (flag==0){
                Map map = new HashMap();
                int d_id = disscuss.getD_id();
                Map user = new HashMap();
                user.put("id",disscuss.getUser().getU_id());
                user.put("nickName",disscuss.getUser().getU_name());
                user.put("avatar",disscuss.getUser().getU_img());

               map.put("id",d_id);
               map.put("commentUser",user);
               map.put("content",disscuss.getD_content());
                map.put("createDate",fmt.format(fmt.parse(disscuss.getD_createDate())));

               List childUsers = new ArrayList();
               for (Disscuss children :list){
                   if (children.getD_number()==d_id &&children.getD_number()!=0){
                       Map c = new HashMap();
                       c.put("id",children.getUser().getU_id());
                       c.put("nickName",children.getUser().getU_name());
                       c.put("avatar",children.getUser().getU_img());

                       Map t = new HashMap();
                       User to = userService.queryUserById(children.getD_to_d_id());
                       t.put("id",to.getU_id());
                       t.put("nickName",to.getU_name());
                       t.put("avatar",to.getU_img());

                       Map commentUser = new HashMap();
                       commentUser.put("id",children.getD_id());
                       commentUser.put("commentUser",c);
                       commentUser.put("content",children.getD_content());
                       commentUser.put("createDate",fmt.format(fmt.parse(children.getD_createDate())));
                       commentUser.put("targetUser",t);
                       childUsers.add(commentUser);

                   }
               }
                map.put("childrenList",childUsers);
                commentList.add(map);
            }

        }
        data.put("code",20000);
        data.put("data",commentList);
        data.put("commentNum",length);
        return data;
    }

    @RequestMapping("/doSend")
    @ResponseBody
    public Map doSend(@RequestBody Map msg){
        int a_id = Integer.parseInt(msg.get("a_id").toString());
        int u_id = Integer.parseInt(msg.get("u_id").toString());
        String context = msg.get("context").toString();


        boolean b = disscussService.doSend(a_id, u_id, context);
        Map map = new HashMap();

            map.put("code",20000);
            map.put("flag",b);
            return map;
        }

    @RequestMapping("/doChidSend")
    @ResponseBody
    public Map doChidSend(@RequestBody Map msg){
        int a_id = Integer.parseInt(msg.get("a_id").toString());
        int u_id = Integer.parseInt(msg.get("u_id").toString());
        String context = msg.get("context").toString();
        int d_to_d_id = Integer.parseInt(msg.get("d_to_d_id").toString());
        int d_number = Integer.parseInt(msg.get("d_number").toString());

        boolean b = disscussService.doChidSend(a_id, u_id, context,d_to_d_id,d_number);
        Map map = new HashMap();

        map.put("code",20000);
        map.put("flag",b);
        return map;
    }



    //---

    @RequestMapping("/getPostDisscuss/{p_id}")
    @ResponseBody
    public Map getPostDisscuss(@PathVariable int p_id) throws Exception {
        System.out.println(p_id+"==");
        List<PostDisscuss> list = disscussService.selectByPostID(p_id);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
        int length = list.size();
        Map data = new HashMap();
        List commentList = new ArrayList();
        for (PostDisscuss disscuss :list){

            int flag = disscuss.getD_to_d_id();
            if (flag==0){
                Map map = new HashMap();
                int d_id = disscuss.getD_id();
                Map user = new HashMap();
                user.put("id",disscuss.getUser().getU_id());
                user.put("nickName",disscuss.getUser().getU_name());
                user.put("avatar",disscuss.getUser().getU_img());

                map.put("id",d_id);
                map.put("commentUser",user);
                map.put("content",disscuss.getD_content());
                map.put("createDate",fmt.format(fmt.parse(disscuss.getD_createDate())));

                List childUsers = new ArrayList();
                for (PostDisscuss children :list){
                    if (children.getD_number()==d_id &&children.getD_number()!=0){
                        Map c = new HashMap();
                        c.put("id",children.getUser().getU_id());
                        c.put("nickName",children.getUser().getU_name());
                        c.put("avatar",children.getUser().getU_img());

                        Map t = new HashMap();
                        User to = userService.queryUserById(children.getD_to_d_id());
                        t.put("id",to.getU_id());
                        t.put("nickName",to.getU_name());
                        t.put("avatar",to.getU_img());

                        Map commentUser = new HashMap();
                        commentUser.put("id",children.getD_id());
                        commentUser.put("commentUser",c);
                        commentUser.put("content",children.getD_content());
                        commentUser.put("createDate",fmt.format(fmt.parse(children.getD_createDate())));
                        commentUser.put("targetUser",t);
                        childUsers.add(commentUser);

                    }
                }
                map.put("childrenList",childUsers);
                commentList.add(map);
            }

        }
        data.put("code",20000);
        data.put("data",commentList);
        data.put("commentNum",length);
        return data;
    }


    @RequestMapping("/PostdoSend")
    @ResponseBody
    public Map PostdoSend(@RequestBody Map msg){
        int p_id = Integer.parseInt(msg.get("p_id").toString());
        int u_id = Integer.parseInt(msg.get("u_id").toString());
        String context = msg.get("context").toString();


        boolean b = disscussService.PostdoSend(p_id, u_id, context);
        Map map = new HashMap();

        map.put("code",20000);
        map.put("flag",b);
        return map;
    }

    @RequestMapping("/PostdoChidSend")
    @ResponseBody
    public Map PostdoChidSend(@RequestBody Map msg){
        int a_id = Integer.parseInt(msg.get("p_id").toString());
        int u_id = Integer.parseInt(msg.get("u_id").toString());
        String context = msg.get("context").toString();
        int d_to_d_id = Integer.parseInt(msg.get("d_to_d_id").toString());
        int d_number = Integer.parseInt(msg.get("d_number").toString());

        boolean b = disscussService.PostdoChidSend(a_id, u_id, context,d_to_d_id,d_number);
        Map map = new HashMap();

        map.put("code",20000);
        map.put("flag",b);
        return map;
    }


}

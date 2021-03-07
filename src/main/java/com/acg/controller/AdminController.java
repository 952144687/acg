package com.acg.controller;


import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.MimeHeaders;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @RequestMapping(value = "/vue-admin-template/user/login",method = RequestMethod.POST)
    Map login(){

        Map map = new HashMap();
        Map data = new HashMap();
        data.put("token","admin-token");
        map.put("code",20000);
        map.put("data", data);
        return map;
    }


    @RequestMapping(value="/vue-admin-template/user/info",method = RequestMethod.GET)
    Map info(){

        Map map = new HashMap();
        Map data = new HashMap();
        String[] roles = new String[]{"admin"};
        data.put("roles",roles);
        data.put("introduction","I am a super administrator");
        data.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name","admin");
        map.put("code",20000);
        map.put("data",data);
        return map;
    }
}

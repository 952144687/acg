package com.acg.controller;

import com.acg.entity.Picture;
import com.acg.entity.Post;
import com.acg.service.impl.PictureServiceImpl;
import com.acg.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class PictureController {
    @Autowired
    private PictureServiceImpl pictureService;
    private static String imgaddress = "http://localhost:8888/ACG__war_exploded/pic/";


    @RequestMapping("/getPicture/{u_id}")
    @ResponseBody
    public Map getPicture(@RequestBody MultipartFile file, @PathVariable String u_id) throws IOException {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");//
        String format = fmt.format(new Date());
        String imgName = u_id + format + ".jpg";
        String a_image = imgaddress + imgName;
        InputStream inputStream = file.getInputStream();

        String PostImagePosition = "D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\pic\\" + imgName;
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

    @RequestMapping("/sendPicture")
    @ResponseBody
    public Map sendPicture(@RequestBody Map map) {
        List<Map<String,String>> list = (List<Map<String,String>>) map.get("list");
        Map map1 = new HashMap();
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            String string = JSON.toJSONString(list.get(i));
            String u_id = list.get(i).get("u_id");
            String pic_atlas_number = list.get(i).get("pic_atlas_number").trim();
            String pic_number = list.get(i).get("pic_number");
            String pic_url = list.get(i).get("pic_url");
            String pic_tittle = list.get(i).get("pic_tittle");
            int i1 = Integer.parseInt(pic_number.trim());
            int i2 = Integer.parseInt(u_id.trim());
            int i3 = Integer.parseInt(pic_atlas_number.trim());
            pictureService.sendPicture(i3,i2,i1,pic_url,pic_tittle);
        }
        map.put("flag",flag);
        return map;
    }

    @RequestMapping("/getUserPic/{u_id}")
    @ResponseBody
    public Map getUserPic(@PathVariable int u_id) throws ParseException {
        List<Picture> userPic = pictureService.getUserPic(u_id);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");//
        int n = 0;
        List data = new ArrayList();
        Map map = new HashMap();
        for (Picture p :userPic){
            if (n==0 || n!=p.getPic_atlas_number()){
                List item = new ArrayList();
                n = p.getPic_atlas_number();
                for (Picture p1 :userPic){
                    if (p1.getPic_atlas_number() == n){
                        String format = fmt.format(fmt.parse(p1.getPic_time()));
                        p1.setPic_time(format);
                        item.add(p1);
                    }
                }
                data.add(item);
            }
        }

        map.put("data",data);
        return map;
    }

    @RequestMapping("/deletePic")
    @ResponseBody
    public Map deletePic(@RequestParam(value = "param[]",required = false) int[] param) {
        String p = "(0";
        for(int i : param){
            p = p+","+i;
        }
        p+=")";
        boolean b = pictureService.deletePic(p);
        Map map = new HashMap();
        map.put("flag",b);
        return map;
    }
    @RequestMapping("/test")
    @ResponseBody
    public Map test(@RequestParam(value = "param") String param) {

        Map map = new HashMap();

        System.out.println(param);
        map.put("flag",true);
        return map;
    }


    @RequestMapping("/getAllPic")
    @ResponseBody
    public Map getAllPic() throws ParseException {
        List<Picture> allPic = pictureService.getAllPic();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");//
        int n = 0;
        List data = new ArrayList();
        Map map = new HashMap();
        for (Picture p :allPic){
            if (n==0 || n!=p.getPic_atlas_number()){
                List item = new ArrayList();
                n = p.getPic_atlas_number();
                for (Picture p1 :allPic){
                    if (p1.getPic_atlas_number() == n){
                        String format = fmt.format(fmt.parse(p1.getPic_time()));
                        p1.setPic_time(format);
                        item.add(p1);
                    }
                }
                data.add(item);
            }
        }
        map.put("data",data);
        return map;
    }
}

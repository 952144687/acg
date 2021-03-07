package com.acg.controller;

import com.acg.entity.Anime;
import com.acg.entity.AnimeItem;
import com.acg.service.impl.AnimeServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimeController {
    @Autowired
    private AnimeServiceImpl animeService;

    private String AnimeImagePosition;

    private static String imgaddress = "http://localhost:8888/ACG__war_exploded/img/";
    //------------------- 业务 -----------------------------------
    
//    //查询所有动漫
//    @RequestMapping("/selectAllAnimes")
//    @ResponseBody
//    public Map selectAllAnimes(){
//        Map map = new HashMap();
//        map.put("code",20000);
//        map.put("flag","true");
//        List<Anime> anime = animeService.selectAllAnimes();
//        map.put("data",anime);
//        return map;
//    }

    //查询所有动漫
    @RequestMapping("/selectAllAnimes/{currentPage}/{pageSize}")
    @ResponseBody
    public Map selectAllAnimes(@PathVariable int currentPage,@PathVariable int pageSize){
        Map map = new HashMap();
        map.put("code",20000);
        map.put("flag","true");
        List<Anime> animes = animeService.selectAllAnimes();

        int total = animes.size();
        List<Anime> selectAnimes = null;
        if (((currentPage-1)*pageSize+pageSize)<total){
            selectAnimes = animes.subList((currentPage-1)*pageSize,(currentPage-1)*pageSize+pageSize);
        }else {
            selectAnimes = animes.subList((currentPage-1)*pageSize,total);
        }
        map.put("total",total);
        map.put("data",selectAnimes);
        return map;
    }
    //添加图片
    @RequestMapping(value = "/getAnimeImage")
    public void getAnimeImage(@RequestBody MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        AnimeImagePosition = "D:\\anana_resource\\Graduation Project\\project\\ACG-后端\\src\\main\\resources\\img\\anime_img\\"+originalFilename;
        OutputStream outputStream =new FileOutputStream(AnimeImagePosition);
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(bs))!= -1){
            outputStream.write(bs,0,len);
        }
    }
    //添加动漫
    @RequestMapping("/insertAnime")
    @ResponseBody
    public Map insertAnime(@RequestBody Anime anime){
        Map map = new HashMap();
        map.put("code",20000);
        String a_image = imgaddress+anime.getA_name()+".jpg";
        anime.setA_image(a_image);
        anime.toString();
        boolean insertAnime = animeService.insertAnime(anime);
        map.put("flag",insertAnime);
        return map;
    }


    //删除动漫
    @RequestMapping("/delectAnime")
    @ResponseBody
    public Map delectAnime(@RequestBody String[] animes){
        String arr = " ('' ";
        for (String anime: animes ) {
           arr +=(","+"'"+anime+"'");
        }
        arr+=")";
        animeService.delectAnime(arr);
        Map map = new HashMap();
        map.put("code",20000);
        return map;
    }

    //条件查询
    @RequestMapping("/select/{input}/{currentPage}/{pageSize}")
    @ResponseBody
    public Map select(@PathVariable String input,@PathVariable int currentPage,@PathVariable int pageSize){
        input="%"+input+"%";
        List<Anime> animeList = animeService.select(input);
        int total = animeList.size();

        List<Anime> selectAnimes = null;
        if (((currentPage-1)*pageSize+pageSize)<total){
            selectAnimes = animeList.subList((currentPage-1)*pageSize,(currentPage-1)*pageSize+pageSize);
        }else {
            selectAnimes = animeList.subList((currentPage-1)*pageSize,total);
        }
        Map map = new HashMap();
        map.put("code",20000);
        map.put("total",total);
        map.put("data",selectAnimes);
        return map;
    }
    //修改
    @RequestMapping("/saveAnime")
    @ResponseBody
    public Map changeAnime(@RequestBody Anime anime){
        boolean b = animeService.changeAnime(anime);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("flag",b);
        return map;
    }

    @RequestMapping("/selectAnimeItem/{currentPage}/{pageSize}")
    @ResponseBody
    public Map selectAnimeItem(@PathVariable int currentPage,@PathVariable int pageSize){
        List list = animeService.selectAnimeItem();
        int total = list.size();
        System.out.println(total+"=========");
        List<Anime> selectAnimeItems = null;
        if (((currentPage-1)*pageSize+pageSize)<total){
            selectAnimeItems = list.subList((currentPage-1)*pageSize,(currentPage-1)*pageSize+pageSize);
        }else {
            selectAnimeItems = list.subList((currentPage-1)*pageSize,total);
        }
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",selectAnimeItems);
        map.put("total",total);
        return map;
    }
    @RequestMapping("/addAnimeItem")
    @ResponseBody
    public Map addAnimeItem(@RequestBody AnimeItem animeItem){
       boolean b =false;
        try {
             b = animeService.addAnimeItem(animeItem);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("animenitem插入失败");
        }

        Map map = new HashMap();
        map.put("code",20000);
        map.put("flag",b);
        return map;
    }
    @RequestMapping("/delectAnimeItem/{a_id}/{a_number}")
    @ResponseBody
    public Map delectAnimeItem(@PathVariable int a_id,@PathVariable int a_number){
        System.out.println(a_id+"===");
        System.out.println(a_number+"===");
        boolean b =false;
        b = animeService.delectAnimeItem(a_id, a_number);
        System.out.println(b);

        Map map = new HashMap();
        map.put("code",20000);
        map.put("flag",b);
        return map;
    }

    @RequestMapping("/searchAnimeItem/{input}/{currentPage}/{pageSize}")
    @ResponseBody
    public Map searchAnimeItem(@PathVariable String input,@PathVariable int currentPage,@PathVariable int pageSize){
        input = "%"+input+"%";

        List list = animeService.searchAnimeItem(input);
        int total = list.size();

        List<Anime> selectAnimeItems = null;
        if (((currentPage-1)*pageSize+pageSize)<total){
            selectAnimeItems = list.subList((currentPage-1)*pageSize,(currentPage-1)*pageSize+pageSize);
        }else {
            selectAnimeItems = list.subList((currentPage-1)*pageSize,total);
        }
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",selectAnimeItems);
        map.put("total",total);
        return map;
    }
    //------------前台----------
    @RequestMapping("/selectByType/{a_type}/{currentPage}/{pageSize}")
    @ResponseBody
    public Map selectByType(@PathVariable String a_type,@PathVariable int currentPage,@PathVariable int pageSize){
        List list = animeService.selectByType(a_type);
        int total = list.size();
        List<Anime> selectAnimeItems = null;
        if (((currentPage-1)*pageSize+pageSize)<total){
            selectAnimeItems = list.subList((currentPage-1)*pageSize,(currentPage-1)*pageSize+pageSize);
        }else {
            selectAnimeItems = list.subList((currentPage-1)*pageSize,total);
        }
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",selectAnimeItems);
        map.put("total",total);
        return map;
    }
    @RequestMapping("/searchAnime/{input}/{currentPage}/{pageSize}")
    @ResponseBody
    public Map searchAnime(@PathVariable String input,@PathVariable int currentPage,@PathVariable int pageSize){
        input = "%"+input+"%";
        List list = animeService.searchAnime(input);
        int total = list.size();
        List<Anime> selectAnimeItems = null;
        if (((currentPage-1)*pageSize+pageSize)<total){
            selectAnimeItems = list.subList((currentPage-1)*pageSize,(currentPage-1)*pageSize+pageSize);
        }else {
            selectAnimeItems = list.subList((currentPage-1)*pageSize,total);
        }
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",selectAnimeItems);
        map.put("total",total);
        return map;
    }
    @RequestMapping("/maxAnimeNumber/{a_id}")
    @ResponseBody
    public Map maxAnimeNumber(@PathVariable int a_id){
        int max_number = animeService.maxAnimeNumber(a_id);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",max_number);
        return map;
    }
    @RequestMapping("/getAnimeItems/{a_id}")
    @ResponseBody
    public Map getAnimeItems(@PathVariable int a_id){
        List animeItems = animeService.getAnimeItems(a_id);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",animeItems);
        return map;
    }

    @RequestMapping("/selectAnimeById/{a_id}")
    @ResponseBody
    public Map selectAnimeById(@PathVariable int a_id){
        Anime anime = animeService.selectAnimeById(a_id);
        Map map = new HashMap();
        map.put("code",20000);
        map.put("data",anime);
        return map;
    }
}

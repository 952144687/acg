package com.acg.service;

import com.acg.entity.Picture;

import java.util.List;

public interface PictureService {
    public boolean sendPicture(int pic_atlas_number,int u_id,int pic_number,String pic_url,String pic_tittle);
    public List getUserPic(int u_id);
    public boolean deletePic(String param);
    public List getAllPic();
}

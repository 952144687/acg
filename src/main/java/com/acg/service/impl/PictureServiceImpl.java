package com.acg.service.impl;

import com.acg.entity.Picture;
import com.acg.mapper.PictureMapper;
import com.acg.mapper.UserMapper;
import com.acg.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired(required = false)
    private PictureMapper pictureMapper;


    @Override
    public boolean sendPicture(int pic_atlas_number,int u_id,int pic_number,String pic_url,String pic_tittle) {
        return pictureMapper.sendPicture(pic_atlas_number,u_id,pic_number,pic_url,pic_tittle);
    }

    @Override
    public List getUserPic(int u_id) {
        return pictureMapper.getUserPic(u_id);
    }

    @Override
    public boolean deletePic(String param) {
        return pictureMapper.deletePic(param);
    }

    @Override
    public List getAllPic() {
        return pictureMapper.getAllPic();
    }
}

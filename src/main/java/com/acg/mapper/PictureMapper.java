package com.acg.mapper;

import com.acg.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureMapper {
    public boolean sendPicture(int pic_atlas_number,int u_id,int pic_number,String pic_url,String pic_tittle);
    public List getUserPic(int u_id);
    public boolean deletePic(@Param("param") String param);

    public List getAllPic();
}

package com.acg.mapper;

import com.acg.entity.Disscuss;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisscussMapper {
    public List selectByAnimeID(@Param("a_id")int a_id);
    public Disscuss selectUserByDTDID(int d_to_d_id);

    public boolean doSend( int a_id, int u_id,String d_context);

    public boolean doChidSend( int a_id, int u_id,String d_content,int d_to_d_id,int d_number);


    //--------
    public List selectByPostID(@Param("p_id")int p_id);


    public boolean PostdoSend( int p_id, int u_id,String d_context);

    public boolean PostdoChidSend( int p_id, int u_id,String d_content,int d_to_d_id,int d_number);

}

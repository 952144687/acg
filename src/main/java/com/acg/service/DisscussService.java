package com.acg.service;

import com.acg.entity.Disscuss;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisscussService {
    public List selectByAnimeID(int a_id);

    public boolean doSend(int a_id, int u_id,String d_context);

    public boolean doChidSend( int a_id, int u_id,String d_content,int d_to_d_id,int d_number);
    public Disscuss selectUserByDTDID(int d_to_d_id);

    //--
    public List selectByPostID(int p_id);
    public boolean PostdoSend( int p_id, int u_id,String d_context);

    public boolean PostdoChidSend( int p_id, int u_id,String d_content,int d_to_d_id,int d_number);

}

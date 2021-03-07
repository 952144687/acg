package com.acg.service.impl;

import com.acg.entity.Disscuss;
import com.acg.mapper.DisscussMapper;
import com.acg.mapper.UserMapper;
import com.acg.service.DisscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisscussServiceImpl implements DisscussService {
    @Autowired(required = false)
    private DisscussMapper disscussMapper;
    @Override
    public List selectByAnimeID(int a_id) {
        return disscussMapper.selectByAnimeID(a_id);
    }

    @Override
    public boolean doSend(int a_id, int u_id, String d_context) {
        return disscussMapper.doSend(a_id,u_id,d_context);
    }

    @Override
    public boolean doChidSend(int a_id, int u_id, String d_content, int d_to_d_id, int d_number) {
        return disscussMapper.doChidSend(a_id,u_id,d_content,d_to_d_id,d_number);
    }

    @Override
    public Disscuss selectUserByDTDID(int d_to_d_id) {
        return disscussMapper.selectUserByDTDID(d_to_d_id);
    }

    @Override
    public List selectByPostID(int p_id) {
        return disscussMapper.selectByPostID(p_id);
    }

    @Override
    public boolean PostdoSend(int p_id, int u_id, String d_context) {
        return disscussMapper.PostdoSend( p_id,u_id, d_context);
    }

    @Override
    public boolean PostdoChidSend(int p_id, int u_id, String d_content, int d_to_d_id, int d_number) {
        return disscussMapper.PostdoChidSend( p_id,  u_id,  d_content,d_to_d_id,  d_number);
    }
}

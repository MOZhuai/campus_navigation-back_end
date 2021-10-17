package com.mobile.service;

import com.mobile.bean.Road;
import com.mobile.bean.RoadExample;
import com.mobile.dao.RoadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/27 22:40
 */
@Service
public class RoadService {

    @Autowired
    RoadMapper roadMapper;

    public List<Road> getByBName(String name){
        return roadMapper.selectByBuilding(name);
    }

    public void add(Road road){
        roadMapper.insertSelective(road);
    }

    public void delByExample(RoadExample roadExample){
        roadMapper.deleteByExample(roadExample);
    }

}

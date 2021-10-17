package com.mobile.service;

import com.mobile.bean.KeyPoint;
import com.mobile.bean.KeyPointExample;
import com.mobile.bean.Road;
import com.mobile.dao.KeyPointMapper;
import com.mobile.view.RoadKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/27 16:24
 */
@Service
public class KeyPointService {

    @Autowired
    KeyPointMapper keyPointMapper;

    public KeyPoint getByBuildingAndName(RoadKey roadKey){
        return keyPointMapper.selectByBuildingAndName(roadKey);
    }

    public List<KeyPoint> getBySSMap(String ssmap){
        return keyPointMapper.selectByBuilding(ssmap);
    }

    public void addKeyPoint(KeyPoint keyPoint){
        keyPointMapper.insertSelective(keyPoint);
    }

    public KeyPoint getById(Integer id){
        return keyPointMapper.selectByPrimaryKey(id);
    }

    public void delKeyPoint(KeyPointExample keyPointExample){
        keyPointMapper.deleteByExample(keyPointExample);
    }

    public KeyPoint getByExample(KeyPointExample keyPointExample) {
        return keyPointMapper.selectByExample(keyPointExample).get(0);
    }
    public List<KeyPoint> getListByExample(KeyPointExample keyPointExample) {
        return keyPointMapper.selectByExample(keyPointExample);
    }

    public List<KeyPoint> getByBuilding(Integer id) {
        return keyPointMapper.selectByBuildingId(id);
    }

    public Integer getNumberById(RoadKey roadKey){
        return keyPointMapper.selectNumberById(roadKey);
    }
}

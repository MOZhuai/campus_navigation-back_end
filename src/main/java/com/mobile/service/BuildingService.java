package com.mobile.service;

import com.mobile.bean.Building;
import com.mobile.dao.BuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/27 2:08
 */
@Service
public class BuildingService {

    @Autowired
    BuildingMapper buildingMapper;

    public List<Building> getAll(){
        return buildingMapper.selectByExample(null);
    }

    public Building getByName(String name){
        return buildingMapper.selectByName(name);
    }

    public Building getBySSMap(String ssmap){
        return buildingMapper.selectBySSMap(ssmap);
    }

    public Building getById(Integer id){
        return buildingMapper.selectByPrimaryKey(id);
    }

    public void add(Building building){
        buildingMapper.insertSelective(building);
    }

    public void update(Building building) {
        buildingMapper.updateByPrimaryKeySelective(building);
    }

    public Integer getNumberById(Integer id){
        return buildingMapper.selectNumberById(id);
    }
}

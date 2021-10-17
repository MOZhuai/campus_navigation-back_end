package com.mobile.dao;

import com.mobile.bean.KeyPoint;
import com.mobile.bean.KeyPointExample;
import java.util.List;

import com.mobile.view.RoadKey;
import org.apache.ibatis.annotations.Param;

public interface KeyPointMapper {
    long countByExample(KeyPointExample example);

    int deleteByExample(KeyPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KeyPoint record);

    int insertSelective(KeyPoint record);

    List<KeyPoint> selectByExample(KeyPointExample example);

    KeyPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KeyPoint record, @Param("example") KeyPointExample example);

    int updateByExample(@Param("record") KeyPoint record, @Param("example") KeyPointExample example);

    int updateByPrimaryKeySelective(KeyPoint record);

    int updateByPrimaryKey(KeyPoint record);

    List<KeyPoint> selectByBuilding(String name);

    KeyPoint selectByBuildingAndName(RoadKey roadKey);

    List<KeyPoint> selectByBuildingId(Integer id);

    Integer selectNumberById(RoadKey roadKey);
}
package com.mobile.dao;

import com.mobile.bean.Road;
import com.mobile.bean.RoadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoadMapper {
    long countByExample(RoadExample example);

    int deleteByExample(RoadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Road record);

    int insertSelective(Road record);

    List<Road> selectByExample(RoadExample example);

    Road selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Road record, @Param("example") RoadExample example);

    int updateByExample(@Param("record") Road record, @Param("example") RoadExample example);

    int updateByPrimaryKeySelective(Road record);

    int updateByPrimaryKey(Road record);

    List<Road> selectByBuilding(String name);
}
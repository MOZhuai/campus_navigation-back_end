package com.mobile.dao;

import com.mobile.bean.Examinee;
import com.mobile.bean.ExamineeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamineeMapper {
    long countByExample(ExamineeExample example);

    int deleteByExample(ExamineeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Examinee record);

    int insertSelective(Examinee record);

    List<Examinee> selectByExample(ExamineeExample example);

    Examinee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Examinee record, @Param("example") ExamineeExample example);

    int updateByExample(@Param("record") Examinee record, @Param("example") ExamineeExample example);

    int updateByPrimaryKeySelective(Examinee record);

    int updateByPrimaryKey(Examinee record);

    Examinee selectByAcc(String acc);

    List<Examinee> selectBySubjectId(Integer id);

    List<Examinee> selectBySearchInfo(String info);
}
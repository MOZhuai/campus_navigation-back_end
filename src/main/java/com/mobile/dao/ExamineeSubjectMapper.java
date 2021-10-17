package com.mobile.dao;

import com.mobile.bean.ExamineeSubject;
import com.mobile.bean.ExamineeSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamineeSubjectMapper {
    long countByExample(ExamineeSubjectExample example);

    int deleteByExample(ExamineeSubjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamineeSubject record);

    int insertSelective(ExamineeSubject record);

    List<ExamineeSubject> selectByExample(ExamineeSubjectExample example);

    ExamineeSubject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamineeSubject record, @Param("example") ExamineeSubjectExample example);

    int updateByExample(@Param("record") ExamineeSubject record, @Param("example") ExamineeSubjectExample example);

    int updateByPrimaryKeySelective(ExamineeSubject record);

    int updateByPrimaryKey(ExamineeSubject record);

    List<ExamineeSubject> selectByExaminee(Integer id);

    List<ExamineeSubject> selectBySubjectId(Integer id);

    ExamineeSubject selectByPrimaryKeyWithAllInfo(Integer id);
}
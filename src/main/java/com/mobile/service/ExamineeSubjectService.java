package com.mobile.service;

import com.mobile.bean.ExamineeSubject;
import com.mobile.bean.ExamineeSubjectExample;
import com.mobile.dao.ExamineeSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/22 22:52
 */
@Service
public class ExamineeSubjectService {

    @Autowired
    ExamineeSubjectMapper examineeSubjectMapper;

    public List<ExamineeSubject> getByExaminee(Integer id){
        return examineeSubjectMapper.selectByExaminee(id);
    }

    public List<ExamineeSubject> getByExample(ExamineeSubjectExample examineeSubjectExample) {
        return examineeSubjectMapper.selectByExample(examineeSubjectExample);
    }

    public void deleteByExaminee(ExamineeSubjectExample examineeSubjectExample) {
        examineeSubjectMapper.deleteByExample(examineeSubjectExample);
    }

    public void add(ExamineeSubject examineeSubject) {
        examineeSubjectMapper.insertSelective(examineeSubject);
    }

    public List<ExamineeSubject> getBySubject(Integer id) {
        return examineeSubjectMapper.selectBySubjectId(id);
    }

    public ExamineeSubject getById(Integer id) {
        return examineeSubjectMapper.selectByPrimaryKeyWithAllInfo(id);
    }

    public void update(ExamineeSubject examineeSubject){
        examineeSubjectMapper.updateByPrimaryKeySelective(examineeSubject);
    }
}

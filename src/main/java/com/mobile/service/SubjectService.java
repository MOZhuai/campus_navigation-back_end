package com.mobile.service;

import com.mobile.bean.Subject;
import com.mobile.dao.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/5/5 0:56
 */
@Service
public class SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    public Subject getById(Integer id){
        return subjectMapper.selectByPrimaryKey(id);
    }

    public List<Subject> getAll(){
        return subjectMapper.selectByExample(null);
    }

    public void add(Subject subject) {
        subjectMapper.insertSelective(subject);
    }

    public void update(Subject subject) {
        subjectMapper.updateByPrimaryKeySelective(subject);
    }

    public void delete(Integer id) {
        subjectMapper.deleteByPrimaryKey(id);
    }
}

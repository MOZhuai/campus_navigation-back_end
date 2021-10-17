package com.mobile.service;

import com.mobile.bean.Examinee;
import com.mobile.bean.ExamineeExample;
import com.mobile.dao.ExamineeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/22 20:15
 */
@Service
public class ExamineeService {

    @Autowired
    ExamineeMapper examineeMapper;

    public List<Examinee> getAll(){
        return examineeMapper.selectByExample(null);
    }

    public Examinee getByAcc(String acc){
        return examineeMapper.selectByAcc(acc);
    }

    public void add(Examinee examinee) {
        examineeMapper.insertSelective(examinee);
    }

    public Examinee getById(Integer id) {
        return examineeMapper.selectByPrimaryKey(id);
    }

    public void update(Examinee examinee) {
        examineeMapper.updateByPrimaryKeySelective(examinee);
    }

    public void delete(Integer id) {
        examineeMapper.deleteByPrimaryKey(id);
    }

    public List<Examinee> getBySubject(Integer id) {
        return examineeMapper.selectBySubjectId(id);
    }

    public List<Examinee> getBySearchInfo(String info){
        return examineeMapper.selectBySearchInfo(info);
    }

    public List<Examinee> getByExample(ExamineeExample examineeExample){
        return examineeMapper.selectByExample(examineeExample);
    }
}

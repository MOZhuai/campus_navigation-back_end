package com.mobile.controller;

import com.mobile.bean.*;
import com.mobile.dao.ExamineeMapper;
import com.mobile.service.ExamineeService;
import com.mobile.service.ExamineeSubjectService;
import com.sun.deploy.security.MSCryptoDSASignature;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/22 20:36
 */
@Controller
@CrossOrigin
@RequestMapping("/examinee")
public class ExamineeController {

    @Autowired
    ExamineeService examineeService;

    @Autowired
    ExamineeSubjectService examineeSubjectService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Msg test(){
        return Msg.success().add("testinfo", "success");
    }

    @ResponseBody
    @RequestMapping(value = "/getByExample", method = RequestMethod.POST)
    public Msg getByExample(Examinee examinee){
        ExamineeExample examineeExample = new ExamineeExample();
        ExamineeExample.Criteria criteria = examineeExample.createCriteria();
        criteria.andEidLike("%" + examinee.getEid() + "%");
        criteria.andNameLike("%" + examinee.getName() + "%");
        criteria.andIdCardLike("%" + examinee.getIdCard() + "%");
        List<Examinee> examinees = examineeService.getByExample(examineeExample);
        if(examinees.isEmpty()){
            return Msg.fail();
        }
        return Msg.success().add("examinees", examinees);
    }

    @ResponseBody
    @RequestMapping(value = "/judgeInsert", method = RequestMethod.POST)
    public Msg judgeExaminee(Examinee examinee){
        // 查看考生的是否存在，存在则返回id
        ExamineeExample examineeExample = new ExamineeExample();
        ExamineeExample.Criteria criteria = examineeExample.createCriteria();
        criteria.andEidEqualTo(examinee.getEid());
        criteria.andGenderEqualTo(examinee.getGender());
        criteria.andIdCardEqualTo(examinee.getIdCard());
        criteria.andNameEqualTo(examinee.getName());
        List<Examinee> examinees1 = examineeService.getByExample(examineeExample);
        if(!examinees1.isEmpty()){
            return Msg.success().add("info", "考生存在").add("examinee", examinees1.get(0));
        }
        // 若不存在，则查看idcard是否存在，存在则返回fail，idcard已存在
        ExamineeExample examineeExample2 = new ExamineeExample();
        ExamineeExample.Criteria criteria2 = examineeExample2.createCriteria();
        criteria2.andIdCardEqualTo(examinee.getIdCard());
        List<Examinee> examinees2 = examineeService.getByExample(examineeExample2);
        if(!examinees2.isEmpty()){
            return Msg.fail().add("info", "该身份证已存在");
        }
        // 若不存在，则查看eid是否存在，存在则返回fail，eid已存在
        ExamineeExample examineeExample3 = new ExamineeExample();
        ExamineeExample.Criteria criteria3 = examineeExample3.createCriteria();
        criteria3.andEidEqualTo(examinee.getEid());
        List<Examinee> examinees3 = examineeService.getByExample(examineeExample3);
        if(!examinees3.isEmpty()){
            return Msg.fail().add("info", "该准考证号已存在");
        }
        // 若不存在，则添加至数据库，并返回id
        examineeService.add(examinee);
        Examinee examinee1 = examineeService.getByAcc(examinee.getEid());
        return Msg.success().add("info", "考生不存在，已添加").add("examinee", examinee1);
    }
    @ResponseBody
    @RequestMapping(value = "/getBySearchInfo/{info}", method = RequestMethod.GET)
    public Msg getBySearchInfo(@PathVariable("info") String info){
        List<Examinee> examinees = examineeService.getBySearchInfo(info);
        return Msg.success().add("examinees", examinees);
    }

    @ResponseBody
    @RequestMapping(value = "/getBySubject/{id}", method = RequestMethod.GET)
    public Msg getBySubject(@PathVariable("id") Integer id){
        List<Examinee> examinees = examineeService.getBySubject(id);
        return Msg.success().add("examinees", examinees);
    }

    @ResponseBody
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Msg getById(@PathVariable Integer id){
        Examinee examinee = examineeService.getById(id);
        return Msg.success().add("examinee", examinee);
    }

    @ResponseBody
    @RequestMapping(value = "/existAcc/{acc}", method = RequestMethod.GET)
    public Msg accIsExist(@PathVariable("acc") String acc){
        Examinee examinee = examineeService.getByAcc(acc);
        if(null == examinee){
            return Msg.fail().add("failinfo", "no such account exist.");
        }
        return Msg.success().add("examinee", examinee);
    }

    @ResponseBody
    @RequestMapping(value = "/allExaminees", method = RequestMethod.GET)
    public Msg getAll(){
        List<Examinee> examinees = examineeService.getAll();
        return Msg.success().add("examinees", examinees);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg add(Examinee examinee){
        Examinee existAcc = examineeService.getByAcc(examinee.getEid());
        if(null != existAcc){
            return Msg.fail().add("info", "already exist one examinee whose account is " + examinee.getEid());
        }
        examineeService.add(examinee);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Msg update(Examinee examinee){
        examineeService.update(examinee);
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Msg delete(@PathVariable Integer id){
        ExamineeSubjectExample examineeSubjectExample = new ExamineeSubjectExample();
        ExamineeSubjectExample.Criteria criteria = examineeSubjectExample.createCriteria();
        criteria.andEidEqualTo(id);
        examineeSubjectService.deleteByExaminee(examineeSubjectExample);
        examineeService.delete(id);
        return Msg.success();
    }
}

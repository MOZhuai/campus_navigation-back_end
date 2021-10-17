package com.mobile.controller;

import com.mobile.bean.ExamineeSubject;
import com.mobile.bean.ExamineeSubjectExample;
import com.mobile.bean.Msg;
import com.mobile.bean.Subject;
import com.mobile.dao.SubjectMapper;
import com.mobile.service.ExamineeService;
import com.mobile.service.ExamineeSubjectService;
import com.mobile.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.MaskFormatter;
import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/5/5 1:04
 */
@Controller
@CrossOrigin
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    ExamineeSubjectService examineeSubjectService;

    @ResponseBody
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Msg getById(@PathVariable Integer id){
        Subject subject = subjectService.getById(id);
        return Msg.success().add("subject", subject);
    }

    @ResponseBody
    @RequestMapping(value = "/allSubjects", method = RequestMethod.GET)
    public Msg getAll(){
        List<Subject> subjects = subjectService.getAll();
        return Msg.success().add("subjects", subjects);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg add(Subject subject){
        subjectService.add(subject);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Msg update(Subject subject){
        subjectService.update(subject);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Msg delete(@PathVariable Integer id){
        ExamineeSubjectExample examineeSubjectExample = new ExamineeSubjectExample();
        ExamineeSubjectExample.Criteria criteria = examineeSubjectExample.createCriteria();
        criteria.andSubjectEqualTo(id);
        List<ExamineeSubject> examineeSubjects =  examineeSubjectService.getByExample(examineeSubjectExample);
        if(!examineeSubjects.isEmpty()){
            return Msg.fail().add("info", "Some examinees need this subject.");
        }
        subjectService.delete(id);
        return Msg.success();
    }


}

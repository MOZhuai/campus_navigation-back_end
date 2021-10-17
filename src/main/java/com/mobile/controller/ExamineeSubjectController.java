package com.mobile.controller;

import com.mobile.bean.*;
import com.mobile.dao.ExamineeSubjectMapper;
import com.mobile.service.BuildingService;
import com.mobile.service.ExamineeService;
import com.mobile.service.ExamineeSubjectService;
import com.mobile.service.KeyPointService;
import com.mobile.view.Position;
import com.mobile.view.RoadKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/22 22:54
 */
@Controller
@CrossOrigin
@RequestMapping("/examinfo")
public class ExamineeSubjectController {

    @Autowired
    ExamineeSubjectService examineeSubjectService;
    @Autowired
    ExamineeService examineeService;
    @Autowired
    KeyPointService keyPointService;
    @Autowired
    BuildingService buildingService;

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Msg update(ExamineeSubject examineeSubject){
        examineeSubjectService.update(examineeSubject);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/getByPk/{id}", method = RequestMethod.GET)
    public Msg getByPk(@PathVariable("id") Integer id){
        ExamineeSubject examineeSubject = examineeSubjectService.getById(id);
        Integer bnumber = buildingService.getNumberById(examineeSubject.getBuilding());
        RoadKey roadKey = new RoadKey();
        roadKey.setPbuilding(examineeSubject.getBuilding());
        roadKey.setPname(examineeSubject.getRoom().toString());
        Integer roomNumber = keyPointService.getNumberById(roadKey);
        return Msg.success().add("examineeSubject", examineeSubject).add("bnumber", bnumber).add("roomNumber", roomNumber);
    }

    @ResponseBody
    @RequestMapping(value = "/getBySubject/{id}", method = RequestMethod.GET)
    public Msg getBySubject(@PathVariable("id") Integer id){
        List<ExamineeSubject> examineeSubjects = examineeSubjectService.getBySubject(id);
        return Msg.success().add("examineeSubjects", examineeSubjects);
    }

    @ResponseBody
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Msg getByEId(@PathVariable("id") Integer id){
        List<ExamineeSubject> examineeSubjects = examineeSubjectService.getByExaminee(id);
        if(examineeSubjects.isEmpty()) {
            return Msg.success().add("info", "No subjects.");
        }
        return Msg.success().add("examineeSubjects", examineeSubjects);
    }

    @ResponseBody
    @RequestMapping(value = "/getByAcc/{acc}", method = RequestMethod.GET)
    public Msg getByEid(@PathVariable("acc") String acc){
        Examinee examinee = examineeService.getByAcc(acc);
        if(null == examinee) {
            return Msg.fail().add("info", "Wrong account, please login again.");
        }
        List<ExamineeSubject> examineeSubjects = examineeSubjectService.getByExaminee(examinee.getId());
        if(null == examineeSubjects) {
            return Msg.fail().add("info", "Sorry, there is no info in this account.");
        }
        return Msg.success().add("examinee", examinee).add("examineeSubjects", examineeSubjects);
    }

    @ResponseBody
    @RequestMapping(value = "/getNextSubject/{acc}", method = RequestMethod.GET)
    public Msg getNextSubject(@PathVariable("acc") String acc){
        Examinee examinee = examineeService.getByAcc(acc);
        if(null == examinee) {
            return Msg.fail().add("info", "Wrong account, please login again.");
        }
        List<ExamineeSubject> examineeSubjects = examineeSubjectService.getByExaminee(examinee.getId());
        if(null == examineeSubjects) {
            return Msg.fail().add("info", "Sorry, there is no info in this account.");
        }
        Date date = new Date();
        long d1 = date.getTime();
        long d3 = -1;
        ExamineeSubject nextEs = null;
        for(ExamineeSubject es : examineeSubjects){
            long d2 = es.getS().getStartTime().getTime();
            if(d3<0) {
                d3 = d2 - d1;
                if(d3>0){
                    nextEs = es;
                }
            }else{
                if(d3>d2-d1 && d2-d1>0){
                    d3 = d2 - d1;
                    nextEs = es;
                }
            }
        }
        if(d3 < 0){
            return Msg.fail().add("info", "no next subject exist!");
        }
        RoadKey roadKey = new RoadKey();
        roadKey.setPname("" + nextEs.getRoom());
        roadKey.setPbuilding(nextEs.getBuilding());
        KeyPoint keyPoint = keyPointService.getByBuildingAndName(roadKey);
        Position position = new Position();
        position.setX(keyPoint.getX());
        position.setY(keyPoint.getY());
        position.setZ(keyPoint.getZ());
        return Msg.success().add("nextEs", nextEs).add("position", position);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
    public Msg delete(@PathVariable("id") Integer id){
        ExamineeSubjectExample examineeSubjectExample = new ExamineeSubjectExample();
        ExamineeSubjectExample.Criteria criteria = examineeSubjectExample.createCriteria();
        criteria.andIdEqualTo(id);
        examineeSubjectService.deleteByExaminee(examineeSubjectExample);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg add(ExamineeSubject examineeSubject){
        ExamineeSubjectExample examineeSubjectExample = new ExamineeSubjectExample();
        ExamineeSubjectExample.Criteria criteria = examineeSubjectExample.createCriteria();
        criteria.andEidEqualTo(examineeSubject.getEid());
        criteria.andSubjectEqualTo(examineeSubject.getSubject());
        List<ExamineeSubject> examineeSubjects = examineeSubjectService.getByExample(examineeSubjectExample);
        if(!examineeSubjects.isEmpty()){
            return Msg.fail().add("info", "该科目内已包含该考生");
        }
        examineeSubjectService.add(examineeSubject);
        return Msg.success();
    }
}

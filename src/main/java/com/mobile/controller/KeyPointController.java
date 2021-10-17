package com.mobile.controller;

import com.mobile.bean.KeyPoint;
import com.mobile.bean.KeyPointExample;
import com.mobile.bean.Msg;
import com.mobile.service.KeyPointService;
import com.mobile.view.KeyPointView;
import com.mobile.view.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/27 16:26
 */
@Controller
@CrossOrigin
@RequestMapping("/keyPoint")
public class KeyPointController {

    @Autowired
    KeyPointService keyPointService;

    @ResponseBody
    @RequestMapping(value = "/getByBuilding/{id}", method = RequestMethod.GET)
    public Msg getRoomsByBuilding(@PathVariable("id") Integer id){
        List<KeyPoint> keyPoints = keyPointService.getByBuilding(id);
        return Msg.success().add("keyPoints", keyPoints);
    }

    @ResponseBody
    @RequestMapping(value = "/getByBuildingDestination/{id}", method = RequestMethod.GET)
    public Msg getByBuildingDestination(@PathVariable("id") Integer id){
        KeyPointExample keyPointExample = new KeyPointExample();
        KeyPointExample.Criteria criteria = keyPointExample.createCriteria();
        criteria.andPbuildingEqualTo(id);
        criteria.andPtypeEqualTo(0);
        List<KeyPoint> keyPoints = keyPointService.getListByExample(keyPointExample);
        return Msg.success().add("keyPoints",keyPoints);

    }

    /**
     * unity调用
     * 获取场景下的所有关键点
     * @param ssmap
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBySSMap/{ssmap}", method = RequestMethod.GET)
    public List<KeyPointView> getByBName(@PathVariable("ssmap") String ssmap){
        List<KeyPoint> keyPoints = keyPointService.getBySSMap(ssmap);
        List<KeyPointView> keyPointViews = new ArrayList<>();
        for(KeyPoint kp : keyPoints){
            KeyPointView kpv = new KeyPointView();
            kpv.setName(kp.getPname());
            kpv.setPointType(kp.getPtype());
            Position position = new Position();
            position.setX(kp.getX());
            position.setY(kp.getY());
            position.setZ(kp.getZ());
            kpv.setPosition(position);
            keyPointViews.add(kpv);
        }
        return keyPointViews;
    }

    /**
     * 添加关键点
     * @param keyPoint
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg getByBName(KeyPoint keyPoint){
        keyPointService.addKeyPoint(keyPoint);
        return Msg.success();
    }

    /**
     * 删除关键点
     * @param keyPoint
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Msg delByExample(KeyPoint keyPoint){
        KeyPointExample keyPointExample = new KeyPointExample();
        KeyPointExample.Criteria criteria = keyPointExample.createCriteria();
        criteria.andPnameEqualTo(keyPoint.getPname());
        criteria.andPbuildingEqualTo(keyPoint.getPbuilding());
        keyPointService.delKeyPoint(keyPointExample);
        return Msg.success();
    }

}

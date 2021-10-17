package com.mobile.controller;

import com.mobile.bean.*;
import com.mobile.service.BuildingService;
import com.mobile.service.KeyPointService;
import com.mobile.service.RoadService;
import com.mobile.view.Position;
import com.mobile.view.RoadKey;
import com.mobile.view.RoadView;
import com.sun.deploy.security.MSCryptoDSASignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/27 22:41
 */
@Controller
@CrossOrigin
@RequestMapping("/road")
public class RoadController {

    @Autowired
    RoadService roadService;
    @Autowired
    KeyPointService keyPointService;
    @Autowired
    BuildingService buildingService;

    /**
     * 获取一个场景下的所有路径
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getByBName/{name}", method = RequestMethod.GET)
    public Msg getByBName(@PathVariable("name") String name){
        List<Road> roads = roadService.getByBName(name);
        return Msg.success().add("roads", roads);
    }

    /**
     * 添加路径
     * @param road
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg add(Road road){
        KeyPoint startKP = keyPointService.getById(road.getStartPk());
        KeyPoint endKP = keyPointService.getById(road.getEndPk());
        if(null == startKP){
            return Msg.fail().add("info", "Start key point do not exist");
        }
        if(null == endKP){
            return Msg.fail().add("info", "End key point do not exist");
        }
        if(!startKP.getPbuilding().equals(endKP.getPbuilding())){
            return Msg.fail().add("info", "Start and end key point should belong to one building");
        }
        roadService.add(road);
        return Msg.success();
    }


    /**
     * unity调用
     * 添加路径
     * @param roadView
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/unityAdd/{ssmap}", method = RequestMethod.POST)
    public Msg addByUnity(@PathVariable("ssmap") String ssmap, RoadView roadView){
        Road road = new Road();
        // 楼id
        Integer bid = buildingService.getBySSMap(ssmap).getId();
        // 起始点
        RoadKey startKey = new RoadKey();
        startKey.setPbuilding(bid);
        startKey.setPname(roadView.getStartName());
        // 终点
        RoadKey endKey = new RoadKey();
        endKey.setPbuilding(bid);
        endKey.setPname(roadView.getEndName());
        // 获取起终点id
        Integer startKP = keyPointService.getByBuildingAndName(startKey).getId();
        Integer endKP = keyPointService.getByBuildingAndName(endKey).getId();
        road.setRbuilding(bid);
        road.setStartPk(startKP);
        road.setEndPk(endKP);
        if(null == startKP){
            return Msg.fail().add("info", "Start key point do not exist");
        }
        if(null == endKP){
            return Msg.fail().add("info", "End key point do not exist");
        }
        roadService.add(road);
        return Msg.success();
    }


    /**
     * unity调用
     * 获取一个场景下的所有路径
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/unityGetByBName/{name}", method = RequestMethod.GET)
    public List<RoadView> unityGetByBName(@PathVariable("name") String name){
        List<Road> roads = roadService.getByBName(name);
        List<RoadView> roadViews = new ArrayList<>();
        for(Road r : roads){
            RoadView rv = new RoadView();
            rv.setStartName(r.getStartKeyPoint().getPname());
            rv.setEndName(r.getEndKeyPoint().getPname());
            Position sp = new Position();
            sp.setX(r.getStartKeyPoint().getX());
            sp.setY(r.getStartKeyPoint().getY());
            sp.setZ(r.getStartKeyPoint().getZ());
            Position ep = new Position();
            ep.setX(r.getEndKeyPoint().getX());
            ep.setY(r.getEndKeyPoint().getY());
            ep.setZ(r.getEndKeyPoint().getZ());
            rv.setStartPosition(sp);
            rv.setEndPosition(ep);
            roadViews.add(rv);
        }
        return roadViews;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{ssmap}/{road}", method = RequestMethod.POST)
    public Msg delByExample(@PathVariable("ssmap") String ssmap, @PathVariable("road") String road){
        String[] kps = road.split("<===>");
        Building building = buildingService.getBySSMap(ssmap);
        // 起始点
        RoadKey srk = new RoadKey();
        srk.setPname(kps[0]);
        srk.setPbuilding(building.getId());
        Integer spId = keyPointService.getByBuildingAndName(srk).getId();
        // 结束点
        RoadKey erk = new RoadKey();
        erk.setPname(kps[1]);
        erk.setPbuilding(building.getId());
        Integer epId = keyPointService.getByBuildingAndName(erk).getId();


        RoadExample roadExample = new RoadExample();
        RoadExample.Criteria criteria = roadExample.createCriteria();
        criteria.andStartPkEqualTo(spId);
        criteria.andEndPkEqualTo(epId);
        roadService.delByExample(roadExample);
        return Msg.success();
    }

}

package com.mobile.controller;

import com.mobile.bean.Building;
import com.mobile.bean.Msg;
import com.mobile.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: chenzhe
 * @date: 2021/4/27 2:10
 */
@Controller
@CrossOrigin
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @ResponseBody
    @RequestMapping(value = "/allBuilding", method = RequestMethod.GET)
    public Msg getAll(){
        List<Building> buildings = buildingService.getAll();
        return Msg.success().add("buildings", buildings);
    }

    @ResponseBody
    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public Msg getByName(@PathVariable("name") String name){
        Building building = buildingService.getByName(name);
        return Msg.success().add("buildings", building);
    }

    @ResponseBody
    @RequestMapping(value = "/getBySSMap/{ssmap}", method = RequestMethod.GET)
    public int getIdByName(@PathVariable("ssmap") String ssmap){
        Building building = buildingService.getBySSMap(ssmap);
        return building.getId();
    }

    @ResponseBody
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Msg getById(@PathVariable("id") Integer id){
        Building building = buildingService.getById(id);
        return Msg.success().add("buildings", building);
    }

    /**
     * 添加场景
     * @param building
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Msg add(Building building){
        buildingService.add(building);
        return Msg.success();
    }


    @ResponseBody
    @RequestMapping(value = "/updatePosition", method = RequestMethod.POST)
    public Msg updatePosition(Building building){
        buildingService.update(building);
        return Msg.success();
    }

}

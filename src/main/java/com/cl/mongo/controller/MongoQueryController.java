package com.cl.mongo.controller;

import com.cl.mongo.query.AtmMongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class MongoQueryController {

    @Autowired
    private AtmMongoServiceImpl atmMongoServiceImpl;

    @RequestMapping("/query")
    public List query(@RequestParam("startDate")Date startDate, @RequestParam("endDate")Date endDate, @RequestParam("devId")String devId){
        return atmMongoServiceImpl.query(startDate,endDate,devId);
    }

}

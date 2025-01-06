package com.cl.mongo.controller;

import cn.hutool.core.date.DateUtil;
import com.cl.mongo.query.AtmMongoServiceImpl;
import com.cl.mongo.query.DisplayRet;
import com.cl.mongo.query.DisplayRetRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MongoQueryController {

    @Autowired
    private AtmMongoServiceImpl atmMongoServiceImpl;

    @RequestMapping(value="/query", method = RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public List<DisplayRetRsp> query(@RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, @RequestParam("devId")String devId){
        Date start = DateUtil.parse(startDate,"yyyy-MM-dd HH:mm:ss");
        Date end = DateUtil.parse(endDate,"yyyy-MM-dd HH:mm:ss");
        return atmMongoServiceImpl.query(start,end,devId);
    }

}

package com.cl.mongo.query;

import cn.hutool.core.date.DateUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AtmMongoServiceImpl {

    @Resource(name="mongoTemplate")
    private MongoTemplate mongoTemplate;

    public List<DisplayRetRsp> query(Date startDate, Date endDate, String deviceId){
        Query query = new Query();
        query.addCriteria(Criteria.where("dataTime").gte(startDate).lt(endDate));
        if (deviceId != null && !"".equals(deviceId)) {
            query.addCriteria(Criteria.where("devId").is(deviceId));
        }
//        query.with(new Sort(Direction.ASC, new String[]{"dataTime"}));
//        query.with(new Sort(new Sort.Order(Direction.ASC,"dataTime")));
        List<FiveData> devicelist = this.mongoTemplate.find(query, FiveData.class, "iot_display_data");
        List<DisplayRetRsp> result = new ArrayList<>();
        for (FiveData displayRet : devicelist) {
            DisplayRetRsp displayRetRsp = new DisplayRetRsp();
            displayRetRsp.setDataTime(DateUtil.format(displayRet.getDataTime(),"yyyy-MM-dd HH:mm:ss"));
            displayRetRsp.setRecvTime(DateUtil.format(displayRet.getRecvTime(),"yyyy-MM-dd HH:mm:ss"));
            displayRetRsp.setItems(displayRet.getItems());
            displayRetRsp.setDevId(displayRet.getDevId());
            displayRetRsp.setDevCode(displayRet.getDevCode());
            result.add(displayRetRsp);
        }
        return result;
    }

}

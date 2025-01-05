package com.cl.mongo.query;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AtmMongoServiceImpl {

    @Resource(name="mongoTemplate")
    private MongoTemplate mongoTemplate;

    public List<Map<String, Object>> query(Date startDate, Date endDate, String deviceId){
        Query query = new Query();
        query.addCriteria(Criteria.where("dataTime").gte(startDate).lt(endDate));
        if (deviceId != null && !"".equals(deviceId)) {
            query.addCriteria(Criteria.where("devId").is(deviceId));
        }
//        query.with(new Sort(Direction.ASC, new String[]{"dataTime"}));
//        query.with(new Sort(new Sort.Order(Direction.ASC,"dataTime")));
        List devicelist = this.mongoTemplate.find(query, DisplayRet.class, "iot_display_data");
        return devicelist;
    }

}

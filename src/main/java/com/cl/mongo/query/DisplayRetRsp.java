package com.cl.mongo.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class DisplayRetRsp {
    private String dataTime;
    private String recvTime;
    private String devId;

    private String devCode;
    private List<Item> items = new ArrayList();
}

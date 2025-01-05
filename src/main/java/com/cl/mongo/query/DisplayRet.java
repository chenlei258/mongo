package com.cl.mongo.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class DisplayRet {
    private Date dataTime;
    private Date recvTime;
    private List<Item> items = new ArrayList();
}

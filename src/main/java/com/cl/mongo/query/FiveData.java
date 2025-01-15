package com.cl.mongo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 五分钟数据-接收采集接口返回数据
 *
 * @author luozy
 * @date 2022/5/31
 */
@Data
public class FiveData implements Serializable {

  private static final long serialVersionUID = 1L;

  private String devId;

  private String devCode;

  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date dataTime;

  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date recvTime;

  private List<Item> items;
}

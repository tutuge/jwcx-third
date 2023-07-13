package com.jwcx.third.controller.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "我的订单查询实体")
public class MyOrderQo {

    @Schema(description = "页码")
    private Integer pageNum;

    @Schema(description = "每页条数")
    private Integer pageSize;

    @Schema(description = "乘客姓名或手机号")
    private String passenger;

    @Schema(description = "订单状态")
    private List<Integer> orderStatus;

    @Schema(description = "下单方式")
    private List<Integer> orderMode;

    @Schema(description = "订单类型")
    private List<Integer> orderType;

    @Schema(description = "最低价格")
    private BigDecimal lowPrice;

    @Schema(description = "最高价格")
    private BigDecimal highPrice;

}

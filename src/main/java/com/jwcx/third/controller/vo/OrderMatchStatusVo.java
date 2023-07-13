package com.jwcx.third.controller.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderMatchStatusVo {

    @Schema(description = "订单匹配状态，0：未匹配，1：已匹配")
    private String status;

    @Schema(description = "订单匹配时间")
    private String matchTime;

    @Schema(description = "司机信息")
    private DriverInfoVo driverInfoVo;

}

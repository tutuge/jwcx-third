package com.jwcx.third.controller.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class OrderMatchStatusVo {

    @Schema(description = "订单匹配状态，0：未匹配，1：已匹配")
    private Integer status;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "订单匹配时间")
    private Date matchTime;

    @Schema(description = "司机信息")
    private DriverInfoVo driverInfoVo;

}

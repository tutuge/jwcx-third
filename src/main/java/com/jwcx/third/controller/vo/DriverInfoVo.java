package com.jwcx.third.controller.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DriverInfoVo {

    @Schema(description = "司机头像")
    private String avatar;

    @Schema(description = "司机姓名")
    private String driverName;

    @Schema(description = "总计接的订单数量")
    private Long orderCount;

    @Schema(description = "总计完成的订单数量")
    private Long orderCompleteCount;

    @Schema(description = "司机评分")
    private Integer evaluate;

    @Schema(description = "手机号码")
    private String phone;
}

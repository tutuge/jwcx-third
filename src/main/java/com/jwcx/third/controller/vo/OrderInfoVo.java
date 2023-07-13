package com.jwcx.third.controller.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author wangbin
 */
@Data
@Schema(description = "订单的详情")
public class OrderInfoVo {

    @Schema(description = "订单ID")
    private Long id;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "下单方式")
    private Integer orderMode;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "下单时间")
    private Date createTime;

    @Schema(description = "起点")
    private String departure;

    @Schema(description = "终点")
    private String destination;

    @Schema(description = "乘车人名字")
    private String passengerName;

    @Schema(description = "乘车人电话")
    private String passengerPhone;

    @Schema(description = "乘车人数")
    private Integer personNumber;

    @Schema(description = "起点 出发地点的经纬度")
    private String startPoint;

    @Schema(description = "终点 目的地的经纬度")
    private String endPoint;

    @Schema(description = "订单状态")
    private Integer orderStatus;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "预约时间")
    private Date appointmentTime;

    @Schema(description = "订单类型，1：快车，2：拼车，3：包车")
    private Integer orderType;

    @Schema(description = "用户电话")
    private String mobile;

    @Schema(description = "用户头像")
    private String picUrl;

    @Schema(description = "司机信息")
    private DriverInfoVo driverVo;

}

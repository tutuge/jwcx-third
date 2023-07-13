package com.jwcx.third.controller.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static com.jwcx.third.utils.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 订单 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class OrderBaseVO {

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "订单创建人，因为可以代人下单，所以创建人跟乘客不是一回事")
    private Long createOrderUserId;

    @Schema(description = "乘客id或者说下单人id", required = true)
    private Long passengerId;

    @Schema(description = "乘车人名字")
    private String passengerName;

    @Schema(description = "乘车人电话--不传就是自己，代客下单需要传手机号")
    private String passengerPhone;

    @Schema(description = "司机id")
    private Long driverId;

    @Schema(description = "税号", required = true)
    private String dutyParagraph;

    @Schema(description = "车辆id")
    private Long carId;

    @Schema(description = "车牌号")
    private String licensePlateNumber;

    @Schema(description = "预计出发地点详细地址--传名称")
    private String departure;

    @Schema(description = "预计到达地点详细地址--传名称")
    private String destination;

    @Schema(description = "坐标加密标识 1Gcj-02测绘局标准 2wgs84gps标准 3bd-09百度标准 4cgcs2000北斗标准 0其他")
    private Integer encrypt;

    @Schema(description = "运价类型编码")
    private String fareType;

    /**
     * 上报行政区划代码(见GB/T2260)
     */
    @Schema(description = "上报行政区划代码", required = true)
    @NotNull(message = "上报行政区划代码不能为空")
    private Integer reportRegionalismCode;

    @Schema(description = "起点 出发地点的经纬度", required = true)
    @NotNull(message = "出发地点的经纬度不能为空")
    private String startPoint;

    @Schema(description = "目的地 目的地的经纬度", required = true)
    private String endPoint;

    @Schema(description = "人数", required = true)
    @NotNull(message = "人数不能为空")
    private Integer personNumber;

    @Schema(description = "订单状态")
    private Integer orderStatus;

    @Schema(description = "订单金额")
    @NotNull(message = "订单金额不得为空")
    private BigDecimal amount;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "下单时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date orderTime;

    @Schema(description = "上车时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date depTime;

    @Schema(description = "下车时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date destTime;

    @Schema(description = "支付时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date paymentTime;

    @Schema(description = "预约时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date appointmentTime;

    @Schema(description = "支付状态")
    private Integer paymentStatus;

    @Schema(description = "下单方式，1：自助下单，2：代客下单，3：他人代下")
    private Integer orderMode;

    @Schema(description = "支付方式")
    private Integer paymentMode;

    @Schema(description = "乘客备注")
    private String remark;

    @Schema(description = "是否使用现金支付")
    @NotNull(message = "是否使用现金支付不得为空")
    private Boolean cash;

    @Schema(description = "是否已开票")
    private Boolean invoicing;

    @Schema(description = "是否已评价")
    private Boolean evaluate;

    @Schema(description = "行程ID")
    private Long tripId;

    @Schema(description = "订单类型，1：快车，2：拼车，3：包车")
    private Integer orderType;

    @Schema(description = "距离(米)")
    private BigDecimal distance;

    @Schema(description = "调度端ID")
    private Long tenantId;

    @Schema(description = "线路ID")
    private Long lineId;

    @Schema(description = "司机码")
    private Integer driverCode;

}

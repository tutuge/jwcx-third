package com.jwcx.third.controller.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.StringJoiner;

/**
 * 订单 DO
 *
 * 
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDO extends TenantBaseDO {

    private static final long serialVersionUID = -6123837595785359151L;
    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单创建人，因为可以代人下单，所以创建人跟乘客不是一回事
     */
    private Long createOrderUserId;
    /**
     * 乘客id或者说下单人id
     */
    private Long passengerId;
    /**
     * 乘车人名字
     */
    private String passengerName;

    /**
     * 用户头像
     */
    private String picUrl;

    /**
     * 乘车人电话
     */
    private String passengerPhone;
    /**
     * 司机id
     */
    private Long driverId;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机码
     */
    private Integer driverCode;
    /**
     * 税号
     */
    private String dutyParagraph;
    /**
     * 车辆id
     */
    private Long carId;
    /**
     * 车牌号
     */
    private String licensePlateNumber;
    /**
     * 预计出发地点详细地址
     */
    private String departure;
    /**
     * 预计到达地点详细地址
     */
    private String destination;
    /**
     * 坐标加密标识 1Gcj-02测绘局标准 2wgs84gps标准 3bd-09百度标准 4cgcs2000北斗标准 0其他
     */
    private Integer encrypt;
    /**
     * 运价类型编码
     */
    private String fareType;
    /**
     * 上报行政区划代码
     */
    private Integer reportRegionalismCode;
    /**
     * 起点 出发地点的经纬度
     * 前面是纬度 后面的经度
     */
    private String startPoint;
    /**
     * 目的地 目的地的经纬度
     * 前面是纬度 后面的经度
     */
    private String endPoint;
    /**
     * 乘客人数
     */
    private Integer personNumber;
    /**
     * 订单状态 1 已下单 2 已派单 3接客中
     */
    private Integer orderStatus;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    /**
     * 下单时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
    /**
     * 下单月份
     */
    private Integer orderMonth;
    /**
     * 司机去接乘客的时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transferTime;
    /**
     * 上车时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date depTime;
    /**
     * 下车时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date destTime;
    /**
     * 支付时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /**
     * 是否是预约订单， true是预约 false不是预约订单
     */
    private Boolean appointment;
    /**
     * 预约时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentTime;
    /**
     * 支付状态 0是未支付，1是已支付 2是已退款
     */
    private Integer paymentStatus;
    /**
     * 下单方式，1：自助下单，2：代客下单，3：他人代下
     */
    private Integer orderMode;
    /**
     * 支付方式
     */
    private Integer paymentMode;
    /**
     * 乘客备注
     */
    private String remark;
    /**
     * 是否使用现金支付
     */
    private Boolean cash;
    /**
     * 是否已开票
     */
    private Boolean invoicing;
    /**
     * 是否已评价
     */
    private Boolean evaluate;
    /**
     * 行程ID
     */
    private Long tripId;
    /**
     * 订单类型，1：快车，2：拼车，3：包车
     */
    private Integer orderType;
    /**
     * 距离(米)
     */
    private BigDecimal distance;
    /**
     * 订单来源，1：平台订单，2：三方订单
     */
    private String fromType;
    /**
     * 线路id
     */
    private Long lineId;
    /**
     * 匹配方式
     */
    private Integer matchType;
    /**
     * 司机端申请调度或者取消的理由
     */
    private String reason;
    /**
     * 司机端当前的位置坐标
     */
    private String coordinate;
    /**
     * 司机端当前位置描述
     */
    private String position;
    /**
     * 记录申请调度或者申请取消之前的状态
     */
    private Integer oldStatus;

    /**
     * 是否是第三方订单
     */
    private Boolean third;


    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("orderNo='" + orderNo + "'")
                .add("createOrderUserId=" + createOrderUserId)
                .add("passengerId=" + passengerId)
                .add("passengerName='" + passengerName + "'")
                .add("passengerPhone='" + passengerPhone + "'")
                .add("driverId=" + driverId)
                .add("dutyParagraph='" + dutyParagraph + "'")
                .add("carId=" + carId)
                .add("licensePlateNumber='" + licensePlateNumber + "'")
                .add("departure='" + departure + "'")
                .add("destination='" + destination + "'")
                .add("encrypt=" + encrypt)
                .add("fareType='" + fareType + "'")
                .add("startPoint='" + startPoint + "'")
                .add("endPoint='" + endPoint + "'")
                .add("personNumber=" + personNumber)
                .add("orderStatus=" + orderStatus)
                .add("amount=" + amount)
                .add("orderTime=" + orderTime)
                .add("depTime=" + depTime)
                .add("destTime=" + destTime)
                .add("paymentTime=" + paymentTime)
                .add("appointmentTime=" + appointmentTime)
                .add("paymentStatus=" + paymentStatus)
                .add("orderMode=" + orderMode)
                .add("paymentMode=" + paymentMode)
                .add("remark='" + remark + "'")
                .add("cash=" + cash)
                .add("invoicing=" + invoicing)
                .add("evaluate=" + evaluate)
                .add("tripId=" + tripId)
                .add("orderType=" + orderType)
                .add("distance=" + distance)
                .add("fromType='" + fromType + "'")
                .toString();
    }
}

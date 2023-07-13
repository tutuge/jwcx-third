package com.jwcx.third.controller.bo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.math.BigDecimal;

/**
 * 订单计费明细 DO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderChargingDO extends TenantBaseDO {

    private static final long serialVersionUID = -7683951493555754280L;
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 计费类型 1 信息费 2 司机的钱 3 总后台佣金 4 调度端佣金
     */
    private Integer payType;

    /**
     * 选择哪种抽佣方式 0是按单 1是按比例
     */
    private Integer useType;
    /**
     * 抽佣设置的数值
     */
    private BigDecimal commissionValue;
    /**
     * 计费价格
     */
    private BigDecimal price;
    /**
     * 原来的计费价格，为的是能够和快车最初计算的价格做个对比
     */
    private BigDecimal originalPrice;
    /**
     * 计费描述
     */
    private String priceDesc;
    /**
     * 乘客备注
     */
    private String remark;
    /**
     * 是否已经支付
     */
    private Boolean paid;
    /**
     * 支付者的用户类型
     */
    private Integer userType;
    /**
     * 支付者的id
     */
    private Long userId;
}

package com.jwcx.third.controller.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 增加了经纬度解析的bo类型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderBo extends OrderDO {
    private static final long serialVersionUID = 3522381826926956496L;
    /**
     * 开始经纬度数组
     */
    private Double[] startPointArray;
    /**
     * 结束经纬度数组
     */
    private Double[] endPointArray;

    //--------------------下面是下单的乘客信息---------------------
    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 手机
     */
    private String mobile;

    //--------------------上面是下单的乘客信息---------------------
    /**
     * 订单的金额明细信息
     */
    private List<OrderChargingDO> chargingList;
}

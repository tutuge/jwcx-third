package com.jwcx.third.controller;

import com.jwcx.third.controller.bo.TravelModeQo;
import com.jwcx.third.rest.RequestService;
import com.jwcx.third.utils.SignUtil;
import com.jwcx.third.utils.json.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 请求示例
 *
 * @author wangbin
 */
@RestController
@RequestMapping("/third")
public class RequestController {

    @Value("${third.appId}")
    private String appId;

    @Value("${third.appSecret}")
    private String appSecret;

    @Value("${third.url}")
    private String url;
    @Resource
    private RequestService requestService;

    /**
     * 代客下单获取出行方式
     *
     * @param travelModeQo 查询参数
     * @return 查询结果
     */
    @PostMapping("/getTravelMode")
    public void getTravelModeByUser(@RequestBody @Validated TravelModeQo travelModeQo) {
        String send = url + "getTravelMode";
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String sign = SignUtil.sign(appId, appSecret, timestamp, JsonUtils.toJsonString(travelModeQo), null, null);
        requestService.getTravelModeByUser(send, appId, appSecret, sign, timestamp, travelModeQo);
    }


//    /**
//     * 第三方代客下单至少需要20秒才能下一个新的
//     *
//     * @param orderCreate 订单创建信息
//     * @return 创建是否成功
//     */
//    @PermitAll
//    @Idempotent(timeout = 20)
//    @PostMapping("/createMemberOrder")
//    @Operation(summary = "调度端代客下单")
//    public CommonResult<?> createMemberOrder(@Valid @RequestBody OrderCreateReqVO orderCreate) {
//        orderCreate.setThird(true);
//        CommonResult<?> orderMem = memberOrderApi.createOrderMem(orderCreate);
//        orderMem.checkError();
//        return success();
//    }
//
//
//    /**
//     * 第三方代客下单至少需要20秒才能下一个新的
//     *
//     * @param cancelOrderVo 订单取消信息
//     * @return 取消是否成功
//     */
//    @PermitAll
//    @Idempotent(timeout = 20)
//    @PostMapping("/cancelMemberOrder")
//    @Operation(summary = "第三方取消订单")
//    public CommonResult<?> cancelMemberOrder(@Valid @RequestBody CancelOrderVo cancelOrderVo) {
//        cancelOrderVo.setThird(true);
//        CommonResult<Boolean> booleanCommonResult = memberOrderApi.cancelOrderMem(cancelOrderVo);
//        booleanCommonResult.checkError();
//        return success();
//    }
//
//    /**
//     * 根据订单id获取司机位置
//     */
//    @PermitAll
//    @GetMapping("/getDriverLocation/{id}")
//    @Operation(summary = "第三方取消订单")
//    public CommonResult<?> getDriverLocation(@PathVariable("id") Long id) {
//        Long thirdId = RequestHeaderUtil.getThirdId();
//        OrderDO byId = orderService.getById(id, thirdId);
//        if (ObjUtil.isNotNull(byId)) {
//            Long driverId = byId.getDriverId();
//            String tempKey = WS_SET_ALL_POINT_KEY + DRIVER.getValue() + ":" + driverId;
//            //前纬后经
//            LocationBo o = RedisUtils.getCacheObject(tempKey);
//            return success(o);
//        } else {
//            throw new RuntimeException("未找到对应的司机");
//        }
//    }
//
//    @PermitAll
//    @GetMapping("/queryOrderMatchStatus/{id}")
//    @Operation(summary = "主动查询订单的匹配状态")
//    public CommonResult<OrderMatchStatusVo> queryOrderMatchStatus(@PathVariable("id") Long id) {
//        OrderMatchStatusVo orderMatchStatusVo = new OrderMatchStatusVo();
//        Long thirdId = RequestHeaderUtil.getThirdId();
//        OrderDO orderDO = orderService.getById(id, thirdId);
//        if (orderDO.getOrderStatus() == 1) {
//            orderMatchStatusVo.setStatus("0");
//        } else {
//            orderMatchStatusVo.setStatus("1");
//        }
//        Date transferTime = orderDO.getTransferTime();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        if (transferTime != null) {
//            orderMatchStatusVo.setMatchTime(simpleDateFormat.format(transferTime));
//        }
//        //获取司机信息
//        Long driverId = orderDO.getDriverId();
//        DriverDO driverDO = driverService.getById(driverId);
//        DriverInfoVo driverInfoVo = new DriverInfoVo();
//        BeanUtils.copyProperties(driverDO, driverInfoVo);
//        orderMatchStatusVo.setDriverInfoVo(driverInfoVo);
//        return CommonResult.success(orderMatchStatusVo);
//    }
//
//    @PermitAll
//    @GetMapping("/getOrderInfo/{id}")
//    @Operation(summary = "获取订单详情")
//    public CommonResult<OrderInfoVo> getOrderInfo(@PathVariable("id") Long id) {
//        OrderInfoVo orderInfoVo = new OrderInfoVo();
//        Long thirdId = RequestHeaderUtil.getThirdId();
//        OrderDO orderDO = orderService.getById(id, thirdId);
//        BeanUtils.copyProperties(orderDO, orderInfoVo);
//        Long driverId = orderDO.getDriverId();
//        DriverDO driverDO = driverService.getById(driverId);
//        DriverInfoVo driverInfoVo = new DriverInfoVo();
//        BeanUtils.copyProperties(driverDO, driverInfoVo);
//        orderInfoVo.setDriverVo(driverInfoVo);
//        return CommonResult.success(orderInfoVo);
//    }
//
//    @PermitAll
//    @PostMapping("/queryOrderList")
//    @Operation(summary = "获取订单列表")
//    public CommonResult<Page<OrderBo>> getOrderList(@RequestBody MyOrderQo myOrderQo) {
//        Page<OrderDO> page = new Page<>(myOrderQo.getPageNum(), myOrderQo.getPageSize());
//        //勾选的订单状态
//        boolean orderStatusQueryArg = myOrderQo.getOrderStatus() != null && myOrderQo.getOrderStatus().size() > 0;
//        Long thirdId = RequestHeaderUtil.getThirdId();
//        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
//                .eq(OrderDO::getThird, thirdId)
//                .and(StringUtils.isNotBlank(myOrderQo.getPassenger()),
//                        wrapper -> wrapper.like(OrderDO::getPassengerName, myOrderQo.getPassenger()).
//                                or().like(OrderDO::getPassengerPhone, myOrderQo.getPassenger()))
//                .in(orderStatusQueryArg, OrderDO::getOrderStatus, myOrderQo.getOrderStatus())
//                .ge(myOrderQo.getLowPrice() != null, OrderDO::getAmount, myOrderQo.getLowPrice())
//                .le(myOrderQo.getHighPrice() != null, OrderDO::getAmount, myOrderQo.getHighPrice())
//                .orderBy(true, false, OrderDO::getCreateTime);
//        Page<OrderDO> orderDOPage = orderService.page(page, queryWrapper);
//        Page<OrderBo> orderBoPage = new Page<>();
//        orderBoPage.setPages(orderDOPage.getPages());
//        orderBoPage.setCurrent(orderDOPage.getCurrent());
//        orderBoPage.setTotal(orderDOPage.getTotal());
//        orderBoPage.setSize(orderDOPage.getSize());
//        List<OrderBo> list = new ArrayList<>();
//        for (OrderDO orderDO : orderDOPage.getRecords()) {
//            OrderBo orderBo = new OrderBo();
//            BeanUtils.copyProperties(orderDO, orderBo);
//            orderBo.setMobile(orderDO.getPassengerPhone());
//            orderBo.setAvatar(orderDO.getPicUrl());
//            orderBo.setNickname(orderDO.getPassengerName());
//            list.add(orderBo);
//        }
//        orderBoPage.setRecords(list);
//        return CommonResult.success(orderBoPage);
//    }

}

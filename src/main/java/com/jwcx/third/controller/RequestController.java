package com.jwcx.third.controller;

import com.jwcx.third.controller.bo.TravelModeQo;
import com.jwcx.third.controller.vo.*;
import com.jwcx.third.domain.CommonResult;
import com.jwcx.third.rest.RequestService;
import com.jwcx.third.utils.SignUtil;
import com.jwcx.third.utils.json.JsonUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

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
    public CommonResult<List<TravelModeApiVo>> getTravelModeByUser(@RequestBody @Validated TravelModeQo travelModeQo) {
        String send = url + "getTravelMode";
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String sign = SignUtil.sign(appId, appSecret, timestamp, JsonUtils.toJsonString(travelModeQo), null, null);
        CommonResult<List<TravelModeApiVo>> travelModeByUser = requestService.getTravelModeByUser(send, appId, appSecret, sign, timestamp, travelModeQo);
        return travelModeByUser;
    }


    /**
     * 下单
     *
     * @param orderCreate 订单创建信息
     * @return 创建是否成功
     */
    @PostMapping("/createMemberOrder")
    @Operation(summary = "下单")
    public CommonResult<?> createMemberOrder(@Valid @RequestBody OrderCreateReqVO orderCreate) {
        orderCreate.setThird(true);
        //第三方默认都是现金结算
        orderCreate.setCash(true);
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String sign = SignUtil.sign(appId, appSecret, timestamp, JsonUtils.toJsonString(orderCreate), null, null);
        String send = url + "createMemberOrder";
        CommonResult<?> memberOrder = requestService.createMemberOrder(send, appId, appSecret, sign, timestamp, orderCreate);
        return memberOrder;
    }


    /**
     * 取消信息
     *
     * @param cancelOrderVo 订单取消信息
     * @return 取消是否成功
     */
    @PostMapping("/cancelMemberOrder")
    @Operation(summary = "第三方取消订单")
    public CommonResult<Boolean> cancelMemberOrder(@Valid @RequestBody CancelOrderVo cancelOrderVo) {
        cancelOrderVo.setThird(true);
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String sign = SignUtil.sign(appId, appSecret, timestamp, JsonUtils.toJsonString(cancelOrderVo), null, null);
        String send = url + "cancelMemberOrder";
        CommonResult<Boolean> booleanCommonResult = requestService.cancelOrderMem(send, appId, appSecret, sign, timestamp, cancelOrderVo);
        return booleanCommonResult;
    }

    /**
     * 根据订单id获取司机位置
     */
    @GetMapping("/getDriverLocation/{id}")
    @Operation(summary = "第三方取消订单")
    public CommonResult<?> getDriverLocation(@PathVariable("id") Long id) {
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String[] strings = {String.valueOf(id)};
        String sign = SignUtil.sign(appId, appSecret, timestamp, null, null, strings);
        String send = url + "getDriverLocation/" + id;
        return requestService.getDriverLocation(send, appId, appSecret, sign, timestamp);
    }

    @PermitAll
    @GetMapping("/queryOrderMatchStatus/{id}")
    @Operation(summary = "主动查询订单的匹配状态")
    public CommonResult<OrderMatchStatusVo> queryOrderMatchStatus(@PathVariable("id") Long id) {
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String[] strings = {String.valueOf(id)};
        String sign = SignUtil.sign(appId, appSecret, timestamp, null, null, strings);
        String send = url + "queryOrderMatchStatus/" + id;
        return requestService.queryOrderMatchStatus(send, appId, appSecret, sign, timestamp);
    }


    @GetMapping("/getOrderInfo/{id}")
    @Operation(summary = "获取订单详情")
    public CommonResult<OrderInfoVo> getOrderInfo(@PathVariable("id") Long id) {
        long l = System.currentTimeMillis();
        String timestamp = String.valueOf(l);
        String[] strings = {String.valueOf(id)};
        String sign = SignUtil.sign(appId, appSecret, timestamp, null, null, strings);
        String send = url + "getOrderInfo/" + id;
        return requestService.getOrderInfo(send, appId, appSecret, sign, timestamp);
    }
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

package com.jwcx.third.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.jwcx.third.controller.bo.MyOrderQo;
import com.jwcx.third.controller.bo.OrderBo;
import com.jwcx.third.controller.bo.TravelModeQo;
import com.jwcx.third.controller.vo.*;
import com.jwcx.third.domain.CommonResult;

import java.util.List;

/**
 * 请求第三方
 *
 * @author wangbin
 */
public interface RequestService {

    /**
     * 根据经纬度获得出行方式
     *
     * @param url          发送的地址
     * @param travelModeQo 发送的值
     * @return
     */
    @Post(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<List<TravelModeApiVo>> getTravelModeByUser(@Var("url") String url,
                                                            @Var("appId") String appId,
                                                            @Var("appSecret") String appSecret,
                                                            @Var("sign") String sign,
                                                            @Var("timestamp") String timestamp,
                                                            @JSONBody TravelModeQo travelModeQo);


    @Post(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<?> createMemberOrder(@Var("url") String url,
                                      @Var("appId") String appId,
                                      @Var("appSecret") String appSecret,
                                      @Var("sign") String sign,
                                      @Var("timestamp") String timestamp,
                                      @JSONBody OrderCreateReqVO orderCreate);


    @Post(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<Boolean> cancelOrderMem(@Var("url") String url,
                                         @Var("appId") String appId,
                                         @Var("appSecret") String appSecret,
                                         @Var("sign") String sign,
                                         @Var("timestamp") String timestamp,
                                         @JSONBody CancelOrderVo cancelOrderVo);

    @Get(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<?> getDriverLocation(@Var("url") String url,
                                      @Var("appId") String appId,
                                      @Var("appSecret") String appSecret,
                                      @Var("sign") String sign,
                                      @Var("timestamp") String timestamp);

    @Get(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<OrderMatchStatusVo> queryOrderMatchStatus(@Var("url") String url,
                                                           @Var("appId") String appId,
                                                           @Var("appSecret") String appSecret,
                                                           @Var("sign") String sign,
                                                           @Var("timestamp") String timestamp);

    @Get(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<OrderInfoVo> getOrderInfo(@Var("url") String url,
                                           @Var("appId") String appId,
                                           @Var("appSecret") String appSecret,
                                           @Var("sign") String sign,
                                           @Var("timestamp") String timestamp);


    @Post(url = "${url}", headers = {
            "Content-Type: application/json",
            "app_id: ${appId}",
            "app_secret: ${appSecret}",
            "sign: ${sign}",
            "timestamp: ${timestamp}",
    })
    CommonResult<Page<OrderBo>> queryOrderList(@Var("url") String url,
                                               @Var("appId") String appId,
                                               @Var("appSecret") String appSecret,
                                               @Var("sign") String sign,
                                               @Var("timestamp") String timestamp,
                                               @JSONBody MyOrderQo myOrderQo);
}

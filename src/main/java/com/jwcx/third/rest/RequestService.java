package com.jwcx.third.rest;

import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.jwcx.third.controller.bo.TravelModeQo;
import com.jwcx.third.controller.vo.TravelModeApiVo;
import com.jwcx.third.domain.CommonResult;

import java.util.List;

/**
 * 请求第三方
 *
 * @author wangbin
 */
public interface RequestService {

    /**
     * 司机提现
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
}

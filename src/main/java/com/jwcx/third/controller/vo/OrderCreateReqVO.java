package com.jwcx.third.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Schema(description ="管理后台 - 订单创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderCreateReqVO extends OrderBaseVO {
    /**
     * 是否是第三方订单
     */
    private Boolean third = false;

    /**
     * 回调地址
     */
    @NotBlank(message = "回调地址不得为空")
    private String callback;

}

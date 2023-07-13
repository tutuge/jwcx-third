package com.jwcx.third.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description ="订单取消实体类")
public class CancelOrderVo {

    @Schema(description = "订单ID")
    @NotNull(message = "订单id不得为空")
    private Long orderId;


    private Boolean third = false;

    /**
     * 修改人
     */
    private String updater;

}

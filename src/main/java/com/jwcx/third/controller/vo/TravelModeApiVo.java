package com.jwcx.third.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Schema(description ="出行方式")
public class TravelModeApiVo implements Serializable {

    private static final long serialVersionUID = 6316574928895510942L;

    @Schema(description = "名称")
    private String travelModeName;

    @Schema(description = "描述信息")
    private String remarks;

    @Schema(description = "图片地址")
    private String picUrl;

    @Schema(description = "预估价格")
    private BigDecimal estimatedPrice;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "出行方式类型")
    private Integer type;

    @Schema(description = "调度端ID")
    private Long tenantId;

    @Schema(description = "匹配的线路ID，包车和拼车需要")
    private Long lineId;

    @Schema(description = "运价单编码")
    private String code;
}

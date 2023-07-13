package com.jwcx.third.controller.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Schema(description = "获取出行方式查询实体")
public class TravelModeQo implements Serializable {

    private static final long serialVersionUID = -4745528042934332097L;

    @Schema(description = "调度端id")
    private Long tenantId;

    @Schema(description = "起点经度")
    @NotNull(message = "起点经度不得为空")
    private String startLongitude;

    @Schema(description = "起点纬度")
    @NotNull(message = "起点纬度不得为空")
    private String startLatitude;

    @Schema(description = "终点经度")
    @NotNull(message = "终点经度不得为空")
    private String endLongitude;

    @Schema(description = "终点纬度")
    @NotNull(message = "终点纬度不得为空")
    private String endLatitude;

    @Schema(description = "人数")
    @NotNull(message = "人数不得为空")
    private Integer peopleNum;

    @Schema(description = "距离")
    @NotNull(message = "获取出行方式距离不得为空")
    private BigDecimal distance;

    @Schema(description = "地区编码")
    private String adcode;

    @Schema(description = "预估时间")
    private BigDecimal estimatedTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "用车时间")
    private Date useTime;

}

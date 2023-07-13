package com.jwcx.third.controller.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 拓展多调度端的 BaseDO 基类
 *
 * @author 芋道源码
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class TenantBaseDO extends BaseDO {

    /**
     * 多调度端编号
     */
    private Long tenantId;

}

package com.jwcx.third.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.crypto.SecureUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.jwcx.third.utils.json.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 签名工具类
 *
 * @author wangbin
 */
@Slf4j
public class SignUtil {


    public static String sign(String appId, String appSecret, String timestamp, String body, Map<String, String[]> params, String[] paths) {
        log.info("RequestBody-->{}", body);
        log.info("RequestParam-->{}", JsonUtils.toJsonString(params));
        log.info("PathVariable-->{}", paths);
        StringBuilder sb = new StringBuilder();
        if (CharSequenceUtil.isNotBlank(body)) {
            HashMap<String, Object> stringObjectHashMap = JsonUtils.convertMap(body);
            stringObjectHashMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(paramEntry -> {
                        Object value = paramEntry.getValue();
                        if (ObjUtil.isNotNull(value)) {
                            String paramValue = value.toString();
                            sb.append(paramEntry.getKey()).append("=").append(paramValue).append('#');
                        }
                    });
            log.info("convertRequestBody-->{}", sb);
        }

        if (!CollUtil.isEmpty(params)) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(paramEntry -> {
                        String paramValue = String.join(",", Arrays.stream(paramEntry.getValue()).sorted().toArray(String[]::new));
                        sb.append(paramEntry.getKey()).append("=").append(paramValue).append('#');
                    });
        }

        if (ArrayUtil.isNotEmpty(paths)) {
            String pathValues = String.join(",", Arrays.stream(paths).sorted().toArray(String[]::new));
            sb.append(pathValues);
        }
        String string = sb.toString();
        log.info("convertResult-->{}", string);
        String join = String.join("#", appId, appSecret, timestamp, string);
        log.info("join-->{}", join);
        String sign = SecureUtil.sha256(join);
        log.info("sign-->{}", sign);
        return sign;
    }
}

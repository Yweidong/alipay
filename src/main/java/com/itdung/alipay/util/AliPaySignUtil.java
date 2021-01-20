package com.itdung.alipay.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.itdung.alipay.config.AlipayConfig;
import lombok.Setter;

import java.util.Map;

/**
 * @program: alipay
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2021-01-15 11:36
 **/
public class AliPaySignUtil {


    public static boolean signVerified(Map<String, String> paramsMap){
        boolean signVerified = false;//调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type
            );
        } catch (AlipayApiException e) {
            e.printStackTrace();

        }
        return signVerified;
    }
}

package com.itdung.alipay.config;

/**
 * @program: alipay
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2021-01-15 10:17
 **/
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092700608799";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCWx/4BY1HMMrBdsj+JP6hoNvWNdECPis8dS+i1AmOHgPD03krxYn55rYLw4Y90oF9LmjzIRpy6HLeO3C/sTAioyW2iBHSpikxPCB/zXPpWuGHTgzg8OfRu86Aup8TgotHBQHkK5WstD4F1l4ALxVkS8Pkl4Jp/OCmlKZnBw7H4mO56jatWRFa8ePb4an2f15/OSJHER4EFJIMJUGbjX27rZp9Fsfo9Ej8iuvqIa4c5rrnJ71atS+3NL0lk+uuHr6IXawQsE67pXHLEC9L1XTjqNY8Lek8YBpNK/gjOYQJKVdjkg89elpxHVQaoA9DKYLsrgp/Qb3kJ7UBOP7+fFlb9AgMBAAECggEAfcB6Jaox1D4KPXql5s/CongDv1/PYGgCaIqgoCZH4AE39OFYW40rskt1w3Q7cqc2ExWlz9qkZ8v/gxQ8m7SmHC8yUkepDKUdE2TRUOSgnKbWX9M2mXQ0WjyxwXeGiVsB2UzuJppEEqa1797UmfyTV2rGQELcV3H9uZPCeom96nhHhQP8HEJGL2nri/pKlESY6gBlOBmZxW6vgE22SeZh17L1HqlQ80v+l8airttmUNyz8wpqH92M/e3tGEjBSCz7t9lKe70XHHaYrWUwdHhIrxBg7N/XdQoDYhTHuCnlN4Mp4F6VdH8+NE9t2MgrApPorotAwV4cIuIQgac1yP2BQQKBgQDdmaqCKzxuXyOBEF7RtS6rkRpWNpm9Ud/RqPNha3HSS0KCZrphcPcRjoJ3LNnJZh9zOsiV0QRMM29zGTvTiIGqnH8QsiGQ+x1l7UgoYsvzAqdFZX6kdn9HR8SI3jDitGTlJTJBLsrekMebb0HD+ztgPRzCWW1oDJYitO7lwLLJ1QKBgQCuL/8xJd4glFaeHIzfZZwzF01kXVbm13iQmHCf2ngsuRK7hwF9l3d3MEjDZ5GHqckzDr4AmDMTRpKM8tni6GDSj0DiGFl2eQsj8FZ40JgzEeHAL6ket13CmkgTho3nGBRyphvhoqB17urbeDPyz7G808Hr1Nr6kaSftAOZ6r0EiQKBgQCAzA6hZ5XRJLTTD/u8cU015LllAIks00h+aG9E4RkfvCRk/GY5ulmvt5+2ure+af+/jpwFD54q1/5f7HusP/v1eM4VmyMNTBbTJi25Y2rczF8CY7JOzpy9hkYBsvrA2U6HLK5f2l2JLKcHfYvA5+Wj0wFDKI0BW8drVrQ/j1ebHQKBgHGVTLPQvJLEB+NcPKQjzwIlzMqIbvViRfUL4kzqmfiXylZMR7WMwlMPQjNhYq1zEobfsxgSJyQHneKZLWlgHFrRHP8R36x4a8JIoypu4wBSRcIbkg08hsAx+JP65qdttU+5b27nq/ibDbyFGmLX+k9mSgqtJwnDVPTq3npMbmr5AoGACdoB57s79Av2K5ljBpgQvpPwlmiASz5joysvgiw3YRN1MXmvyj3XZgRQA94C/vlhyBl6E8HA2lbuxRBTWex9JjHmA/CZrWcpiEHXM2FRQFy+yfur1ZFP1ZulcarZOnR+r3ZX+7OdZol+Geb4d3HTvWi/x53xDNqkg9bTK4vJnfk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7/az0p93skzYuDolj/Mw5eqOHJUO6v6qM9UuHpXXoZYvCG48iAaSlbTNHqJMJPU7/3k7+G36l1lw0Nv5YHaak5hinO8emLuJibDut3JgvksqV8TSPdyefT94Z5tq4v/XwwycqD2g5dppnxd4bZ7/aZ+9iWTsmnaSwGJyZq7sxIDFCTnQWFIYd8flNWIIJAq9R5QhOyUZ0J3EjiEzGEcCACRL4G865RTZzv6lnVjHAoLdHxQR9uRykLWVA0JCjtEvvEnmI9AIZonrEh2FFBgh08P8TpVRDQM2C+Kx8GfktABdPfsr7z2onkZw90YcoqlAEvMuGnOTh50mc4cz2N6B+QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8089/alipay/callback/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8089/alipay/callback/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
//    public static String log_path = "C:\\";
}

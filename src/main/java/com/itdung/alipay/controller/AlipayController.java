package com.itdung.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.itdung.alipay.config.AlipayConfig;
import com.itdung.alipay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: alipay
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2021-01-15 11:01
 **/
@RestController
@RequestMapping("/pay")
public class AlipayController {
    @Autowired
    @Qualifier("alipayService")
    private AlipayService alipayService;

    /**
     * web 订单支付
     */
    @GetMapping("getPagePay")
    public void getPagePay(HttpServletResponse response) throws Exception{
        /** 模仿数据库，从后台调数据*/
        String outTradeNo = "19960310621210";
        Integer totalAmount = 1;
        String subject = "苹果28";

        String pay = alipayService.webPagePay(outTradeNo, totalAmount, subject);

//        System.out.println(pay);
//
//        Map<Object, Object> pays = new HashMap<>();
//        pays.put("pay", pay);
        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        response.getWriter().write(pay);
        response.getWriter().flush();
        response.getWriter().close();
//        return pays;
    }

    /**
     * app 订单支付
     */
    @GetMapping("getAppPagePay")
    public String getAppPagePay() throws Exception{
        /** 模仿数据库，从后台调数据*/
        String outTradeNo = "131233";
        Integer totalAmount = 1000;
        String subject = "天猫超市012";

        String pay = alipayService.appPagePay(outTradeNo, totalAmount, subject);

//        Object json = JSONObject.toJSON(pay);

//        System.out.println(json);

        return pay;
    }

    /**
     * 交易查询
     */
    @PostMapping("aipayQuery")
    public String alipayQuery() throws Exception{
        /**调取支付订单号*/
        String outTradeNo = "19960310621212";

        String query = alipayService.query(outTradeNo);

//        Object json = JSONObject.toJSON(query);

        /*JSONObject jObject = new JSONObject();
        jObject.get(query);*/
        return query;
    }

    /**
     * 退款
     * @throws AlipayApiException
     */
    @GetMapping("alipayRefund")
    public String alipayRefund(
            @RequestParam("outTradeNo")String outTradeNo,
            @RequestParam(value = "outRequestNo", required = false)String outRequestNo,
            @RequestParam(value = "refundAmount", required = false)Integer refundAmount
    ) throws AlipayApiException {

        /** 调取数据*/
        //String outTradeNo = "15382028806591197";
        String refundReason = "用户不想购买";
        //refundAmount = 1;
        //outRequestNo = "22";

        String refund = alipayService.refund(outTradeNo, refundReason, refundAmount, outRequestNo);

        System.out.println(refund);

//        return ResultTool.success(refund);
        return refund;
    }


    /**
     * 退款查询
     * @throws AlipayApiException
     */
    @PostMapping("refundQuery")
    public String refundQuery() throws AlipayApiException{

        /** 调取数据*/
        String outTradeNo = "13123";
        String outRequestNo = "2";

        String refund = alipayService.refundQuery(outTradeNo, outRequestNo);

        return refund;

    }

    /**
     * 交易关闭
     * @throws AlipayApiException
     */
    @PostMapping("alipayclose")
    public String alipaycolse() throws AlipayApiException{

        /** 调取数据*/
        String outTradeNo = "13123";

        String close = alipayService.close(outTradeNo);

        return close;
    }

}

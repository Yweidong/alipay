package com.itdung.alipay.controller;

import com.itdung.alipay.util.AliPaySignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: alipay
 * @description:
 * @author: ywd
 * @contact:1371690483@qq.com
 * @create: 2021-01-15 11:35
 **/
@Controller
@RequestMapping(value = "/alipay/callback")
@Slf4j
public class CallBackController {




    @GetMapping("/return")
    public void payReturn(HttpServletRequest request, HttpServletResponse response){

        Map<String,String> params = getParams(request);

        boolean signVerified = AliPaySignUtil.signVerified(params);
        if(signVerified){
            log.info("安全参数验证成功");
            //商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            //支付宝交易号
            String trade_no = request.getParameter("trade_no");
            //付款金额
            String total_amount = request.getParameter("total_amount");
            try {
//                response.sendRedirect("/index.html?id="+out_trade_no);
                response.getWriter().write(
                        "trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("收到支付同步通知，回调商户页面失败【{}】",params);
            }
        }else{
            log.info("安全参数验证失败【{}】",params);
        }

    }

    /**
     * 支付异步通知：更改支付状态
     * @param request
     * @param response
     */
    @PostMapping("/notify")
    public void payNotify(HttpServletRequest request,HttpServletResponse response){
        Map<String,String> params = getParams(request);

        boolean signVerified = AliPaySignUtil.signVerified(params);
        if(signVerified){

                // TODO 支付成功业务逻辑处理
            String trade_status = request.getParameter("trade_status");
            // TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
            // TRADE_SUCCESS(表示交易已经成功结束，可以对该交易做后续操作，如：分润、退款等);
              if (trade_status.equals("TRADE_FINISHED")) {
                  //判断该笔订单是否在商户网站中已经做过处理
                  //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，
                  // 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），并执行商户的业务程序
                  //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                  //如果有做过处理，不执行商户的业务程序

                  //注意：
                  //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                  //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                    log.info("TRADE_FINISHED");
              }else if (trade_status.equals("TRADE_SUCCESS")) {
                  //判断该笔订单是否在商户网站中已经做过处理
                  //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，
                  // 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），并执行商户的业务程序
                  //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                  //如果有做过处理，不执行商户的业务程序

                  //注意：
                  //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                    log.info("TRADE_SUCCESS");
              }
            log.info("测试");

            log.info("安全参数验证成功1111");
            response.setContentType("text/html;charset=UTF-8" );
            try {
                response.getWriter().write("success");
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("异步通知处理失败");
            }
        }else{
            log.info("安全参数验证失败");
        }
    }


    private Map<String,String> getParams(HttpServletRequest request){
        Map<String,String> params = new HashMap<>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int j = 0; j < values.length; j++) {
                valueStr = (j == values.length - 1) ? valueStr + values[j] : valueStr + values[j] + ",";
            }
            params.put(name, valueStr);
        }
        return params;
    }

}

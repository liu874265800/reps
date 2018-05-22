package org.mail.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.mail.service.other.SmsConfig;

import net.sf.json.JSONObject;
 
/**
 * 短信工具类
 * @author VIC
 *
 */
public class SmsUtil {
	
	private static SmsConfig smsConfig = SmsConfig.getInstance();
 
    /**
     * 屏蔽词检查
     */
    public static String checkShieldingWord(String word){
        String result = null;
        Map params = new HashMap();//请求参数
        params.put("word", word);//需要检测的短信内容，需要UTF8 URLENCODE
        params.put("key", smsConfig.getKey());
 
        try {
            result =sendRequest(smsConfig.getBlockUrl(), params, "GET");
            JSONObject object = JSONObject.fromObject(result);
//            if(object.getInt("error_code")==0){
//                System.out.println(object.get("result"));
//            }else{
//                System.out.println(object.get("error_code")+":"+object.get("reason"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    /**
     * 发送短信
     * @param message
     * @param mobile
     * @return
     */
    public static String sendMessage(String message,String mobile){
        String result =null;
        Map params = new HashMap();//请求参数
            params.put("mobile",mobile);//接收短信的手机号码
            params.put("tpl_id","77474");//短信模板ID，请参考个人中心短信模板设置
            params.put("tpl_value","#code#="+message);//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href="http://www.juhe.cn/news/index/id/50" target="_blank">详细说明></a>
            params.put("key",smsConfig.getKey());//应用APPKEY(应用详细页查询)
            params.put("dtype","json");//返回数据的格式,xml或json，默认json
 
        try {
            result = sendRequest(smsConfig.getSendUrl(), params, "GET");
//            JSONObject object = JSONObject.fromObject(result);
//            if(object.getInt("error_code")==0){
//                System.out.println(object.get("result"));
//            }else{
//                System.out.println(object.get("error_code")+":"+object.get("reason"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    /**
     * 发送网络请求
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    private static String sendRequest(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", smsConfig.getUserAgent());
            conn.setUseCaches(false);
            conn.setConnectTimeout(smsConfig.getConnectTimeOut());
            conn.setReadTimeout(smsConfig.getReadTimeOut());
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                        out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, smsConfig.getCharset()));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
 
    /**
     * 将map型转为请求参数型
     * @param data
     * @return
     */
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

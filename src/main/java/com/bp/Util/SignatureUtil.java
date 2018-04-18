package com.bp.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SignatureUtil {


    protected static final Logger logger = LoggerFactory.getLogger(SignatureUtil.class);

    private static String SHA1(String decript) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(decript.getBytes("UTF-8"));
        Formatter formatter = new Formatter();
        for (byte b : crypt.digest())
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();

        return result;
    }

    public static String getSignature(String url, String noncestr, String timestamp) throws ExecutionException, UnsupportedEncodingException, NoSuchAlgorithmException {

        String jsapi_ticket = cache.get("jsapi_ticket", new Callable<String>() {
            public String call() {
                String access_token = getAccessToken();
                String jsapi_ticket = getTicket(access_token);

                return jsapi_ticket;
            }
            private  String getAccessToken() {
                String access_token = "";
                String grant_type = "client_credential";//获取access_token填写client_credential
                String AppId = "wx06f46613a79ad9cc";//第三方用户唯一凭证
                String secret = "f02e5c2aad054192dee5a1464285a47e";//第三方用户唯一凭证密钥，即appsecret
                //这个url链接地址和参数皆不能变
                String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + grant_type + "&appid=" + AppId + "&secret=" + secret;

                try {
                    URL urlGet = new URL(url);
                    HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
                    http.setRequestMethod("GET"); // 必须是get方式请求
                    http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    http.setDoOutput(true);
                    http.setDoInput(true);
                    System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
                    System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
                    http.connect();
                    InputStream is = http.getInputStream();
                    int size = is.available();
                    byte[] jsonBytes = new byte[size];
                    is.read(jsonBytes);
                    String message = new String(jsonBytes, "UTF-8");
                    JSONObject demoJson = JSONObject.fromObject(message);
                    System.out.println("JSON字符串：" + demoJson);
                    access_token = demoJson.getString("access_token");
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return access_token;
            }
            private String getTicket(String access_token) {
                String ticket = null;
                String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";//这个url链接和参数不能变
                try {
                    URL urlGet = new URL(url);
                    HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
                    http.setRequestMethod("GET"); // 必须是get方式请求
                    http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    http.setDoOutput(true);
                    http.setDoInput(true);
                    System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
                    System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
                    http.connect();
                    InputStream is = http.getInputStream();
                    int size = is.available();
                    byte[] jsonBytes = new byte[size];
                    is.read(jsonBytes);
                    String message = new String(jsonBytes, "UTF-8");
                    ObjectMapper mapper = new ObjectMapper();
                    JSONObject demoJson = JSONObject.fromObject(message);
                    System.out.println("JSON字符串：" + demoJson);
                    ticket = demoJson.getString("ticket");
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ticket;
            }
        });
        String str = "jsapi_ticket=" + jsapi_ticket +
                            "&noncestr=" + noncestr +
                            "&timestamp=" + timestamp +
                            "&url=" + url;

        return SHA1(str);
    }


    private static Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(7000, TimeUnit.SECONDS).maximumSize(100).build();

}

package com.bp.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
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

    private static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static String getSignature(String url, String noicestr, String timestamp) throws ExecutionException {

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

        String signature = "jsapi_ticket="+jsapi_ticket;
        signature += "&noncestr="+noicestr;
        signature += "&timestamp="+timestamp;
        signature += "&url="+url;

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(signature.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (Exception e) {
            logger.error("Signature for SHA-1 is error:{}",e);
        }
        return signature;
    }

    private static Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(7000, TimeUnit.SECONDS).maximumSize(100).build();

}

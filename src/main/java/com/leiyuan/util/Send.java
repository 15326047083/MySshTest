package com.leiyuan.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Administrator
 */
public class Send {

    public static String sendCode(String phone) throws UnsupportedEncodingException {
        String code = (int) ((Math.random() * 9 + 1) * 1000) + "";
        String PostData = "account=Ljq123456&password=Ljq123456&mobile=" + phone + "&content=" + java.net.URLEncoder
                .encode
                        ("您的订单编码：" + code + "。如需帮助请联系客服。", "utf-8");
        SMS(PostData, "http://sms.106jiekou.com/utf8/sms.aspx");
        return code;
    }

    public static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
}

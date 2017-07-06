package com.glidedemo.zhuxiao.glidedemo.net;

import android.util.Log;

import com.glidedemo.zhuxiao.glidedemo.utils.Constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zhuxiao on 2016/5/11.
 */
public class RequestUtils {
    private final static boolean isDebug = Constants.DEBUG;
    private final static String TAG = "RequestUtils";
    private final static int READ_TIMEOUT_TIME=5000;
    private final static int CON_TIMEOUT_TIME=3000;
    public final static String POST_NAME="POST";
    public final static String GET_NAME="GET";
    public  String requestStr(String url, String params, String method) {
        String result=null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            if(method==null){
                method=POST_NAME;
            }
            method = method.toUpperCase();
            connection.setRequestMethod(method);
            /*Sets the maximum time to wait for an input stream read to complete before giving up.
             Reading will fail with a SocketTimeoutException if the timeout elapses before data becomes available.
             The default value of 0 disables read timeouts; read attempts will block indefinitely.*/
            connection.setReadTimeout(READ_TIMEOUT_TIME);
            connection.setConnectTimeout(CON_TIMEOUT_TIME);

            if(POST_NAME.equals(method)){
                if(params==null){
                    params="";
                }
                //设置请求数据方式
                connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                //请求头，请求参数的长度
                connection.setRequestProperty("Content-Length",""+params.length());
                //请求体，请求的数据
                /*Sets the flag indicating whether this URLConnection allows output. It cannot be set after the connection is established   允许输出流,默认是false.*/
                connection.setDoOutput(true);
                connection.getOutputStream().write(params.getBytes());
            }
            //获取inputstream
            int responseCode = connection.getResponseCode();
            if(isDebug){
                Log.d(TAG,"url:"+url);
                Log.d(TAG,"params:"+params);
                Log.d(TAG,"method:"+method);
                Log.d(TAG,"responseCode:"+responseCode);
            }
            if(responseCode==200){
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len=0;
                while((len=inputStream.read(buffer))>0){
                    outputStream.write(buffer,0,len);
                }
                result = outputStream.toString();
                if(isDebug){
                    Log.d(TAG,"result:"+result);
                }
            }else{
//                Toast.makeText()
            }
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        return result;
    }
}

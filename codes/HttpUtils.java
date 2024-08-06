package com.demo.restful;  
  
import org.apache.http.HttpEntity;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.config.RequestConfig;  
import org.apache.http.client.methods.CloseableHttpResponse;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.client.methods.HttpUriRequest;  
import org.apache.http.config.Registry;  
import org.apache.http.config.RegistryBuilder;  
import org.apache.http.conn.socket.ConnectionSocketFactory;  
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;  
import org.apache.http.conn.socket.PlainConnectionSocketFactory;  
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;  
import org.apache.http.conn.ssl.SSLInitializationException;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
  
import java.io.IOException;  
import java.net.URLEncoder;  
import java.security.KeyManagementException;  
import java.security.NoSuchAlgorithmException;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
import javax.net.ssl.SSLContext;  
import org.apache.commons.lang.StringUtils;  
import org.apache.http.client.config.CookieSpecs;  
  
public final class HttpUtils {  
  
    final static PoolingHttpClientConnectionManager CONNMGR;  
    final static CloseableHttpClient CLIENT;  
    private static final int MAX_PER_ROUTE = 200;  
    private static final int MAXTOTAL = 200;  
    private static final int VALIDATE_AFTER_INACTIVITY = 1000;  
    private static final int CONNECTION_TIMEOUT = 60000;  
  
    static {  
        LayeredConnectionSocketFactory ssl = null;  
        try {  
            ssl = SSLConnectionSocketFactory.getSystemSocketFactory();  
        } catch (final SSLInitializationException ex) {  
            final SSLContext sslcontext;  
            try {  
                sslcontext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);  
                sslcontext.init(null, null, null);  
                ssl = new SSLConnectionSocketFactory(sslcontext);  
            } catch (final SecurityException ignore) {  
            } catch (final KeyManagementException ignore) {  
            } catch (final NoSuchAlgorithmException ignore) {  
            }  
        }  
  
        RequestConfig config = RequestConfig.custom()  
                .setConnectTimeout(CONNECTION_TIMEOUT)  
                .setConnectionRequestTimeout(CONNECTION_TIMEOUT)  
                .setCookieSpec(CookieSpecs.STANDARD)  
                .setSocketTimeout(CONNECTION_TIMEOUT).build();  
  
        final Registry<ConnectionSocketFactory> sfr = RegistryBuilder.<ConnectionSocketFactory>create()  
                .register("http", PlainConnectionSocketFactory.getSocketFactory())  
                .register("https", ssl != null ? ssl : SSLConnectionSocketFactory.getSocketFactory())  
                .build();  
  
        CONNMGR = new PoolingHttpClientConnectionManager(sfr);  
        CONNMGR.setDefaultMaxPerRoute(MAX_PER_ROUTE);  
        CONNMGR.setMaxTotal(MAXTOTAL);  
        CONNMGR.setValidateAfterInactivity(VALIDATE_AFTER_INACTIVITY);  
        CLIENT = HttpClients.custom().setConnectionManager(CONNMGR).setDefaultRequestConfig(config).build();  
    }  
  
    public HttpUtils() {  
    }  
  
    public static String get(String url, String authorization, Map<String, String> queryParams) throws IOException {  
        List<NameValuePair> params = new ArrayList<>();  
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {  
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
        }  
        return get(url, authorization, params, null);  
    }  
  
    public static String get(String url, String authorization, Map<String, String> queryParams,  
            Map<String, String> headers) throws IOException {  
        List<NameValuePair> params = new ArrayList<>();  
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {  
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
        }  
        return get(url, authorization, params, headers);  
    }  
  
    public static String get(String url, String authorization, List<NameValuePair> queryParams) throws IOException {  
        return get(url, authorization, queryParams, null);  
    }  
  
    public static String get(String url, String authorization, List<NameValuePair> queryParams,  
            Map<String, String> headers) throws IOException {  
        CloseableHttpResponse response = null;  
        StringBuilder requestParams = new StringBuilder();  
        for (NameValuePair queryParam : queryParams) {  
            requestParams.append(URLEncoder.encode(queryParam.getName(), "UTF-8")).append("=").append(URLEncoder.encode(String.valueOf(queryParam.getValue()), "UTF-8")).append("&");  
        }  
  
        if (requestParams.capacity() > 0) {  
            url = url + "?" + StringUtils.stripEnd(requestParams.toString(), "&");  
        }  
        HttpUriRequest request = new HttpGet(url);  
        // add header for request.  
        if (headers != null && !headers.isEmpty()) {  
            for (Map.Entry<String, String> i : headers.entrySet()) {  
                request.addHeader(i.getKey(), i.getValue());  
            }  
        }  
        request.addHeader("Authorization", authorization);  
        request.addHeader("Accept", " application/json");  
        request.addHeader("Accept-Encoding", "gzip, deflate");  
        response = CLIENT.execute(request);  
        HttpEntity entity = response.getEntity();  
  
        String responseString = "";  
        if (entity != null) {  
            responseString = EntityUtils.toString(entity, "UTF-8");  
        }  
  
        return responseString;  
    }  
  
    public static String post(String url, String authorization, String requestPayload) throws IOException {  
        HttpPost httpPost = new HttpPost(url);  
        httpPost.addHeader("Authorization", authorization);  
        httpPost.addHeader("Accept", " application/json");  
        httpPost.setHeader("Content-type", "application/json");  
        StringEntity strEntity = new StringEntity(requestPayload);  
        httpPost.setEntity(strEntity);  
        CloseableHttpResponse response = CLIENT.execute(httpPost);  
        HttpEntity entity = response.getEntity();  
        String responseString = EntityUtils.toString(entity, "UTF-8");  
        return responseString;  
    }  
    public static String post(String url, String authorization, Map<String, String> queryParams,  
            Map<String, String> headers) throws IOException {  
        StringBuilder requestParams = new StringBuilder();  
        if (queryParams != null && !queryParams.isEmpty()) {  
            for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {  
                requestParams.append(URLEncoder.encode(queryParam.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(String.valueOf(queryParam.getValue()), "UTF-8")).append("&");  
            }  
        }  
        if (requestParams.capacity() > 0) {  
            url = url + "?" + StringUtils.stripEnd(requestParams.toString(), "&");  
        }  
        HttpPost httpPost = new HttpPost(url);  
          
        httpPost.addHeader("Authorization", authorization);  
        httpPost.addHeader("Accept", " application/json");  
        httpPost.setHeader("Content-type", "application/json");  
        // add header for request.  
        if (headers != null && !headers.isEmpty()) {  
            for (Map.Entry<String, String> i : headers.entrySet()) {  
                httpPost.addHeader(i.getKey(), i.getValue());  
            }  
        }  
        CloseableHttpResponse response = CLIENT.execute(httpPost);  
        HttpEntity entity = response.getEntity();  
        String responseString = EntityUtils.toString(entity, "UTF-8");  
        return responseString;  
    }  
}  

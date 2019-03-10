package com.course.config;

import lombok.Data;
import org.apache.http.impl.client.DefaultHttpClient;


@Data
public class TestConfig {

    //1.0绑定接口(根据设备号)uri
    public static String bindUrl;
    //1.1 绑定接口(根据店铺类型)uri
    public static String bindingWithShopTypeUrl;
    //2.解绑接口
    public static String ubinding;



    //用来存储cookies信息的变量
    public static org.apache.http.client.CookieStore store;
    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;

}

package com.course.cases;


import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.utils.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class bindTest {



    @Test(description = "1.0 绑定接口(根据设备号)")
    public void BindCase() throws IOException{
        HttpPost post = new HttpPost(TestConfig.bindUrl);
        JSONObject param = new JSONObject();
        //设置请求头信息，设置Header
        post.setHeader("content-type","application/json");
        //设置cookies信息
        TestConfig.defaultHttpClient.setCookieStore((CookieStore) TestConfig.store);
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        HttpResponse response =  TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
